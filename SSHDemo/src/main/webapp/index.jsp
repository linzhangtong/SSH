<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆</title>
    <link type="text/css" rel="stylesheet" href="style/reset.css">
    <link type="text/css" rel="stylesheet" href="style/main.css">
    <!--[if IE 6]>
    <script type="text/javascript" src="js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript" src="js/ie6Fixpng.js"></script>
    <![endif]-->
</head>

<body>
<div class="headerBar">
    <div class="logoBar login_logo">
        <div class="comWidth">
            <h3 class="welcome_title">欢迎登陆</h3>
        </div>
    </div>
</div>
<s:form action="employee_login" method="POST" namespace="/">
    <div class="loginBox">
        <h3><s:actionerror/></h3>
        <div class="login_cont">
            <ul class="login">
                <li class="l_tit">用户名</li>
                <li class="mb_10"><input type="text" name="username" class="login_input user_icon"></li>
                <li class="l_tit">密码</li>
                <li class="mb_10"><input type="text" name="password" class="login_input user_icon"></li>

                <li><input type="submit" value="" class="login_btn"></li>
            </ul>
            <div class="login_partners">
                <p class="l_tit">使用合作方账号登陆网站</p>
                <ul class="login_list clearfix">
                    <li><a href="#">QQ</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">网易</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">新浪微博</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">腾讯微薄</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">新浪微博</a></li>
                    <li><span>|</span></li>
                    <li><a href="#">腾讯微薄</a></li>
                </ul>
            </div>
        </div>

    </div>
    </s:form>

<div class="hr_25"></div>
</body>
</html>
