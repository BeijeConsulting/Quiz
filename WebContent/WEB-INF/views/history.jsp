<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
</head>
<body>
	<a href="./index">Go to index</a>
	
	<h4>${user.name} ecco lo storico dei quiz che hai completato: <br></h4>

	<table>
		<tr>
		    <th>First name</th>
		    <th>Last Name</th>
		    <th>Age</th>
	 	</tr>
	   	<c:forEach var = "esame" items="${esami}">
	   		<tr>
		   		<th><c:out value = "${esame.passato}"/></th>
		   		<th><c:out value = "${esame.name}"/></th>
		   		<th><c:out value = "${esame.results}"/></th>
				<th><button onclick="./quiz_review/${esame.id}"> Riguarda risposte</button></th>
				<br>
		    </tr>
		</c:forEach>
	</table>
	
</body>
</html>