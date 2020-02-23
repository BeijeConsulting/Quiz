<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi domanda</title>
</head>
<body align="center" style="margin:0" >

<div style="width:100%; magin:0px; span:0"> 

<h1 style="color:white; background-color:black;margin:0;height:50px;align:center">
Form per aggiungere una domanda al quiz
</h1>



<%--
<jsp:useBean id="domanda" class="it.beije.quiz.model.Domanda" scope="session" />

<jsp:setProperty property="libro" name="domanda" />
<jsp:setProperty property="param_id" name="domanda" />
<jsp:setProperty property="param_capitolo" name="domanda" />
<jsp:setProperty property="param_nDomanda" name="domanda" />
<jsp:setProperty property="param_testo" name="domanda" />
<jsp:setProperty property="param_nDomanda" name="domanda" />
<jsp:setProperty property="param_type" name="domanda" />
<jsp:setProperty property="param_risposteEsatte" name="domanda"/>
 --%>

<h3>Inserisci i seguenti dati:</h3>
		<label for="libro">Libro:</label> 
		
		<%--Clark:	Da sistemare, forse serve il metodo di lettura sull'index.xml per prender i libri e cambiare i parametri --%>
	
		 <form action="./salvaDomanda" method="POST" id="formDomande">

			<c:forEach items="${listaLibri}" var="libro">
				<input type="radio" id="book" name="param_libro" value="${libro.title}">
				<label for="book">${libro.title}</label>
				<br>
				<br>
			</c:forEach>		 
		 <br><br>
		 Id domanda :  <input type="text" name="param_id" >
		 
		Capitolo: <input type="text" name="param_capitolo"><br><br>
		
		Numero della domanda: <br>
		 <input type="text" name="param_nDomanda" style="align:center"><br><br>
		
		<table style="width:100%; border:0px">
			 <div style = "width:100%"> 
			<div style= "width:50%;float:left">
			
			
			Testo: <br> <textarea name="param_testo"
						form="formDomande" cols="50" rows="10"></textarea>
				</div>
				<div style="width:50%; float:right">
				
				
				Inserisci le risposte divise da ";": <br>
					<textarea name="param_risposte" form="formDomande" cols="50" rows="10"></textarea><br>
			</div>
			
			</div>
		</table>
		<br>
		
			
			
		Tipo di domanda: <br> <input type="radio" id="checkbox" name="param_type" value="checkbox">
 			 <label for="checkbox">Risposta multipla</label>
  		<input type="radio" id="radio" name="param_type" value="radio">
 			 <label for="radio">Risposta singola</label><br><br>
 			 
 			 
 			  Se le risposte esatte sono multiple dividile con "," <br>
 			  
		 RisposteEsatte:<input type="text" name="param_risposteEsatte"><br><br> 
		
		 Spiegazione:<br><textarea cols="50" rows="10" name="param_spiegazione"></textarea><br><br> 
		
		 <input type="submit" value="Salva">
	</form>
	
	
	<form action="visualizzaServlet" method="POST">
	<input type="submit" value="Visualizza le domande">
	</form>


</div>
</body>
</html>