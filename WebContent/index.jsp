<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>

<form action="InserisciDomanda.jsp" method="POST">
  <input type="submit" value="Inserisci una nuova domanda">
</form>

<form action="servletQuiz" method="POST">
<% session.setAttribute("index",0);%>
  <input type="submit" value="Inizia quiz">
</form>

</body>
</html>