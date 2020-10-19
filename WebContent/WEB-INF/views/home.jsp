<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Home</title>
<link rel="stylesheet" href="<c:url value="/resources/static/attivita.css" />">
</head>
<body >
 	
	<h1>QUIZ MENU':</h1>
	<div class="main">
		<form action="sceltaset" method="GET" >
			<button type="submit"><span>Inizia un nuovo quiz</span></button>
		</form>	
		<br><br>	
		<form action="storicoesiti" method="GET"> 
			<button type ="submit"><span>Storico quiz</span></button> 
		</form>
		<h3><a href ="/logout">Logout</a></h3>
		<br><br>		
	</div>		
</body>
</html>