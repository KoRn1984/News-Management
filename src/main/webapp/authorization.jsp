<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Authorization</title>
</head>
<body>
<fieldset><legend><b>Enter your details:</b></legend>
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="authorization" />Enter login:<br/>
		<input type="text" name="login" value="" /><br/>Enter password:<br/>
		<input type="password" name="password" value="" /><br/><br/>
		<input class="button" type="submit" value="Enter" /><br/>
	</form>
</fieldset>
</body>
</html>