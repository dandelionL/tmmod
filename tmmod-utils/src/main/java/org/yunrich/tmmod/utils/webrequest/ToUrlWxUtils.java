package org.yunrich.tmmod.utils.webrequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.log4j.Logger;
import org.yunrich.tmmod.utils.MyX509TrustManager;
import org.yunrich.tmmod.utils.webrequest.pojo.AccessToken;
import org.yunrich.tmmod.utils.webrequest.pojo.WeixinOauth2Token;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 
 * @author DandenlionL
 * @version $Id: ToUrlWxUtils.java, v 0.1 2015-12-16 下午5:07:44 DandenlionL Exp $
 */
public class ToUrlWxUtils {
    private static Logger log = Logger.getLogger(ToUrlWxUtils.class);

    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public final static String oauth2_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    public final static String oauth2_token_fresh_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    
    public final static String oauth2_authorize_url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };
            //SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE"); 
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();
  
            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
  
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();
  
            // 当有数据需要提交时  
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));
                System.out.println(outputStr);
                outputStream.close();
            }
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
  
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源  
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
        	log.error("https ConnectException[{}]",ce);
        } catch (Exception e) {
        	log.error("https Exception[{}]",e);
        }
        return jsonObject;
    }

    public static  AccessToken getToAccessToken(String appid, String appsecret){
        AccessToken accessToken = null;
      
        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功  
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败  
                log.error("获取token失败 errcode:{"+jsonObject.getInt("errcode")+"} errmsg:{"+jsonObject.getString("errmsg")+"}",e );
            }
        }
        return accessToken;
    }
    
    public static WeixinOauth2Token getOauth2AccessToken(String appId,String appSecret,String code){
        WeixinOauth2Token wat = null;
        String requestUrl = oauth2_token_url.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        System.out.println("requestUrl:"+requestUrl);
        
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        System.out.println(jsonObject);
        if(null != jsonObject){
            try {
                wat  = new WeixinOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInt("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                wat = null;
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取网页授权凭证失败errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
            }
        }
        return wat;
    }
    
    public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken){
        WeixinOauth2Token wat  = null;
        String requestUrl = oauth2_token_fresh_url.replace("APPID", appId);
        requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
        
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        
        if(null != jsonObject) {
            try {
                wat  = new WeixinOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInt("expires_in"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setScope(jsonObject.getString("scope"));
            } catch (Exception e) {
                wat = null ; 
                int errorCode = jsonObject.getInt("errcode");
                String errMsg = jsonObject.getString("errmsg");
                log.error("刷新页面授权凭证失败 errcode:{"+errorCode+"} errmsg:{"+errMsg+"}");
            }
        }
        return wat;
    }
    
    public static String urlEncodeUTF8(String source){
        String result = source;
        try {
            result = URLEncoder.encode(source,"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static String getOauthRequestUrl(String appId,String redirectUrl,String scope,String state){
        redirectUrl = urlEncodeUTF8(redirectUrl);
        String requestUrl = oauth2_authorize_url.replace("APPID", appId).replace("REDIRECT_URI", redirectUrl).replace("SCOPE", scope).replace("STATE", state);
        return requestUrl;
    }

  
}
