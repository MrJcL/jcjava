<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="login"></s:text></title>
</head>
<body>

<a href="login.action?request_locale=zh_CN">中文</a>
<a href="login.action?request_locale=en_US">Englist</a>
<s:actionerror/>
<form action="doLogin.action" method="post">
<s:token></s:token>
	<s:text name="account"></s:text><input type="text" name="name"></br>
	<s:text name="password"></s:text><input type="password" name="password"></br>
	<button type="submit"><s:text name="login"></s:text></button></br>
	<span style="color:red">${msg }</span>
</form>
</body>
</html>