<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration</title>
</head>
<body>
<fieldset><legend><b>Enter your data:</b></legend>
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="registration" />Enter your name:<br/>
		<input type="text" name="name" value="" /><br/>Enter your surname:<br/>
		<input type="text" name="surname" value="" /><br/>Enter your date of birth:<br/>
		<input type="date" name="date" value="" /><br/>Enter login:<br/>
		<input type="text" name="login" value="" /><br/>Enter password:<br/>
		<input type="password" name="password" value="" /><br/><br/>
		<input class="button" type="submit" value="Save" /><br/>
	</form>
</fieldset>
</body>
</html>
