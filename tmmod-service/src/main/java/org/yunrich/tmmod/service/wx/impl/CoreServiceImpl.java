package org.yunrich.tmmod.service.wx.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunrich.tmmod.dal.model.UserInfoDO;
import org.yunrich.tmmod.service.wx.CoreService;
import org.yunrich.tmmod.service.wx.WxUserInfoManager;
import org.yunrich.tmmod.utils.common.WxConstantMessage;
import org.yunrich.tmmod.utils.webrequest.MessageUtil;
import org.yunrich.tmmod.utils.webrequest.ToUrlWxUtils;
import org.yunrich.tmmod.utils.webrequest.vo.Article;
import org.yunrich.tmmod.utils.webrequest.vo.NewsMessage;
import org.yunrich.tmmod.utils.webrequest.vo.TextMessage;


/**
 * 
 * @author DandenlionL
 * @version $Id: CoreServiceImpl.java, v 0.1 2015-12-15 上午11:49:07 DandenlionL Exp $
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService {
	private final Logger logger = LoggerFactory.getLogger(CoreServiceImpl.class);
	
	@Autowired
	private WxUserInfoManager wxUserInfoManager;

    /** 
     * @see com.yunrich.service.base.CoreService#processRequest(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String processRequest(HttpServletRequest request) {
        String codeStr = "" +  new Date().getTime();//日志追踪
        
        String respMessage = null;
        String domain =  WxConstantMessage.SYS_URL;
        try {
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");
            // 消息类型  
            String msgType = requestMap.get("MsgType");

            //检测账号是否被绑定
            boolean isBinding = false;
            List<UserInfoDO> userInfoDOList = wxUserInfoManager.selectByWxOperId(fromUserName, codeStr);
            if(!CollectionUtils.isEmpty(userInfoDOList)) {
                isBinding = true;
                logger.info("code[{}]总入口分流：该微信号[{}]已经绑定",codeStr,fromUserName);
            }else{
            	logger.info("code[{}]总入口分流：该微信号[{}]未绑定",codeStr,fromUserName);
            	String title = "欢迎使用"+ WxConstantMessage.SYS_TITLE ;
                String description = "微信用户绑定";
                String toUrl = domain+"/klScatter/binding";
                String state = "binding";
                respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
            }
            
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "为了更好的为您服务，请使用功能菜单，谢谢！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.messageToXml(textMessage);
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "为了更好的为您服务，请使用功能菜单，谢谢！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.messageToXml(textMessage);
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "为了更好的为您服务，请使用功能菜单，谢谢！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.messageToXml(textMessage);
            }
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "为了更好的为您服务，请使用功能菜单，谢谢！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.messageToXml(textMessage);
            }
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "为了更好的为您服务，请使用功能菜单，谢谢！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.messageToXml(textMessage);
            }
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型  
                String eventType = requestMap.get("Event");
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "欢迎关注" + WxConstantMessage.SYS_TITLE ;
                    textMessage.setContent(respContent);
                    respMessage = MessageUtil.messageToXml(textMessage);
                }
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    //取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    if(!isBinding){
                        String title = "欢迎使用"+ WxConstantMessage.SYS_TITLE ;
                        String description = "我们开始测试啦：本次测试活体识别";
                        String toUrl = domain+"/biz/binding";
                        String state = "binding";
                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
                    }
//                    
//                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
//                    String eventKey = requestMap.get("EventKey");
//                    if(eventKey.equals("cash_info_details") && isBlinding){
//                        //查询结算卡信息
//                        CardInfoDto dto  = cardInfoManager.getDefaultCardInfo(custId);
//                        if(dto !=null){
//                            String cardName = StringUtil.defaultIfBlank(dto.getCardName());
//                            String cardId = StringUtil.defaultIfBlank(CommonUtils.maskCardNo(dto.getCardId()));
//                            String branchName = StringUtil.defaultIfBlank(dto.getBranchName());
//                            respContent = "尊敬的商户，以下为您的结算卡信息\n\n户名："+cardName+"\n卡号："+cardId+"\n开户行："+branchName;
//                        }else {
//                            respContent = "尊敬的商户，您尚未绑定结算卡！\n请联系客户人员进行绑定！";
//                        }
//                        textMessage.setContent(respContent);
//                        respMessage = MessageUtil.messageToXml(textMessage);
//                    
//                    }else if (eventKey.equals("cash") && isBlinding) {
//                        //提现--当前仅仅支持活期提现
//                       QueryLicaiAcctInfoResult result =  lcAcctInfoManager.getLcAcciInfo(custId);
//                        if(result == null || "0".equals(result.getCurrentDepositBal())) {
//                            respContent = "尊敬的商户，\n\n本功能可以提取您活期租金宝中的资金！\n当前查询到您活期租金宝中可提取资金为0.00元！";
//                            textMessage.setContent(respContent);
//                            respMessage = MessageUtil.messageToXml(textMessage);
//                        }else {
//                            String title = "取现";
//                            String description = "尊敬的商户，\n\n本功能可以取现您活期租金宝中的资金，\n您当前活期租金宝可取现金额为"+result.getCurrentDepositBal()+"元！\n\n如果您需要取现定期租金宝中的资金，\n请前往租金宝管理功能进行操作！";
//                            String toUrl = domain+"/req/first/cash";
//                            String state  = "cash";
//                            respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                        }
//                    }else if (eventKey.equals("out_trf") && isBlinding) {
//                        OperAuthInfoDo condition = new OperAuthInfoDo();
//                        condition.setCustId(custId);
//                        condition.setOperSeqId(operSeqId);
//                        condition.setLevel1Id("TRSFER");
//                        condition.setAuthId("0100");
//                        List<OperAuthInfoDo> list = operAuthInfoMapper.getOperAuthInfoListByKey(condition);
//                        if(list==null || list.size()==0){
//                            respContent = "尊敬的商户，\n\n该功能暂未开放！";
//                            textMessage.setContent(respContent);
//                            respMessage = MessageUtil.messageToXml(textMessage);
//                        }else{
//                          //对外转账--当前仅仅支持活期提现
//                            QueryLicaiAcctInfoResult result =  lcAcctInfoManager.getLcAcciInfo(custId);
//                             if(result == null || "0".equals(result.getCurrentDepositBal())) {
//                                 respContent = "尊敬的商户，\n\n您可以使用本功能进行转账汇款，\n当前查询到您可转账资金为0.00元！";
//                                 textMessage.setContent(respContent);
//                                 respMessage = MessageUtil.messageToXml(textMessage);
//                             }else {
//                                 String title = "转账汇款";
//                                 String description = "尊敬的商户，\n\n您可以使用本功能进行转账汇款，\n您当前可转账金额为"+result.getCurrentDepositBal()+"元！";
//                                 String toUrl = domain+"/req/first/outTrf";
//                                 String state  = "outTrf";
//                                 respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                             }
//                        }
//                    }else if (eventKey.equals("account_details") && isBlinding) {
//                        //账户余额查询
//                        MonsterLoggerUtils.info(logger, "==============余额查询================");
//                        StringBuffer sb = new StringBuffer();
//                        try{
//                            Money recvAcctBal =  acctInfoManager.getRecvAcctInfoAcctBal(custId);
//                        
//                            sb.append("尊敬的商户，\n")
//                                .append("您当前账户余额情况如下：\n\n收款户余额："+CurrencyUtils.format2CurrencyFormatOrNull(recvAcctBal.getAmount()))
//                                .append("\n");
//                        }catch(Exception e){
//                            sb.append("尊敬的商户，\n")
//                            .append("系统错误，请稍后再试！！")
//                            .append("\n");
//                        }
//                        respContent = sb.toString(); 
//                        textMessage.setContent(respContent);
//                        respMessage = MessageUtil.messageToXml(textMessage);
//                    }else  if (eventKey.equals("today_recv") && isBlinding) {
//                        Money recvAcctBal =  acctInfoManager.getRecvAcctInfoAcctBal(custId);
//                        String title = "当日收款";
//                        String description = "尊敬的商户，\n您当日收款总金额为"+recvAcctBal.getYuan()+"。\n\n点击本消息查看详情";
//                        String toUrl = domain+"/req/first/todayRecv";
//                        String state  = "getTodayRecv";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                    }else if (eventKey.equals("trans_details") && isBlinding) {
//                        String title = "收款明细";
//                        String description = "尊敬的商户，\n\n点击本消息查看收款明细";
//                        String toUrl = domain+"/req/first/transDetails";
//                        String state  = "transDetails";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                    }else if (eventKey.equals("cashLog_details") && isBlinding) {
//                        //账务明细查询
//                        String title = "取现明细";
//                        String description = "尊敬的商户，\n\n点击本消息查看取现明细详情";
//                        String toUrl = domain+"/req/first/cashLogDetails";
//                        String state  = "cashLogDetails";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                    }else if(eventKey.equals("out_trf_details")&& isBlinding){
//                        OperAuthInfoDo condition = new OperAuthInfoDo();
//                        condition.setCustId(custId);
//                        condition.setOperSeqId(operSeqId);
//                        condition.setLevel1Id("TRSFER");
//                        condition.setAuthId("0500");
//                        List<OperAuthInfoDo> list = operAuthInfoMapper.getOperAuthInfoListByKey(condition);
//                        if(list==null || list.size()==0){
//                            respContent = "尊敬的商户，\n\n该功能暂未开放！";
//                            textMessage.setContent(respContent);
//                            respMessage = MessageUtil.messageToXml(textMessage);
//                        }else{
//                            String title = "转账明细";
//                            String description = "尊敬的商户，\n\n点击本消息查看转账明细";
//                            String toUrl = domain+"/req/first/trsferLogDetails";
//                            String state  = "trsferLogDetails";
//                            respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                        }
//                    }else if (eventKey.equals("acct_details") && isBlinding) {
//                        //账务明细查询
//                        String title = "账务明细查询";
//                        String description = "尊敬的商户，\n\n点击本消息查看账务明细详情";
//                        String toUrl = domain+"/req/first/acctDetails";
//                        String state  = "acctDetails";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                    }else if (eventKey.equals("buy_fixed_zjb") && isBlinding) {
//                        //定期租金宝购买
//                        QueryLicaiAcctInfoResult result =  lcAcctInfoManager.getLcAcciInfo(custId);
//                        if(result == null || "0".equals(result.getCurrentDepositBal())) {
//                            respContent = "尊敬的商户，\n\n您可以通过本功能购买定期租金宝！！\n当前查询到您购买定期租金宝可用余额为0.00！";
//                            textMessage.setContent(respContent);
//                            respMessage = MessageUtil.messageToXml(textMessage);
//                        }else {
//                            String title = "定期租金宝购买";
//                            String description = "尊敬的商户，\n\n您可以通过本功能购买定期租金宝！！\n当前查询到您购买定期租金宝可用余额为"+result.getCurrentDepositBal()+"元！\n\n请点击本消息进行后续操作！";
//                            String toUrl = domain+"/req/second/buyFixedZjb";
//                            String state  = "buyFixedZjb";
//                            respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                        }
//                    }else if (eventKey.equals("manage_fixed_zjb") && isBlinding) {
//                        
//                        String title = "定期租金宝管理";
//                        String description = "尊敬的商户，\n\n点击本消息进行定期租金宝管理。";
//                        String toUrl = domain+"/req/second/manageFixedZjb";
//                        String state  = "manageFixedZjb";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                        
//                    }else if (eventKey.equals("cur_zjb_details") && isBlinding) {
//                        String title = "活期租金宝查询";
//                        String description = "尊敬的商户，\n\n点击本消息查看活期租金宝详细收益信息";
//                        String toUrl = domain+"/req/second/curZjbDetails";
//                        String state  = "curZjbDetails";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                    }else if (eventKey.equals("not_liq_profit_details") && isBlinding) {
//                        String title = "未结算收益查询";
//                        String description = "尊敬的商户，\n\n您可以通过本功能查询未结算收益！！\n\n请点击本消息进行后续操作！";
//                        String toUrl = domain+"/req/second/notLiqProfitDetails";
//                        String state  = "notLiqProfitDetails";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                    }else if (eventKey.equals("is_liq_profit_details") && isBlinding) {
//                        String title = "已结算收益查询";
//                        String description = "尊敬的商户，\n\n您可以通过本功能查询已结算收益！！\n\n请点击本消息进行后续操作！";
//                        String toUrl = domain+"/req/second/isLiqProfitDetails";
//                        String state  = "isLiqProfitDetails";
//                        respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                    }else if (eventKey.equals("rapid_cash") && isBlinding){
//                        try{
//                            List<AcctInfoDto> acctInfos = acctInfoManager.getRecvAcctInfoByCustId(custId);
//                            if(acctInfos == null || acctInfos.size() == 0){
//                                respContent = "尊敬的商户,您尚未绑定取现账户！\n\n请联系客户人员进行绑定！";
//                                textMessage.setContent(respContent);
//                                respMessage = MessageUtil.messageToXml(textMessage);
//                            }
//                            //查询商户快速取现状态、可用余额
//                            String subAcctId = acctInfos.get(0).getSubAcctId();
//                            String rapidType = RcashTypeEnum.T0.getCode();
//                            QueryRcashMerInfoResult result = rcashManager.queryRcashMerInfo(custId, subAcctId, rapidType);
//                            if(!StringUtils.equals(MonsterBasicRespCode.SUCCESS.getReturnCode(), result.getRespCode())){
//                                
//                            }
//                            if(result.getRcashMerInfoDto() == null || !"N".equals(result.getRcashMerInfoDto().getStat())){
//                                respContent = "尊敬的商户，\n\n对不起，您未开通即时取现功能！！";
//                                textMessage.setContent(respContent);
//                                respMessage = MessageUtil.messageToXml(textMessage);
//                            }else if(new BigDecimal(0).compareTo(acctInfos.get(0).getAvlBal()) == 0){
//                                respContent = "尊敬的商户，\n\n您可以通过本功能进行即时取现！！\n当前查询到您的账户余额为0.00元！";
//                                textMessage.setContent(respContent);
//                                respMessage = MessageUtil.messageToXml(textMessage);
//                            }else {
//                                String avlBal = CurrencyUtils.format2CurrencyFormatOrNull(acctInfoManager.getRecvAcctInfoAvlBal(custId).getAmount());
//    //                          String avlBal = CurrencyUtils.float2amt(acctInfos.get(0).getAvlBal()+"", 2);
//                                String title = "即时取现";
//                                String description = "尊敬的商户，\n\n您可以通过本功能进行即时取现！！\n当前查询到您的账户余额为"+avlBal+"元！\n\n请点击本消息进行后续操作！";
//                                String toUrl = domain+"/req/second/rapidcash";
//                                String state  = "rapidcash";
//                                respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                            }
//                        }catch(Exception e){
//                            respContent = "尊敬的商户，\n\n系统错误，请稍后再试！！";
//                            textMessage.setContent(respContent);
//                            respMessage = MessageUtil.messageToXml(textMessage);
//                        }
//                    }else if (eventKey.equals("normal_cash") && isBlinding){
//                        try{
//                            //普通取现业务
//                            List<AcctInfoDto> acctInfos = acctInfoManager.getRecvAcctInfoByCustId(custId);
//                            if(acctInfos == null || acctInfos.size() == 0){
//                                respContent = "尊敬的商户，\n\n您没有办理取现账户,无法办理取现业务！";
//                                textMessage.setContent(respContent);
//                                respMessage = MessageUtil.messageToXml(textMessage);
//                            }
//                            /*//查询商户快速取现状态、可用余额
//                            String subAcctId = acctInfos.get(0).getSubAcctId();
//                            String avlBal = CurrencyUtils.format2CurrencyFormatOrNull(acctInfoManager.getRecvAcctInfoAvlBal(custId).getAmount());
//                            */
//                            //账户可用余额查询
//                            Money recvAvlBal =  acctInfoManager.getRecvAcctInfoAvlBal(custId);
//                            if(recvAvlBal==null||CurrencyUtils.isZero(recvAvlBal)){
//                                respContent = "尊敬的商户，\n\n您可以通过本功能进行普通取现！！\n当前查询到您可取金额0.00元！";
//                                textMessage.setContent(respContent);
//                                respMessage = MessageUtil.messageToXml(textMessage);
//                            }else{
//                                String recvAcctAvlYuan =  CurrencyUtils.format2CurrencyFormatOrNull(recvAvlBal .getAmount());
//                                String title = "普通取现";
//                                String description = "尊敬的商户，\n\n您可以通过本功能进行普通取现！！\n当前查询到您的账户余额为"+recvAcctAvlYuan+"元！\n\n请点击本消息进行后续操作！";
//                                String toUrl = domain+"/req/second/normalrash";
//                                String state  = "putongquxian";
//                                respMessage = this.getNewsRespMessage(title, description, "", toUrl, state, fromUserName, toUserName);
//                            }
//                        }catch(Exception e){
//                            respContent = "尊敬的商户，\n\n系统错误，请稍后再试！！";
//                            textMessage.setContent(respContent);
//                            respMessage = MessageUtil.messageToXml(textMessage);
//                        }
//                    }
//                    
                }
                else if (eventType.equals(MessageUtil.EVENT_TEMPLATE_SEND_JOB_FINISH)) {
                    System.out.println(requestMap);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }

    /** 
     * @see com.yunrich.service.base.CoreService#getNewsRespMessage(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getNewsRespMessage(String title, String description, String picUrl, String toUrl,
                                     String state, String fromUserName, String toUserName) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setPicUrl(picUrl);
        String url = ToUrlWxUtils.getOauthRequestUrl(WxConstantMessage.APPID, toUrl, "snsapi_base", state);
        article.setUrl(url);
        
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(article);
        
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
        newsMessage.setArticleCount(articleList.size());
        newsMessage.setArticles(articleList);
        return MessageUtil.messageToXml(newsMessage);
    }


}
