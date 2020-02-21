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
	<!--  	Questa è la pagina di ingresso al tuo Quiz Online<br>
	<br>
	Totale domande caricate : ${ totDomande }<br>
	Tempo disponibile : ${ totDomande * 2 } minuti<br>
	<br>
	

	<form action="./caricaDomande" method="post">

		<input type="checkbox" id="book" name="dir1" value="oca_manual">
		<label for="book">OCA Oracle Certified Associate Java SE 8 [2014]</label><br>
		<input type="checkbox" id="book" name="dir2" value="oca_certification_guide_manning">
		<label for="book"> OCA Java SE 8 Programmer I Certification Guide</label><br>
		
			<input type="submit" value="START">		
	</form>
-->
	<form action="./caricaDomande" method="post">

		<c:forEach items="${listaLibri}" var="libro">

			<input type="checkbox" id="book" name="dir">
			<label for="book">${libro.getTitle()}</label>
			<br>
		</c:forEach>
		<input type="submit" value="START">
	</form>

	<c:forEach items="${listaLibri}" var="element">
		
			<input type="checkbox" id="book" name="dir">
			<label for="book">${libro.getTitle()}</label>
			`${element.title}`
			
		
	</c:forEach>
</body>
</html>