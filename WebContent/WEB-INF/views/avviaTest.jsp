<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inizia il tuo Quiz OnLine</title>
</head>
<body>

<h2>Quiz Scelto:</h2>

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