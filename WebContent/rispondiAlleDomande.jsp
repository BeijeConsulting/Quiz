<%@page import="it.beije.quiz.model.Domanda"%>
<%@page import="it.beije.quiz.model.Risposta"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
</head>
<body>

<%
	Domanda dom = (Domanda) session.getAttribute("domanda");
	String book = dom.getBook();
	int chapter = dom.getChapter();
	int question = dom.getQuestion();
	String testo = dom.getTesto();
	List<Risposta> risp = dom.getRisposte();
	int index = (int) session.getAttribute("index");
%>

Da: <%= book %><br>
Cap: <%= chapter %><br><br>
n. <%= question %><br>
Domanda: <%= testo %><br><br>
<%for(Risposta r : risp){ %>
	<input type=<%= dom.getAnswerType() %>> <%= r.getValue()+" "+r.getText() %>
	<br>
<%} %>
<br>
<% if(index>0) %>
<form action="servletQuiz" method="POST">
<%session.setAttribute("index",index-1); %>
  	<input type="submit" value="prev">
</form>
<form action="servletQuiz" method="POST">
<%session.setAttribute("index",index+1); %>
  	<input type="submit" value="next">
</form>

</body>
</html>