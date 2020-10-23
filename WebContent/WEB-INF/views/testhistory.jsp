<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.quiz.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test History</title>
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


<h2>Your quiz history, <%=((User)(session.getAttribute("user"))).getNickname()%>:</h2><br>
<h3><a href ="home">Home page</a></h3><br>

	<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Date</th>
		<th>Duration</th>
		<th>Score</th>
		<th>Result</th>
		<th>Committed</th>
	</tr>	
	<c:forEach var="s" items="${test}">
	<tr>
		<td><c:out value= "${s.id}"/></td>
		<td><c:out value= "${s.name}"/></td>
		<td><c:out value= "${s.date}"/></td>
		<td><c:out value= "${s.duration}"/></td>
		<td><c:out value= "${s.score}"/></td>
		<td><c:out value= "${s.result}"/></td>
		<td><c:out value= "${s.committed}"/></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>