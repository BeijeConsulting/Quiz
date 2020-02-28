<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">



</style>
<meta charset="ISO-8859-1">
<title>Aggiungi domanda</title>
</head>
<body align="center" style="margin: 0">

<div style="width: 100%; magin: 0px; span: 0">

<h1
style="color: white; background-color: black; margin: 0; height: 50px; align: center">
Form per aggiungere una domanda al quiz</h1>

<h3>Inserisci i seguenti dati:</h3>
<label for="libro">Libro:</label>

<%--Clark:	Da sistemare, forse serve il metodo di lettura sull'index.xml per prender i libri e cambiare i parametri --%>

<form action="" method="POST" name="myForm" id="formDomande">

<c:forEach items="${listaLibri}" var="libro">
<input type="radio" id="book" name="param_libro"
value="${libro.title}">
<label for="book">${libro.title}</label>
<br>
<br>
</c:forEach>
<br> <br> Id domanda : <input type="number" name="param_id">

Capitolo: <input type="number" name="param_capitolo" id="capitoli"><br>
<br> Numero della domanda: <br> <input type="number"
name="param_nDomanda" style="align: center"><br> <br>

<table style="width: 100%; border: 0px">
<div style="width: 100%">
<div style="width: 50%; float: left">


Testo: <br>
<textarea name="param_testo" form="formDomande" cols="50"
rows="10"></textarea>
</div>
<div style="width: 50%; float: right">
<br> <input type="button" onclick="inserisciRisposta()"
value="inserisci risposta" id="aggiungiRisp"> <br> <input
type="button" onclick="rimuoviRisposta()"
value="rimuovi risposta" id="rimuoviRisp">
<div id="insertBook"></div>
<br> <input type="hidden" name="n_risposte" value="0"
id="nRisp">
</div>
</div>
</table>
<br> Tipo di domanda: <br> <input type="radio"
id="checkbox" name="param_type" value="checkbox"> <label
for="checkbox">Risposta multipla</label> <input type="radio"
id="radio" name="param_type" value="radio"> <label
for="radio">Risposta singola</label><br> <br> Se le
risposte esatte sono multiple dividile con "," <br>

RisposteEsatte:<input type="text" name="param_risposteEsatte"><br>
<br> Spiegazione:<br>
<textarea cols="50" rows="10" name="param_spiegazione"></textarea>
<br> <br> <input type="submit" value="Salva"
onclick="valida()">


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
	var lettere=[];

	insert.setAttribute("placeholder",String.fromCharCode(65 + i)+' :');


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

function compilaForm(){

	var divRisp = document.getElementById("nRisp");
	divRisp.setAttribute("value",""+i);
}



function valida(){
	var capitoli= document.myForm.param_capitolo.value;
	var id=document.myForm.param_id.value;
	var nDomanda= document.myForm.param_nDomanda.value;
	var testo= document.myForm.param_testo.value;
	var spiegazione= document.myForm.param_spiegazione.value;
	var libro= document.myForm.param_libro.value;
	
	var listaRisposte=[];
	for(;i>0;){
		console.log(i);
		var a="idRisposta"+(--i);
		listaRisposte.push( document.getElementById(a).value);
		//listaRisposte.push(document.myForm.a.value);
		console.log(i);
//	console.log(document.myForm.a.value);
	}
	

	while(listaRisposte.length!=0){
		var risposta=listaRisposte.pop();
		console.log("dentro for controllo");
		console.log(risposta);
		if(risposta=="" || risposta=="undefined" ||risposta==null || risposta.length<=0){
			console.log("dovrebbe uscire");
			alert("Tutti i campi delle risposte devono essere inserite!!!");
			return false;
		}
	}
		
		
		
		
	if((libro== "") || (libro == "undefined")) {
		
		alert("Devi inserire libro");
		console.log(testo);
		return false;
	}
	if ((capitoli == "") || (capitoli == "undefined") || isNaN(capitoli)) {
		alert("Devi inserire capitolo");
		console.log(capitoli);
		return false;

	}

	if((id== "") || (id == "undefined")) {
		
			alert("Devi inserire id");
			console.log(id);
			return false;

		}

		if((nDomanda== "") || (nDomanda == "undefined"))	{
			alert("Devi inserire numero domanda");
			console.log(nDomanda);
			return false;
		}

		if((testo== "") || (testo == "undefined")) {
			
				alert("Devi inserire testo");
				console.log(testo);
				return false;
			}
		if((spiegazione== "") || (spiegazione == "undefined")) {
			
			alert("Devi inserire testo");
			console.log(testo);
			return false;
		}
			else{
				compilaForm();
				document.myForm.action = "./salvaDomanda"; 
				document.myForm.submit();
			}

		}


		</script>


		</body>
		</html>