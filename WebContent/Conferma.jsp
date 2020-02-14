<%@page import="it.beije.quiz.model.Domanda"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="domanda" class="it.beije.quiz.model.Domanda" scope="session" />

			<jsp:setProperty property="id" param="id" name="domanda"/>
			<jsp:setProperty property="book" param="book" name="domanda"/>
			<jsp:setProperty property="chapter" param="chapter" name="domanda"/>
			<jsp:setProperty property="question" param="question" name="domanda"/>
			<br><jsp:setProperty property="testo" param="testo" name="domanda"/>
			<jsp:setProperty property="answerType" param="answerType" name="domanda"/>
			<br><jsp:setProperty property="risposte" param="risposte" name="domanda"/>
		    <jsp:setProperty property="rispostaUtente" param="rispostaUtente" name="domanda"/>
		    <jsp:setProperty property="rispostaEsatta" param="rispostaEsatta" name="domanda"/>
		    <br><jsp:setProperty property="spiegazione" param="spiegazione" name="domanda"/>

	ID: 			<jsp:getProperty property="id" name="domanda"/>&nbsp;&nbsp;&nbsp;&nbsp;
	Book:			<jsp:getProperty property="book" name="domanda"/>&nbsp;&nbsp;&nbsp;&nbsp;
	Chapter:		<jsp:getProperty property="chapter" name="domanda"/>&nbsp;&nbsp;&nbsp;&nbsp;
	Question:		<jsp:getProperty property="question" name="domanda"/><br><br>
	Testo:			<br><jsp:getProperty property="testo" name="domanda"/><br><br>
	AnswerType: 	<jsp:getProperty property="answerType" name="domanda"/><br><br>
	Risposte:		<br><jsp:getProperty property="risposte" name="domanda"/><br><br>
	RispostaUtente: <jsp:getProperty property="rispostaUtente" name="domanda"/>&nbsp;&nbsp;&nbsp;&nbsp;
	RispostaEsatta: <jsp:getProperty property="rispostaEsatta" name="domanda"/><br><br>
	Spiegazione:	<br><jsp:getProperty property="spiegazione" name="domanda"/><br><br>

</body>
</html>