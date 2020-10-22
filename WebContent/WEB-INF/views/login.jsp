<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Login here</title>
		<meta charset="ISO-8859-1">
	 <link rel="stylesheet" href="<c:url value="/resources/static/attivita.css" />">
	</head>
	<body>
	<h1>ACCEDI</h1> 
	<div align="right"><h3>${errore}</h3></div>	
	<div class="main">
		<form action= "log"  method="POST">
			<h3>Log in:</h3> <br> 
			<label>Email: <input  name="email" type="email" placeholder="user@domain.it"></label><br><br>
			<label>Password: <input name="password" type="password"></label><br>
			<br>
			<button type ="submit"><span>Accedi</span></button> <button type ="reset"><span>Cancella</span></button>
		</form>	<br><br>
	<div align="right"></div><h3><a href ="./logout">Torna indietro</a></h3></div>
	</div>
	
	</body>
</html>