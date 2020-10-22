<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		<h3>Please fill in the form suggested below</h3>
		<form action="./login" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="SUBMIT"/>
		</form>
		<p>don't have an account yet? Click <a href="./accountregistration">here</a> to create one!</p>
		<p>${error}</p>
</body>
</html>