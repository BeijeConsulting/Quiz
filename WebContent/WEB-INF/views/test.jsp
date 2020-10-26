<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Start your OnLine Quiz</title>
    <script>
        function switcher() {
            let x = document.getElementById('button-start');
            let y = document.getElementById('domanda-wrapper');
            x.style.display = 'none';
            y.style.display = 'block';
        }

        function start() {
            fetch('./exam/question', {
                method:'post'
            }).then(response=>response.json()).then(function(json){
                document.getElementById('domanda-testo').innerHTML = json.testo;
                document.getElementById('domanda-testo').innerHTML = json.risposte;
                switcher();
            })
        }

        function change() {
            fetch('./exam/question', {
                method:'post'
            }).then(response=>response.json()).then(function(json){
                document.getElementById('domanda-testo').innerHTML = json.testo;
                document.getElementById('domanda-testo').innerHTML = json.risposte;
            })
        }
    </script>
    <style>

        #button-start {
            display: block;
            margin: auto;
        }
        #domanda-wrapper{
            width: 70%;
            margin: auto;
            display: none;
        }
        #domanda-testo {
            height: 5em;
            background-color:blueviolet;
        }
        #domanda-risposte {
            height: 10em;
            background-color: aqua;
        }
        
        #domanda-footer {
            display: flex;
            height: 2em;
        }

        #button-prev {
        }

        #button-next {
            margin-left: auto;
        }
    </style>
</head>
<body>

<h2>Quiz Scelto:</h2>

<br>
<br>
Totale domande caricate : ${ totDomande }
<br>
Tempo disponibile : ${ totDomande * 2 } minuti
<br>
<br>
<%-- Domande quiz --%>
	<div id="domanda-wrapper">
        <div id="domanda-testo">
        </div>
        <div id="domanda-risposte">
            <div id="risposte-radio">
                
            </div>
            <div id="risposte-check">
            </div>
        </div>
        <div id="domanda-footer">
            <button id="button-prev">Prev</button>
            <button id="button-next">Next</button>
        </div>
    </div>
    <button id="button-start" onclick="switcher()"> START QUIZ </button>
</body>
</html>