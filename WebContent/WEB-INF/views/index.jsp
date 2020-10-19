<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inizia il tuo Quiz OnLine</title>
</head>
<body>
	Questa è la pagina di ingresso al tuo Quiz Online

	<%-- SEZIONE SELEZIONE DOMANDE --%>
	<h3>Seleziona le sezioni che desideri fare:</h3>
	<form method="post" action="./start">
		<b>OCA MANUAL</b>
		<label> Capitolo 1
			<input type="checkbox" value="oca_1" name="questions">
		</label>
		<label> Capitolo 2
			<input type="checkbox" value="oca_2" name="questions">
		</label>
		<label> Capitolo 3
			<input type="checkbox" value="oca_3" name="questions">
		</label>
		<label> Capitolo 4
			<input type="checkbox" value="oca_4" name="questions">
		</label>
		<label> Capitolo 5
			<input type="checkbox" value="oca_5" name="questions">
		</label>
		<label> Capitolo 6
			<input type="checkbox" value="oca_6" name="questions">
		</label>
		<label> Assessment Test
			<input type="checkbox" value="oca_at" name="questions">
		</label>

		<input type="submit" value="LOAD">
	</form>

	<br>
	<br>
	Totale domande caricate : ${ totDomande }
	<br>
	Tempo disponibile : ${ totDomande * 2 } minuti
	<br>
	<br>
	<%-- Richiede di stampare la prima domanda --%>
	<form action="./domanda/1" method="get">
		<input type="submit" value="INIZIA">
	</form>
</body>
</html>