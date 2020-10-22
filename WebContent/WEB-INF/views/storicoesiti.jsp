<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.quiz.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Storico Esiti</title>
<link rel="stylesheet" href="<c:url value="/resources/static/attivita.css" />">
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<h2>Storico Esiti di <%=((User)(session.getAttribute("user"))).getNickname()%></h2>
<h3><a href ="./log">Home</a></h3>
	<table>
	<tr>
		<th>ID</th>
		<th>Data</th>
		<th>Durata</th>
		<th>Score</th>
		<th>Punteggio</th>
		<th>Esito</th>
	</tr>	
	<c:forEach var="s" items="${storico}">
	<tr>
		<td><c:out value= "${s.id}"/></td>
		<td><c:out value= "${s.data}"/></td>
		<td><c:out value= "${s.durata}"/></td>
		<td><c:out value= "${s.score}%"/></td>
		<td><c:out value= "${s.punteggio}"/></td>
		<td><c:out value= "${s.esito}"/></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>