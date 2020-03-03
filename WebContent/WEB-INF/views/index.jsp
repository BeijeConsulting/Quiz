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
	
	Seleziona il libro con cui vuoi esercitarti:<br><br>
	
	<form action="totaledomande" method="get">
	<input type="checkbox" value="oca_manual" name="libro1">
    <label for="book"> "OCA Oracle Certified Associate Java SE 8 [2014]</label><br>

	
    <input type="checkbox" name="libro2" value="oca_certification_guide_manning">
    <label for="book"> "OCA Java SE 8 Programmer I Certification Guide</label><br><br>
		<input type="submit" value="START">
	</form>	
	
	<form action="new" method="get">
		<input type="submit" value="CREAZIONE NUOVA DOMANDA">
	</form>
</body>
</html>