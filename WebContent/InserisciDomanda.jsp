<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci una nuova domanda</title>
</head>
<body>

<form action="servletInserimento" method="POST">

  Da quale libro proviene?: <input type="text" name="book">
  capitolo: <input type="number" name="chapter">
  domanda numero: <input type="number" name="question"><br>
  inserisci il corpo:<br><textarea name="testo" rows="4" cols="50"></textarea><br>
  insersci le risposte delimitate da "\n":<br><textarea name="strRisposte" rows="4" cols="50"></textarea><br>
  La/e risposta/e esatta/e è/sono: <input type="text" name="rispostaEsatta"><br>
  inserisci la spiegazione:<br><textarea name="spiegazione" rows="4" cols="50"></textarea><br>
  <input type="submit" value="SALVA">
  
</form>
</body>
</html>