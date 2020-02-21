<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento nuovo libro</title>
</head>
<body>

Inserisci i dettagli del nuovo libro<br>
<form action="/newlibro" method="POST">
	Titolo: &nbsp <input type="text" name="title"><br>
	Id Libro: <input type="text" name="idBook"><br>
	Cartella:<br> <textarea id="nameDir" rows="2" cols="50">C:\\Users\\[inserisci]\\git\\Quiz\\domande </textarea><br>
	<input type="submit" value="Conferma">
</form>

</body>
</html>