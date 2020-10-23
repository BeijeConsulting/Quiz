<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.quiz.entity.User"%>
<%@page import="it.beije.quiz.entity.Test"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Results</title>
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
 <link rel="stylesheet" href="<c:url value="/resources/static/attivita2.css" />">
</head>
<body>
<table>
	<tr>
		<th>User</th>
		<th>Score</th>
		<th>Percentage</th>
		<th>Threshold</th>
		<th>Passed</th>
		<th>Date</th>
	</tr>
	<tr>
		<td><%= ((User)session.getAttribute("user")).getNickname() %> </td>
		<td><%= ((Test)session.getAttribute("test")).getScore() %> </td>
		<td><c:out value="${percentage}%"/> </td>
		<td>65%</td>
		<td><%=((Test)session.getAttribute("test")).isResult() ? "pass" : "fail"  %></td>
		<td><%= ((Test)session.getAttribute("test")).getDate() %></td>
	</tr>
	<tr>
		<th colspan=2>Question</th>
		<th>Your Answer</th>
		<th>Correct Answer</th>
		<th colspan=2>Outcome</th>
	</tr>
	<c:forEach items="${questions}" var="question">
	<tr>
		<td colspan=2><c:out value="Question N. ${questions.indexOf(question)+1}"/></td>
		<td><c:out value="${answers.get(questions.indexOf(question)).getAnswer()}"/></td>
		<td><c:out value="${question.answer}"/></td>
		<td colspan=2><c:out value='${answers.get(questions.indexOf(question)).getCorrect() eq true ? "correct" : "wrong"}'/> </td>
	</tr>
	</c:forEach>

</table>
<br>
<div align="center"><h3><a href ="./home">Home page</a></h3></div>
</body>
</html>