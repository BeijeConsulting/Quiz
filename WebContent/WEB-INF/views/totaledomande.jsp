<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scelta Domande</title>
</head>
<body>


	
	Totale domande caricate : ${ totDomande }<br>
	Tempo disponibile : ${ totDomande * 2 } minuti<br>
	<br>
<br><br>
<form action="./domanda/0" method="get">
<input type="submit" value="start" >
</form>
</body>
</html>