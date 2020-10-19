<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inizia il tuo Quiz OnLine</title>
</head>
<body>
	<h3>Benvenuto ${user.nickname}</h3>
	<br>
	Questa è la pagina di ingresso al tuo Quiz Online<br>
	
	<%if(!(boolean)session.getAttribute("selected")) {%>
		<br>
		Seleziona quale quiz vuoi affrontare
		<br>
		<form action = "./" method = "post">
			${quizManning} <br>
			<c:forEach var="file" items="${questionManning}">
				<input type = "radio" name="fileName" value = "${quizManning}/${file}">${file}<br>
			</c:forEach>
			${quizOca} <br>
			<c:forEach var="file" items="${questionOca}">
				<input type = "radio" name="fileName" value = "${quizOca}/${file}">${file}<br>
			</c:forEach>
		  <br><input type="submit" value="Seleziona">
		</form>
	<%} else {%>
		<br>
		Totale domande caricate : ${ totDomande }<br>
		Tempo disponibile : ${ totDomande * 2 } minuti<br>
		<br>
		<form action="./domanda/0" method="get">
			<input type="submit" value="START">
		</form>
	<%} %>
	
	
</body>
</html>