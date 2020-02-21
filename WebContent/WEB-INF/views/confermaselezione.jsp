<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Pagina di conferma delle selezioni</title>
</head>
<body>
	Totale domande caricate : ${ totDomande }<br>
	Tempo disponibile : ${ totDomande * 2 } minuti<br>
	
	<form action="./" method="GET">
		<input type="submit" value="MODIFICA" />
	</form>

	<form action="./domanda/0" method="GET">
		<input type="submit" value="START" />
	</form>

</body>
</html>