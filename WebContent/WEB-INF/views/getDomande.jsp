
<html>
<body>
	
LIBRO: <input id="libro" type="text" name="libro"><br>
CAPITOLO: <input id="capitolo" type="text" name="capitolo"><br>
DOMANDA: <input id="domanda" type="text" name="domanda"><br>

<input type="button" value="CERCA" onclick="getDomandeQuiz()">

<br><br>Domande: <b id="question"></b>
<br>
<div id="domande"></div>


<input type="button" value="INSERISCI" onclick="postQuiz()" />

<script>
// GET
function getDomandeQuiz() {
	document.getElementById("domande").innerHTML = "";
	let url = 'http://localhost:8080/Quiz/domande/';
	
	if(document.getElementById("libro").value != "") {
		url += document.getElementById("libro").value + "/";
		if(document.getElementById("capitolo").value != "") {
			url += document.getElementById("capitolo").value + "/";
			if(document.getElementById("domanda").value != "") {
				url += document.getElementById("domanda").value + "/";
			}
		}
	}

	fetch(url)
		.then(response => response.json())
		.then(json => {
			document.getElementById("question").innerHTML = "Hai selezionato " + json.length + " domande!";
			let i;
			for(i = 0; i < json.length; i++) {
				let risposte = getRisposte(json[i]);
				document.getElementById("domande").innerHTML += "<div style='border: 1px solid grey; border-radius: 5px; padding: 10px;'>"+ "ID: " + json[i].id + "<br>Testo: " + json[i].testo + "<br>" + "Risposte: " + risposte + "Spiegazione: " + json[i].sipegazione + "</div><br>";
			}
		})
		.catch(error => console.log('Errore'));
	
	//" + getRisposte(json[i].risposte)+ "
}

// carica la lista delle risposte
function getRisposte(domanda) {
	let risposte = "";
	for(let i = 0; i < domanda.risposte.length; i++) {
		risposte += domanda.risposte[i].value + " - " + domanda.risposte[i].text;
	}
	return risposte;
}

var newQuestion = {
	"id": "nostro_libro|8|1",
	"book": "Libro Dinal",
	"chapter": "6",
	"question": "1",
	"testo": "45454555555555555555555555555555",
	"answerType": "checkbox",
	"risposte": [
		{
			"value": "A",
			"text": "aaa"
		},
		{
			"value": "B",
			"text": "bbb"
		},
		{
			"value": "C",
			"text": "ccc"
		}
	],
	"rispostaUtente": "",
	"rispostaEsatta": "AC",
	"spiegazione": "spiegazione"
}

// POST
function postQuiz() {
	fetch('http://localhost:8080/Quiz/newdomanda', {
		method: 'POST',
		body: JSON.stringify(newQuestion),
		headers: {
		  "Content-type": "application/json; charset=UTF-8"
		}
	  })
	  //.then(response => response.json())
	  //.then(json => console.log(json))
	  .then(console.log(newQuestion))
}



//console.log('??');
//document.getElementById("messaggio").innerHTML = "<b>INSERISCI USERNAME E PASSWORD</b>";

/*function getUserData() {
	let userId = document.getElementById("userid").value;

	fetch('https://jsonplaceholder.typicode.com/users/'+userId)
	  .then(response => response.json())
	  .then(jj => {
		console.log(jj);
		document.getElementById("nome").innerHTML = jj.name;
	  })
	  .catch(error => console.log('!!'));
	  
	fetch('https://jsonplaceholder.typicode.com/posts?userId='+userId)
	  .then(response => response.json())
	  .then(json => {
		console.log(json);
		document.getElementById("numPost").innerHTML = json.length;
		let i;
		for(i = 0; i < json.length; i++) {
			console.log(i);
			document.getElementById("posts").innerHTML += "<div style='padding: 10px; border: 1px solid red'><b>" + json[i].title + "</b><br>" + json[i].body + "</div>"
		}
	  })
	  .catch(error => console.log('Errore'));

}*/
</script>

</body>
</html>
