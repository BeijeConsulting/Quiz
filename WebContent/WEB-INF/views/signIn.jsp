<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sign In</title>
</head>
<body>
<c:if test = "${errore != null}">
    <b>${errore}</b></br>
</c:if>

	<h1 style="text-align:center;"><em>Login<em></em></h1>
	<h3>Enter your credentials</h3>

		<form action="./signIn" method="POST">
			E-MAIL&nbsp;<input type="email" name="email" value="" /><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value="" /><br>
			<input type="submit" value="SIGN IN"/>
		</form>
	


</body>
</html>