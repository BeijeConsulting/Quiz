<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>
	<form action="/newuser" method="POST">
	NICKNAME<input type="text" value="" name="nickname" placeholder="redmario"/>
	EMAIL<input type="email" value="" name="email" placeholder="mariorossi@gmail.com"/>
	PASSWORD<input type="password" value="" name="password"/>
	<input type="submit" value="CONFERMA"/><input type="reset" value="ANNULLA"/>
	</form>
	<a href="/log">HOME</a>
</body>
</html>