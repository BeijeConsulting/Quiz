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
<h5> ${newDomandaCreata }</h5> 
Questa è la pagina di ingresso al tuo Quiz Online<br>
<br>
Totale domande caricate : ${ totDomande }<br>
Tempo disponibile : ${ totDomande * 2 } minuti<br>
<br>

Seleziona i libri da utilizzare:<br>

<form action="./domanda/0" method="get">

	<c:forEach var="scelte" items="${libri}">
	<input type="checkbox" value='${scelte.idBook}' name="bookSelection">${scelte.title}<br>
	</c:forEach>
	
<input type="submit" value="START">
</form>

<form action="./NewDomanda" method="get">
<input type="submit" value="INSERISCI NUOVA DOMANDA">
</form>
</body>
</html>