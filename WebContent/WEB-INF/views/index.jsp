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
Questa è la pagina di ingresso al tuo Quiz Online <title>Inizia il tuo Quiz OnLine</title><br> <img src="https://www.metodoin.it/new/wp-content/uploads/2013/11/java-logo.jpg"  height="200" width="300">
<br>
Totale domande caricate : ${ totDomande }<br>
Tempo disponibile : ${ totDomande * 2 } minuti<br>
<br>

Seleziona i libri da utilizzare:<br>

<form action="./" method="get">

	<c:forEach var="scelte" items="${libri}">
	<input type="checkbox" value='${scelte.idBook}' name="bookSelection">${scelte.title}<br>
	</c:forEach>
	
<input type="submit" value="START"><br>

</form>
<form action="nuovoLibro">
	<input type="submit" value="Inserisci un nuovo libro">
</form>

</body>
</html>