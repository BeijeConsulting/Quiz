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

   	<c:forEach var = "i" items="${esami}">
	    <c:out value = "${i}"/><p>
	</c:forEach>
</body>
</html>