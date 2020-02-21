<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
h1{
	align: center;

}



</style>
<head>
<meta charset="ISO-8859-1">
<title>Crea libro</title>
</head>
<body align=center>

<h1>CREA IL TUO LIBRO:</h1>
<form action="./creaLibro" method="post">
<p><strong> ID libro: </strong><input type="text" name="IDbook" value='${Libro.IdBook}'><br><br>
<p><strong>Titolo del libro: </strong><input type="text" name="title" value='${Libro.title}'><br><br>
<p><strong>Capitoli del libro:</strong><input type="text" name="chapter" value='${Libro.ncapitoli}'><br><br> 
<p><strong>Seleziona domande del capitolo:</strong><input type="text" name="question" value='${Libro.domanda}'><br><br>


<input type="submit" value="CONFERMA AGGIUNTA LIBRO">
</form>
</body>
</html>