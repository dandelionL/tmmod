package org.yunrich.tmmod.webapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PnrWxBkNoticeController {

    @RequestMapping("/kaylee/bkNotice")
    public String pnrWxBkNotice(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
         
        BufferedReader br;
        String line="";
        StringBuffer buffer = new StringBuffer(1024);
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
            while((line=br.readLine())!=null){
                buffer.append(line);
           }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("####["+buffer.toString()+"]");
        try {
            System.out.println("####["+URLDecoder.decode(buffer.toString(), "utf-8")+"]");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
}
