<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/style.css"%>
</head>
<meta charset="ISO-8859-1">
<title>Inizia il tuo Quiz OnLine</title>
</head>

<body>



<h5> ${newDomandaCreata }</h5> 

<div id="container">
	<div id="header"><h1>Questa è la pagina di ingresso al tuo Quiz Online <title>Inizia il tuo Quiz OnLine</title></h1><br></div> <img src="https://www.metodoin.it/new/wp-content/uploads/2013/11/java-logo.jpg"  height="200" width="300">
	<br>
	<div class="item-evi"><h2><p>Totale domande caricate : ${ totDomande }</p><br>
	<p>Tempo disponibile : ${ totDomande * 2 } minuti</p><br></h2></div>
	<br>
	

	<div id="content">
		<div class="articolo">
		<h2>Seleziona i libri da utilizzare:<br>
		
		<form action="./domanda/0" method="get">
		
			<c:forEach var="scelte" items="${libri}">
			<input type="checkbox" value='${scelte.idBook}' name="bookSelection">${scelte.title}<br>
			</c:forEach>
			
		<input type="submit" id="button" value="START"><br>
		</form> 
		<form action="./NewDomanda" method="get">
			<input type="submit" id="button2" value="INSERISCI NUOVA DOMANDA" width="100px">
		</form>
		</h2>
		<h5> ${newDomandaCreata }</h5> 
		</div>
	</div>
	
	<div id="footer"><p>Footer</p></div>
</div>


</body>
</html>