<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0,viewport-fit=cover">
    <title>微信公众号绑定</title>
    <link rel="stylesheet" href="http://localhost:8080/tmmod/weui/dist/style/weui.css" />
    <link rel="stylesheet" href="http://localhost:8080/tmmod/weui/dist/example/example.css"/>
    <script src="http://localhost:8080/tmmod/weui/dist/example/zepto.min.js"></script>
    <script type="text/javascript" src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
    <script src="http://localhost:8080/tmmod/weui/dist/example/example.js"></script>
</head>
<body ontouchstart>
    <div class="weui-toptips weui-toptips_warn js_tooltips">错误提示</div>
    <form id ="kaleeBinding" action="/klScatter/bindingConfirm" >
    	<div class="weui-cells__title">绑定</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell weui-cell_vcode">
                <div class="weui-cell__hd">
                    <label class="weui-label">手机号</label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="tel" name="userMobile" placeholder="请输入手机号"/>
                </div>
            </div>
        </div>
        <div class="page__bd page__bd_spacing">
        	<a href="#" id="kaleeBinding_button" class="weui-btn weui-btn_primary" >确定</a>
       	</div>
    </form>
    
    <script type="text/javascript">
	    $(function(){
	        var $tooltips = $('.js_tooltips');
	
	        $('#showTooltips').on('click', function(){
	            if ($tooltips.css('display') != 'none') return;
	
	            // toptips的fixed, 如果有`animation`, `position: fixed`不生效
	            $('.page.cell').removeClass('slideIn');
	
	            $tooltips.css('display', 'block');
	            setTimeout(function () {
	                $tooltips.css('display', 'none');
	            }, 2000);
	        });
	        
	        $('#kaleeBinding_button').on('click', function(){
	        	
	        	alert("hahahahah");
	        	
	            if ($tooltips.css('display') != 'none') return;
	
	            // toptips的fixed, 如果有`animation`, `position: fixed`不生效
	            $('.page.cell').removeClass('slideIn');
	
	            $tooltips.css('display', 'block');
	            setTimeout(function () {
	                $tooltips.css('display', 'none');
	            }, 2000);
	        });
	        
	        
	    });
	</script>
    
</body>
</html>