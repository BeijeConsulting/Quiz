<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Totale Domande</title>
</head>
<body>

<form action="domanda/0" method="get">
Totale domande caricate : ${totDomande}<br>
Tempo disponibile : ${totDomande*2} minuti<br>


<input type="submit" value="INIZIA IL QUIZ">	
</form>
</body>
</html>