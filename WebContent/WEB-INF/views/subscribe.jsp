<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione nuovo utente</title>
</head>
<body>
<p>Inserisci le tue credenziali per continuare</p>
<form action="/quiz/sub" method="post">
	USER:&nbsp;<input type="text" name="user"><br>
	PASSWORD:&nbsp;<input type="password" name="password"><br>
	REPEAT PASSWORD:&nbsp;<input type="password" name="password2"><br>
	<input type="submit" value="SUBSCRIBE">
</form>
</body>
</html>