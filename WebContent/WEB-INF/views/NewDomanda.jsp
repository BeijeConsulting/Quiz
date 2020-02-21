<%@page import="it.beije.quiz.model.Domanda"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento nuova domanda</title>
</head>

<body>


<form action="./${pathController}" method="post">
	

	<h4>INSERIRE IL LIBRO..</h4>
		<c:forEach var="scelte" items="${libri}">
			<input type="radio" value="${scelte.idBook}" name="bookSelection"  ${scelte.checked}>${scelte.title}<br>
		</c:forEach>
		<input type="radio" value="new" name="bookSelection" ${checkedNewBook}>Nuovo libro...<br>
		
		${datiLibro }

	<h4>INSERIRE IL NUMERO DEL CAPITOLO..</h4>
		<input type="number" name="chapter" value="${chapter }" >
		
	<h4>INSERIRE IL NUMERO DELLA DOMANDA..</h4>
		<input type="number" name="question" value="${question }" >
		
	<h4>INSERIRE IL NOME DEL FILE DA UTILIZZARE/CREARE..</h4>
		<input type="text" name="chapterString" value="${chapterString }" >
	
	<h4>INSERIRE IL TESTO DELLA DOMANDA..</h4>
		<textarea name="testo" rows="10" cols="60">${testo }</textarea>
	
	<h4>MODALITA' DI RISPOSTA..</h4>
		<input type="radio" id="1" name="answerType" value="checkbox" ${answerTypeCheckbox}>
		<label for="1">Risposta multipla</label><br>
		<input type="radio" id="2" name="answerType" value="radio" ${answerTypeRadio}>
		<label for="2">Risposta singola</label><br>
		
		
	<h4>ELENCO RISPOSTE</h4>
		Quante risposte? <input type="number" name="numeroRisposte" placeholder="Inserire solo numeri.." 
			<c:if test="${numeroRisposte > 0 }"> value="${numeroRisposte}" disabled="disabled" </c:if>><br><br>	
			
	<% int i = 0; %>
	<c:if test="${numeroRisposte > 0}">
		<c:forEach begin="0" end="${numeroRisposte-1}">
				RISPOSTA<%=i+1%>: <input type="text" name="r<%=i++%>"><br>
		</c:forEach>	
	</c:if>
	
	<c:if test="${numeroRisposte > 0}">
		<c:if test="${bookTypeButton==true}">
			<h4>INSERIRE LA/E RISPOSTA/E CORRETTA/E..</h4>
				<%int x = 0; %>
				<c:if test="${numeroRisposte > 0}">
					<c:forEach begin="0" end="${numeroRisposte-1}">
							RISPOSTA<%=x+1%>: <input type="${answerType}" name="rispostaEsatta" value="<%=x++%>"><br>
					</c:forEach>	
				</c:if>
			
			<h4>INSERIRE LA SPIEGAZIONE..</h4>
				<textarea name="spiegazione" rows="4" cols="60"></textarea>
				
			<input type="submit" value="INSERISCI NUOVO LIBRO">
		</c:if>
		<c:if test="${bookTypeButton==false}">
			<h4>INSERIRE LA/E RISPOSTA/E CORRETTA/E..</h4>
				<%int x = 0; %>
				<c:if test="${numeroRisposte > 0}">
					<c:forEach begin="0" end="${numeroRisposte-1}">
							RISPOSTA<%=x+1%>: <input type="${answerType}" name="rispostaEsatta" value="<%=x++%>"><br>
					</c:forEach>	
				</c:if>
			
			<h4>INSERIRE LA SPIEGAZIONE..</h4>
				<textarea name="spiegazione" rows="4" cols="60"></textarea>
				
			<input type="submit" value="COMPLETA INSERIMENTO">
		</c:if>
	</c:if>
	
	<c:if test="${bookType == true}">
		<input type="submit" value="INSERISCI LE RISPOSTE">
	</c:if>

</form>

</body>
</html>