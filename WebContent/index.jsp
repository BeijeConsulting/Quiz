<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Domanda</title>
</head>

<style>
h1 {
	font-weight: normal;
	letter-spacing: -0.06em;
	font-size: 35px;
	font-family: "Lucida Grande", Arial, Sans-serif;
	color: red;
}

body {
	background-image: url("images/thumb-1920-430916.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
}
</style>

<body>

	<h1>
		<strong>INSERISCI LA DOMANDA<strong><strong>
	</h1>
	<div>
		<font color="red"><strong>Libro :</strong></font>
		<textarea id="book" rows="2" cols="40"></textarea>
		&nbsp<font color="red"><strong>Chapter :</strong></font>
		<textarea id="chapter" rows="2" cols="2"></textarea>
		&nbsp <font color="red"><strong>Question :</strong></font>
		<textarea id="question" rows="2" cols="2"></textarea>
		<br> <br>
	</div>

	<font color="red"><strong>Domanda :</strong></font>
	<br>
	<textarea id="domanda" rows="8" cols="80"></textarea>
	<br>
	<br>
	<font color="red"><strong>Risposte :</strong></font>
	<br>
	<textarea id="risposte" rows="8" cols="80"></textarea>
	<br>
	<br>
	<font color="red"><strong>Risposte Esatte :</strong></font>
	<br>
	<textarea id="risposteEsatte" rows="1" cols="10"></textarea>
	<br>
	<br>
	<font color="red"><strong>Spiegazione :</strong></font>
	<br>
	<textarea id="spiegazione" rows="8" cols="80"></textarea>
	<br>
	<br>

</body>
</html>