package org.yunrich.tmmod.utils.webrequest.pojo;

/**
 * 
 * @author think
 * @version $Id: ComplexButton.java, v 0.1 2014年9月28日 下午3:28:30 think Exp $
 */
public class ComplexButton extends Button {
    private Button[] sub_button;  
    
    public Button[] getSub_button() {  
        return sub_button;  
    }  
  
    public void setSub_button(Button[] sub_button) {  
        this.sub_button = sub_button;  
    }  
}
