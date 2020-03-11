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

<input type="button" value="Esegui" onclick="esegui()">

<br><br>
<div id="domandaVis" class="domandaVis">
<p id="visual">Ciao</p>
</div>

<script>

	var selezione = document.getElementsByName("selezione");
	var libro = document.getElementById("libro").value = "";
	var capitolo = document.getElementById("capitolo").value = "";
	var domanda = document.getElementById("domanda").value = "";
	var idBook = "";
	var valoreSelezione = "";
	
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
	 fetch('http://localhost:8080/quiz/new/domanda')
	  .then(response => response.json())
	  .then(json => {
		console.log( json);})
		.catch(error => console.log('!!'));
}		
		
function updateDomanda(){
	getIdBook();
	
	 fetch('http://localhost:8080/quiz/update/domanda/' + idBook)
	  .then(response => response.json())
	  .then(json => {
		console.log( json);})
		.catch(error => console.log('!!'));
}

function deleteDomanda(){
	getIdBook();
	
	fetch('http://localhost:8080/quiz/delete/domanda/' + idBook)
	  .then(response => response.json())
	  .then(json => {
		console.log( json);})
		.catch(error => console.log('!!'));
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
	if(valoreSelezione == "visualDomanda" || valoreSelezione == "updateDomanda" || valoreSelezione == "deleteDomanda")
	document.getElementById("parametriVisual").style.display = "inline";
	 else 
	document.getElementById("parametriVisual").style.display = "none";
}

</script>

</body>
</html>


