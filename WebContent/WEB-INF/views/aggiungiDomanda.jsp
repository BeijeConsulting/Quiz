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

			<table style="width: 100%; border: 0px">
				<div style="width: 100%">
					<div style="width: 50%; float: left">


						Testo: <br>
						<textarea name="param_testo" form="formDomande" cols="50"
							rows="10"></textarea>
					</div>
					<div style="width: 50%; float: right">
						<br> <input type="button" onclick="inserisciRisposta()" value="inserisci risposta" id="aggiungiRisp">
						<br> <input type="button" onclick="rimuoviRisposta()" value="rimuovi risposta" id="rimuoviRisp">		
						<br> <input type="button" onclick="bloccaRisposta()" value="blocca risposta">									
						<div id="insertBook"></div>
						<div type="hidden" name="n_risposte"  id="nRisp"></div> 
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

<script type="text/javascript">
var i=0;
function inserisciRisposta(){
	
	insert=document.createElement('input');
	insert.setAttribute("type","text");
	insert.setAttribute("name","risposta"+i);
	insert.setAttribute("id","idRisposta"+i);

	document.getElementById("insertBook").appendChild(insert);
	
	i++;
}

function rimuoviRisposta(){

	var x = document.getElementById("insertBook").lastChild;
	console.log(x);
	var id= x.getAttribute("id");
	document.getElementById(id).remove();
	--i;
}

function bloccaRisposta(){
	var btnAgg = document.getElementById("aggiungiRisp");
	var btnRim = document.getElementById("rimuoviRisp");

	btnAgg.remove();
	btnRim.remove();
	
	var divRisp = document.getElementById("nRisp");
	divRisp.setAttribute("value",i);

	
}



</script>


</body>
</html>