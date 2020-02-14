<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Inserisci una nuova domanda:</h1>

<form action="Conferma.jsp" method="POST">

	ID: 			<input Size="1" type="text" name="id"> &nbsp;&nbsp;&nbsp;&nbsp;
	Book:			<input Size="50" type="text" name="book"> &nbsp;&nbsp;&nbsp;&nbsp;
	Chapter:		<input Size="1" type="text" name="chapter"> &nbsp;&nbsp;&nbsp;&nbsp;
	Question:		<input Size="1" type="text" name="question"><br><br>
	Testo:		<br><textarea cols="150" rows="15" name="testo"></textarea><br><br>
	AnswerType: 	<input type="text" name="answerype"><br><br>
	Risposte:	<br><textarea cols="150" rows="8" name="testo"></textarea><br><br>
	RispostaUtente: <input Size="8" type="text" name="risposteUtente"> &nbsp;&nbsp;&nbsp;&nbsp;
	RispostaEsatta: <input Size="8" type="text" name="rispostaEsatta"><br><br>
	Spiegazione:<br><textarea cols="150" rows="8" name="testo"></textarea><br><br>

<input type="submit" value="Insrisci Nuova Domanda">
</form>
</body>
</html>