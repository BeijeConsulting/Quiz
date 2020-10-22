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
<body>
 	<h1>QUIZ MENU':</h1>
	<div align="right"><a href ="./logout">Logout here     </a></div>
	<div class="main">
		<form action="sceltaset" method="GET" >
			<button type="submit"><span>Start new quiz</span></button>
		</form>	
		<br><br>	
		<form action="storicoesiti" method="GET"> 
			<button type ="submit"><span>Quiz history</span></button> 
		</form>
		
		<br><br>		
	</div>	
		
</body>
</html>