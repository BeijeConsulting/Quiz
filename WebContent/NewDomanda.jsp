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
String checkDefaultBook1 = "";
String checkDefaultBook2 = "";
String checkDefaultAns1 = "";
String checkDefaultAns2 = "";
LiveForm live = (LiveForm) session.getAttribute("liveForm");

String s ="";
if (live.isPrimoGiro()){
	s = "Servlet1"; 
}else{
	s = "Servlet2"; 
}

if(domanda.getBook()!=null && domanda.getBook().equals("OCA Oracle Certified Associate Java SE 8 [2014]")) {
	checkDefaultBook1="checked"; 
}

if(domanda.getBook()!=null && domanda.getBook().equals("OCA - OCP Practice Tests Exam 1Z0-808 and Exam 1Z0-809")) {
	checkDefaultBook2="checked";
} 


if(domanda.getAnswerType()!=null && domanda.getAnswerType().equals("checkbox")) {
	checkDefaultAns1="checked"; 
}

if(domanda.getAnswerType()!=null && domanda.getAnswerType().equals("radio")) {
	checkDefaultAns2="checked";
} 

%>
<%= domanda.getAnswerType() %>

<form action=<%=s %> method="post">
	

	<h4>INSERIRE IL LIBRO..</h4>
		<input type="radio" id="book1" name="book" value="OCA Oracle Certified Associate Java SE 8 [2014]" <%=checkDefaultBook1 %>>
		<label for="book1">OCA Oracle Certified Associate Java SE 8 [2014]</label><br>
		<input type="radio" id="book2" name="book" value="OCA - OCP Practice Tests Exam 1Z0-808 and Exam 1Z0-809" <%=checkDefaultBook2 %>>
		<label for="book2">OCA - OCP Practice Tests Exam 1Z0-808 and Exam 1Z0-809</label><br>
		

	<h4>INSERIRE IL NUMERO DEL CAPITOLO..</h4>
		<input type="number" name="chapter" value="<%= domanda.getChapter()>0 ? domanda.getChapter() : ""%>" >
	
	<h4>INSERIRE IL TESTO DELLA DOMANDA..</h4>
		<textarea name="testo" rows="10" cols="60"><%= domanda.getTesto()!=null ? domanda.getTesto() : ""%></textarea>
	
	<h4>MODALITA' DI RISPOSTA..</h4>
		<input type="radio" id="1" name="answerType" value="checkbox" <%=checkDefaultAns1 %>>
		<label for="1">Risposta multipla</label><br>
		<input type="radio" id="2" name="answerType" value="radio" <%=checkDefaultAns2 %>>
		<label for="2">Risposta singola</label><br>
		
	<h4>ELENCO RISPOSTE</h4>
		Quante risposte? <input type="number" name="numeroRisposte" placeholder="Inserire solo numeri.." value="<%= liveForm.getNumeroRisposte()>0 ? liveForm.getNumeroRisposte(): ""%>" <%=liveForm.getNumeroRisposte()>0 ? "disabled=\"disabled\"": "" %>><br><br>	
		
		

	
<%

out.print(liveForm.textBoxToJsp());

%>
	
</form>

</body>
</html>