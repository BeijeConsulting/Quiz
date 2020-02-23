<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inizia il tuo Quiz OnLine</title>
</head>
<body>
	<form action="./caricadomande" method="post">

		<c:forEach items="${listaLibri}" var="libro">
			<input type="checkbox" id="book" name="dirs" value="${libro.idBook}">
			<label for="book">${libro.title}</label>
			<br><br>
		</c:forEach>
		<input type="submit" value="START QUIZ!">

	</form>
	
</body>
</html>