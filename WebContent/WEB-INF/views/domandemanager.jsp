<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>

.param{
display : none;
}

.domanda{
display : none;
}

.risposte {
	width: 200px;
}

</style>
<body>

<p>SELEZIONA: </p>

<input id="visualDomanda" value="visualDomanda" name="selezione" type="radio" onClick="visualParametri()">
<label for="visualDomanda">Visualizza una domanda</label> &nbsp
<br>

<input id="insertDomanda" value="insertDomanda" name="selezione" type="radio" onClick="visualParametri()">
<label for="insertDomanda">Inserisci una domanda</label>
<br>

<input id="updateDomanda" value="updateDomanda" name="selezione" type="radio" onClick="visualParametri()">
<label for="updateDomanda">Aggiorna una domanda</label>
<br>

<input id="deleteDomanda" value="deleteDomanda" name="selezione" type="radio" onClick="visualParametri()">
<label for="deleteDomanda">Cancella una domanda</label>
<br><br>

<div id="parametriVisual" class="param">
Libro:  &nbsp <input id="libro" type="text"> &nbsp
Capitolo:  &nbsp <input id="capitolo" type="number"> &nbsp
Domanda:  &nbsp <input id="domanda" type="number">
</div>
<br><br>

<div id="parametriInsert" class="param">

Testo: <br> 
<textarea id="testo" rows="2" cols="50"></textarea><br><br>

Tipo di domanda:  &nbsp 
<input id="singola" value="radio" name="tipoRisposta" type="radio">
<label for="singola">Risposta singola</label>

<input id="multipla" value="checkbox" name="tipoRisposta" type="radio">
<label for="singola">Risposta multipla</label><br><br>

<table >
<tr>
		<td class="valignTop">Risposte:&nbsp;<button type="button" onclick="createNewResponse()">Add</button>		&nbsp;
	    </td>
		<td class="risposte">
		<div style="float: left;">
		<input type="text" maxlength="5" class="number" id="valueRisposta1" placeholder="A" />
		</div>
		<div><input style="width: 538px;" type="text" placeholder="testo della risposta" id="risposta1" />
		</div>
		</td>
</tr>
</table>
<br>
Risposta Utente: &nbsp 
<input id="rispostaUtente" type="text"> &nbsp &nbsp &nbsp &nbsp 
Risposta Esatta: &nbsp 
<input id="rispostaEsatta" type="text"><br><br>
Spiegazione: <br> 
<textarea id="spiegazione" rows="2" cols="50"></textarea><br><br>
</div>
<br><br>

<input type="button" value="Esegui" onclick="esegui()">
&nbsp &nbsp &nbsp &nbsp
<input type="iniziaquiz" value="Inizia Quiz" onclick="iniziaQuiz()")>

<br><br>
<!-- <div id="domandaVis" class="domandaVis"> -->
<!-- <p id="visual">Ciao</p> -->
<!-- </div> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
	var selezione = document.getElementsByName("selezione");
	var libro = document.getElementById("libro").value = "";
	var capitolo = document.getElementById("capitolo").value = "";
	var domanda = document.getElementById("domanda").value = "";
	var idBook = "";
	var valoreSelezione = "";
	var c = 2;
	var risposte = [];
	var tipoRisposta = "";
	
function esegui(){
		selezione = document.getElementsByName("selezione");
		GetSelezione();
		window[valoreSelezione]();
		}
		
function GetSelezione(){
	for (var i = 0; i < selezione.length; i++){
		if(selezione[i].checked){
		valoreSelezione = selezione[i].value;
		break;
		}
	}
}

function visualDomanda(){	
	var myjson = "";
	getIdBook(),
	
	 fetch('http://localhost:8080/quiz/get/domanda/' + idBook)
	  .then(response => response.json())
	  .then(json => {
		  var obj = json;
		  JSON.stringify(obj);
		console.log(json);
		console.log(obj);
		document.getElementById("domandaVis").style.display = "block";
		document.getElementById("visual").innerHTML = JSON.stringify(obj)
		})
		.catch(error => console.log('!!'));
}
	
