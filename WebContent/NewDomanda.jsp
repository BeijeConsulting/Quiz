<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuova domanda</title>
</head>
<body>

	<form action="NewRisposte.jsp" method="POST">

		<h4>Inserisci il libro:</h4>
		<input type="radio" id="book1" name="book"
			value="OCA Oracle Certified Associate Java SE 8 [2014]"> <label
			for="book1">OCA Oracle Certified Associate Java SE 8 [2014]</label><br>
		<input type="radio" id="book2" name="book"
			value="OCA - OCP Practice Tests Exam 1Z0-808 and Exam 1Z0-809">
		<label for="book2">OCA - OCP Practice Tests Exam 1Z0-808 and
			Exam 1Z0-809</label><br>
			
		<h4>Inserisci il capitolo:</h4>
		<input type="number" name="chapter" placeholder="inserisci solo numeri">

		<h4>Inserisci il testo della domanda:</h4>
		<textarea name="testo" rows="10" cols="50"></textarea>
		
		
		<h4>Inserisci la modalità di risposta:</h4>
		<input type="radio" id="1" name="answerType"
			value="radio"> <label
			for="1">Risposta Singola</label><br>
			
			<input type="radio" id="2" name="answerType"
			value="checkbox"> <label
			for="2">Risposta Multipla</label><br>

		<h4>Inserisci le risposte possibili:</h4>
		Numero Risposte: <input type="number" name="numeroRisposte" placeholder="inserisci solo numeri"><br>
		<input type="submit" value="inserisci risposte">
	</form>


</body>
</html>