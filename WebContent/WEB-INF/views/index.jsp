<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inizia il tuo Quiz OnLine</title>
	<link rel="stylesheet" href="<c:url value="/resources/static/attivita.css" />">
</head>
<body>
	Questa è la pagina di ingresso al tuo Quiz Online<br>
	<br>
	<div align="right"><h3><a href ="./log"><span>Home</span></a></h3></div>
	Totale domande caricate : ${ totDomande }<br>
	Tempo disponibile : ${ totDomande * 2 } minuti<br>
	<br>
	<form action="./domanda/0" method="get">
		<input type="submit" value="START">
	</form>
</body>
</html>