function insertDomanda(){
	getRisposte();
	
	console.log(risposte);
	
	 fetch('http://localhost:8080/quiz/new/domanda', {
		    method: 'POST',
		    body: JSON.stringify({
		      book: document.getElementById("libro").value,
		      chapter: document.getElementById("capitolo").value,
		      question: document.getElementById("domanda").value,
		      testo: document.getElementById("testo").value,
		      answerType: tipoRisposta,
		      risposte: risposte,
		   	  rispostaUtente: document.getElementById("rispostaUtente").value,
		      rispostaEsatta: document.getElementById("rispostaEsatta").value,
		      spiegazione: document.getElementById("spiegazione").value
		    }),
		    headers: {
		      "Content-type": "application/json; charset=UTF-8"
		    }
		  })
	  .then(response => response.json())
	  .then(json => {
		console.log( json);})
		.catch(error => console.log('!!'));
}		
		
function updateDomanda(){
	getRisposte();
	getIdBook();
	
	 fetch('http://localhost:8080/quiz/update/domanda/' + idBook, {
		    method: 'PUT',
		    body: JSON.stringify({
		      book: document.getElementById("libro").value,
		      chapter: document.getElementById("capitolo").value,
		      question: document.getElementById("domanda").value,
		      testo: document.getElementById("testo").value,
		      answerType: tipoRisposta,
		      risposte: risposte,
		   	  rispostaUtente: document.getElementById("rispostaUtente").value,
		      rispostaEsatta: document.getElementById("rispostaEsatta").value,
		      spiegazione: document.getElementById("spiegazione").value
		    }),
		    headers: {
		      "Content-type": "application/json; charset=UTF-8"
		    }
		  })
	  .then(response => response.json())
	  .then(json => {
		console.log( json);})
		.catch(error => console.log('!!'));
}

function deleteDomanda(){
	getIdBook();
	
	fetch('http://localhost:8080/quiz/delete/domanda/' + idBook, {
	    method: 'DELETE'})
}

function getIdBook(){
	libro = document.getElementById("libro").value;
	capitolo = document.getElementById("capitolo").value;
	domanda = document.getElementById("domanda").value;
	idBook = libro + "-" + capitolo + "-" + + domanda;
	console.log(idBook);
}

function visualParametri(){
	
	GetSelezione();
	document.getElementById("libro").value = '';
	document.getElementById("capitolo").value = '';
	document.getElementById("domanda").value = '';
	
	console.log(libro);
	
	console.log(valoreSelezione);
	if(valoreSelezione == "visualDomanda" || valoreSelezione == "deleteDomanda"){
	document.getElementById("parametriVisual").style.display = "inline";
	document.getElementById("parametriInsert").style.display = "none";
	
	} else if(valoreSelezione == "insertDomanda" || valoreSelezione == "updateDomanda") {
	document.getElementById("parametriVisual").style.display = "inline";
	document.getElementById("parametriInsert").style.display = "inline";
	}
}

function getRisposte(){
	var radios = document.getElementsByName('tipoRisposta');

	for(let i = 1; i < c; i++){
		risposte.push({
			value: $('#valueRisposta' + i).val(),
			text: $('#risposta' + i).val()
		})
	}
	
	
	for (let i = 0, length = radios.length; i < length; i++) {
	  if (radios[i].checked) {
	    tipoRisposta = radios[i].value;
	    break;
	  }
	}
}


function iniziaQuiz(){
	fetch('http://localhost:8080/quiz/startquiz');
}


function createNewResponse() {
   	$('.risposte').append('<div style="margin-top: 5px;"><div style="float: left;"><input type="text" maxlength="5" id="valueRisposta' + c + '" class="number" placeholder="A" /></div><div><input style="width: 538px;" type="text" placeholder="testo della risposta" id="risposta' + c + '" /></div></div>');
   	c++;
}
</script>

</body>
</html>