<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link href="<c:url value="/pages/css/team_clariga_stylesheet.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/4.2.0/normalize.css">
<head>
<title>Aggiungi domanda</title>
</head>
<body style="background-color: hsl(0, 100%, 90%);">
	<header class="header clearfix">
		<a href="./" class="header__logo">Logo</a> <a href=""
			class="header__icon-bar"> <span></span> <span></span> <span></span>
		</a>
		<ul class="header__menu animate">
			<li class="header__menu__item"><a href="">Home</a></li>
			<li class="header__menu__item"><a href="">Single</a></li>
			<li class="header__menu__item"><a href="">Page</a></li>
			<li class="header__menu__item"><a href="">Item</a></li>
			<li class="header__menu__item"><a href="">Item</a></li>
		</ul>
	</header>
	<section class="cover cover--single">
		<div class="cover__filter"></div>
		<div class="cover__caption">
			<div class="cover__caption__copy">
				<h1>Team ClaRiGa</h1>
				<h2>forward-looking team</h2>
			</div>
		</div>
	</section>


	<article class="panel">
		<div class="panel__copy" style="background-color: #da614e">
			<h2 class="panel__copy__title">Inserisci Nuova Domanda</h2>
			<form action="" method="POST" name="myForm" id="formDomande">

				<label for="books">Scegli il libro in cui inserire la
					domanda:<br> <br>
				</label> <select class="select-css" id="books" name="param_libro">
					<c:forEach items="${listaLibri}" var="libro">
						<option id="book" value="${libro.title}">${libro.title}</option>
					</c:forEach>
				</select> <br> <br> Id domanda <input type="number"
					placeholder="inserisci id domanda" class="quantity" min="1"
					name="param_id"> Capitolo <input type="number"
					placeholder="inserisci capitolo" class="quantity" min="1"
					name="param_capitolo" id="capitoli"><br> <br>
				Numero della domanda <input type="number"
					placeholder="inserisci n° domanda" class="quantity" min="1"
					name="param_nDomanda" style="align: center"><br> <br>

				Testo della domanda: <br> <br>
				<textarea name="param_testo" form="formDomande" cols="87" rows="12"></textarea>


				<input type="button" onclick="inserisciRisposta()"
					value="inserisci risposta" id="aggiungiRisp"> <input
					type="button" onclick="rimuoviRisposta()" value="rimuovi risposta"
					id="rimuoviRisp">
				<div id="insertBook"></div>
				<br> <input type="hidden" name="n_risposte" value="0" id="nRisp">
					Tipo di domanda: <br> <input type="radio"
					id="checkbox" name="param_type" value="checkbox"> <label
					for="checkbox">Risposta multipla</label> <input type="radio"
					id="radio" name="param_type" value="radio"> <label
					for="radio">Risposta singola</label><br> <br> <br>
				RisposteEsatte :<input type="text" placeholder='esempio : "ABCD"' name="param_risposteEsatte"><br>
				<br> Spiegazione:<br>
				<textarea cols="87" rows="12" name="param_spiegazione"></textarea>
				<br> <br> <input type="submit" value="Salva"
					onclick="valida()">



			</form>
		</div>




	</article>
	<footer class="footer clearfix">
		Copyright - 2020 TeamClaRiGa_Design

		<form action="nostriContatti.jsp" method="POST">
			<input type="submit" value="chi siamo" style="float: right;">
		</form>
	</footer>





	<script type="text/javascript">
		var i = 0;
		var j = i;
		function inserisciRisposta() {

			insert = document.createElement('input');
			insert.setAttribute("type", "text");
			insert.setAttribute("name", "risposta" + i);
			insert.setAttribute("id", "idRisposta" + i);

			insert.setAttribute("placeholder", String.fromCharCode(65 + i)
					+ ' :');

			document.getElementById("insertBook").appendChild(insert);

			i++;
			j=i;
		}

		function rimuoviRisposta() {

			var x = document.getElementById("insertBook").lastChild;
			//console.log(x);
			var id = x.getAttribute("id");
			document.getElementById(id).remove();
			--i;
			j=i;
		}

		function compilaForm() {

			var divRisp = document.getElementById("nRisp");
			divRisp.setAttribute("value", "" + j);
		}

		function valida() {
			
			var capitoli = document.myForm.param_capitolo.value;
			var id = document.myForm.param_id.value;
			var nDomanda = document.myForm.param_nDomanda.value;
			var testo = document.myForm.param_testo.value;
			var spiegazione = document.myForm.param_spiegazione.value;
			var libro = document.myForm.param_libro.value;

			var listaRisposte = [];
		
			for (; i > 0;) {
				//console.log(i);
				var a = "idRisposta" + (--i);
				listaRisposte.push(document.getElementById(a).value);
				//listaRisposte.push(document.myForm.a.value);
				//console.log(i);
				//	console.log(document.myForm.a.value);
			}

			while (listaRisposte.length != 0) {
				var risposta = listaRisposte.pop();
				console.log("dentro for controllo");
				console.log(risposta);
				if (risposta == "" || risposta == "undefined"
						|| risposta == null || risposta.length <= 0) {
					//console.log("dovrebbe uscire");
					alert("Tutti i campi delle risposte devono essere inserite!!!");
					return false;
				}
			}

			if ((libro == "") || (libro == "undefined")) {

				alert("Devi inserire libro");
				//console.log(testo);
				return false;
			}
			if ((capitoli == "") || (capitoli == "undefined")
					|| isNaN(capitoli)) {
				alert("Devi inserire capitolo");
				//console.log(capitoli);
				return false;

			}

			if ((id == "") || (id == "undefined")) {

				alert("Devi inserire id");
				console.log(id);
				return false;

			}

			if ((nDomanda == "") || (nDomanda == "undefined")) {
				alert("Devi inserire numero domanda");
				console.log(nDomanda);
				return false;
			}

			if ((testo == "") || (testo == "undefined")) {

				alert("Devi inserire testo");
				console.log(testo);
				return false;
			}
			if ((spiegazione == "") || (spiegazione == "undefined")) {

				alert("Devi inserire testo");
				console.log(testo);
				return false;
			} else {
				compilaForm();
				document.myForm.action = "./salvaDomanda";
				document.myForm.submit();
			}

		}
	</script>


</body>
</html>