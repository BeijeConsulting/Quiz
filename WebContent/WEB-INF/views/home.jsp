<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.quiz.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Home</title>
<link rel="stylesheet" href="<c:url value="/resources/static/attivita.css" />">
</head>
<body>
	<h1>Welcome back, <%=((User)(session.getAttribute("user"))).getNickname()%></h1>	<div align="right"><a href ="./logout">Logout here</a></div>
 	<div align="center"><h1>QUIZ MENU':</h1></div>
	<div class="main">
		<form action="./testselect" method="GET" >
			<button type="submit"><span>Start new quiz</span></button>
		</form>	
		<br><br>	
		<form action="testhistory" method="GET"> 
			<button type ="submit"><span>Quiz history</span></button> 
		</form>
		
		<br><br>		
	</div>	
		
</body>
</html>