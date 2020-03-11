<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.quiz.Utils" %>
<%@ page import="it.beije.quiz.model.Libro" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<style>
body {
	background-color: #b8adad;
}

.container {
	display: block;
	position: relative;
	left: -350px;
	padding-left: 35px;
	margin-bottom: 12px;
	cursor: pointer;
	font-size: 22px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

.container input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
	height: 0;
	width: 0;
}

.checkmark {
	position: absolute;
	top: 0;
	left: 0;
	height: 25px;
	width: 25px;
	background-color: #eee;
}

.container:hover input ~ .checkmark {
	background-color: #ccc;
}

.container input:checked ~ .checkmark {
	background-color: #2196F3;
}

.checkmark:after {
	content: "";
	position: absolute;
	display: none;
}

.container input:checked ~ .checkmark:after {
	display: block;
}

.container .checkmark:after {
	left: 9px;
	top: 5px;
	width: 5px;
	height: 10px;
	border: solid white;
	border-width: 0 3px 3px 0;
	-webkit-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
}
</style>

<body>
	<div id="contenitore" style="padding: 10px;">
	Questa è la pagina di ingresso al tuo Quiz Online
	<br>
	<br> Seleziona da quale libro prendere le domande:
	<br>
	<br>
	<form id="getLibri" action="confermaselezione" method="POST">
		<%
		/*List<Libro> libri = Utils.getLibri();
		int i = 1;
		for(Libro l : libri) {
			out.println("<label class=\"container\"><input type=\"checkbox\" name=\"libro" + i +
					"\" value=\"" + l.getDir() + "\">" + l.getTitle() + "<span class=\"checkmark\"></span></label>");
			i++;
		}*/
		%>
		
		
		
		<!-- Totale domande caricate : ${ totDomande }<br> Tempo disponibile
		: ${ totDomande * 2 } minuti<br> <br>-->


		<!-- <button type="submit" class="btn btn-info">CONFERMA</button-->
		
	</form>
	</div>
	
<script>

	var domande;

	fetch('http://localhost:8080/Quiz/libri')
		.then(response => response.json())
		.then(json => {
			console.log(json);
			for(let i = 0; i < json.length; i++) {
				console.log(i);
				document.getElementById("getLibri").innerHTML += "<label class=\"container\"><input id=" + json[i].dir + " onclick=\"updateTime('" + json[i].dir + "')\" type=\"checkbox\" name=\"libro_" + i +
				"\" value=\"" + json[i].dir + "\">" + json[i].title + "<span class=\"checkmark\"></span></label>";
			}
			
			document.getElementById("getLibri").innerHTML += "<div id=\"tempodomande\">Totale domande caricate: <span id=\"numDomande\">0</span><br>" + "Tempo disponibile: <span id=\"time\">0</span> minuti";
			document.getElementById("getLibri").innerHTML += "<br><button onclick=\"conferma()\" type=\"buttom\" class=\"btn btn-info\">CONFERMA</button>";
			//document.getElementById("getLibri").innerHTML += "<br><input onclick=\"conferma()\" type=\"submit\" class=\"btn btn-info\">CONFERMA</button>";
		})
	.catch(error => console.log('Errore get Libri'));


</script>

<script>

var tempo;
var old = "";
//var libri = [];
//var allQuestion = [];

function updateTime(dir) {
	fetch('http://localhost:8080/Quiz/domande/' + dir)
	  .then(response => response.json())
	  .then(jj => {
		console.log(jj);
		let d = jj.length;
		let t = d * 2;
		if(document.getElementById(dir).checked == true) {
			console.log("true");
			document.getElementById("numDomande").innerHTML = Number(document.getElementById("numDomande").innerHTML) + d;
			domande = document.getElementById("numDomande").innerHTML;
			document.getElementById("time").innerHTML = Number(document.getElementById("time").innerHTML) + t;
			tempo = document.getElementById("time").innerHTML;
			//libri += dir;
		} else {
			console.log("false");
			document.getElementById("numDomande").innerHTML = Number(document.getElementById("numDomande").innerHTML) - d;
			domande = document.getElementById("numDomande").innerHTML;
			document.getElementById("time").innerHTML = Number(document.getElementById("time").innerHTML) - t;
			tempo = document.getElementById("time").innerHTML;
			//libri -= dir;
		}
	  })
	  .catch(error => console.log('!!'));
}

function conferma() {
	console.log("conferma");
	old = document.getElementById("contenitore").innerHTML;
	document.getElementById("contenitore").innerHTML = "<form method=\"post\" action=\"viewdomanda/0\">Domande selezionate: " + domande + "<br>Tempo disponibile: " + tempo + "<br><buttom type\"button\" value=\"Reset\" onclick=\"reset2()\" class=\"btn btn-secondary\">Reset</buttom><input class=\"btn btn-primary\" type=\"submit\" value=\"Start\" name=\"inizia\" /></form>";
	//document.getElementById("contenitore").innerHTML = "Domande selezionate: " + domande + "<br>Tempo disponibile: " + tempo + "<br><buttom type\"button\" value=\"Reset\" onclick=\"reset2()\" class=\"btn btn-secondary\">Reset</buttom><buttom onclick)=\"startQuiz()\" class=\"btn btn-primary\" type=\"submit\" value=\"Start\" name=\"inizia\">Start</buttom>"
	//window.location.replace("http://localhost:8080/Quiz/viewdomanda/0");
}

function reset2() {
	document.getElementById("contenitore").innerHTML = old;
	domande = 0;
	tempo = 0;
	document.getElementById("numDomande").innerHTML = domande;
	document.getElementById("time").innerHTML = tempo;
}

/*
function listDomandeLibro(libriDir) {
	
	fetch('http://localhost:8080/Quiz/domande/' + libriDir)
	  .then(response => response.json())
	  .then(jj => {
		console.log(jj);
		allQuestion += jj;
		return jj;
	  }
}*/
/*
function startQuiz() {
	fetch('http://localhost:8080/Quiz/newdomanda', {
		method: 'POST',
		body: JSON.stringify(domanda),
		headers: {
		  "Content-type": "application/json; charset=UTF-8",
		  'Accept': 'application/json'
		}
	  })
}*/
</script>

</body>
</html>

