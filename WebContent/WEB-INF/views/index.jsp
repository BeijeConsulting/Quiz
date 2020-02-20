<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inizia il tuo Quiz OnLine</title>
</head>
<body>
	Questa è la pagina di ingresso al tuo Quiz Online<br>
	<br>
	Seleziona da quale libro prendere le domande: <br>
	
	<input type="checkbox" id="libro1" name="libro1" value="oca_manual"> OCA Oracle Certified Associate Java SE 8 [2014] <br>
	<input type="checkbox" id="libro2" name="libro2" value="oca_certification_guide_manning">  OCA Java SE 8 Programmer I Certification Guide <br><br>
	
	
	Totale domande caricate : ${ totDomande }<br>
	Tempo disponibile : ${ totDomande * 2 } minuti<br>
	<br>
	<form action="./domanda/0" method="get">
		<input type="submit" value="START">
	</form>
</body>
</html>