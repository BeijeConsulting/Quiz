<%@page import="it.beije.quiz.model.Domanda"%>
<%@page import="it.beije.quiz.model.LiveForm"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento nuova domanda</title>
</head>

<body>


<jsp:useBean id="liveForm" class="it.beije.quiz.model.LiveForm" scope="session"></jsp:useBean>
<jsp:useBean id="domanda" class="it.beije.quiz.model.Domanda" scope="session"></jsp:useBean>



<%
LiveForm live = (LiveForm) session.getAttribute("liveForm");

String s ="";
if (live.isPrimoGiro()){
	s = "Servlet1"; 
}else{
	s = "Servlet2"; 
}


%>

<form action=<%=s %> method="post">
	

	<h4>INSERIRE IL LIBRO..</h4>
		<input type="radio" id="book1" name="book" value="OCA Oracle Certified Associate Java SE 8 [2014]" <%= domanda.getBook().equals("OCA Oracle Certified Associate Java SE 8 [2014]") ? "checked" : "" %>>
		<label for="book1">OCA Oracle Certified Associate Java SE 8 [2014]</label><br>
		<input type="radio" id="book2" name="book" value="OCA - OCP Practice Tests Exam 1Z0-808 and Exam 1Z0-809" <%= domanda.getBook().equals("OCA - OCP Practice Tests Exam 1Z0-808 and Exam 1Z0-809") ? "checked":"" %>>
		<label for="book2">OCA - OCP Practice Tests Exam 1Z0-808 and Exam 1Z0-809</label><br>
		

	<h4>INSERIRE IL NUMERO DEL CAPITOLO..</h4>
		<input type="number" name="chapter" value="<%= domanda.getChapter()>0 ? domanda.getChapter() : ""%>" >
	
	<h4>INSERIRE IL TESTO DELLA DOMANDA..</h4>
		<textarea name="testo" rows="10" cols="60"><%= domanda.getTesto()!=null ? domanda.getTesto() : ""%></textarea>
	
	<h4>MODALITA' DI RISPOSTA..</h4>
		<input type="radio" id="1" name="answerType" value="checkbox" <%= domanda.getAnswerType().equals("checkbox") ? "checked":"" %>>
		<label for="1">Risposta multipla</label><br>
		<input type="radio" id="2" name="answerType" value="radio" <%= domanda.getAnswerType().equals("radio") ? "checked":"" %>>
		<label for="2">Risposta singola</label><br>
		
	<h4>ELENCO RISPOSTE</h4>
		Quante risposte? <input type="number" name="numeroRisposte" placeholder="Inserire solo numeri.." value="<%= domanda.getChapter()>0 ? domanda.getChapter() : ""%>"><br><br>	
		
		

	
<%

out.print(liveForm.textBoxToJsp());

%>
	
</form>

</body>
</html>