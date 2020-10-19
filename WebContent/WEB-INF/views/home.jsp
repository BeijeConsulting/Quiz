<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz home</title>
</head>
<body>
	<h3>SELEZIONA UN QUIZ</h3>
<form action="/home" method = "post">
  <p>Oca-Manual:</p>
  <input type="radio" name = "oca" id="C:\Users\Padawan08\git\Quiz\domande\oca_manual\domande_cap1.xml" value="cap1">
  <label for="cap1">Capitolo 1</label><br>
  <input type="radio" name = "oca" id="C:\Users\Padawan08\git\Quiz\domande\oca_manual\domande_cap2.xml" value="cap2">
  <label for="cap2">Capitolo 2</label><br>
  <input type="radio" name = "oca" id="C:\Users\Padawan08\git\Quiz\domande\oca_manual\domande_cap3.xml" value="cap3">
  <label for="cap3">Capitolo 3</label>
  <input type="submit" value="Submit">
</form>
</body>
</html>