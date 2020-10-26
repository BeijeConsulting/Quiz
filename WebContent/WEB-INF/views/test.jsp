<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Start your OnLine Quiz</title>
    <script>
    var index;
        function switcher() {
            let x = document.getElementById('button-start');
            let y = document.getElementById('domanda-wrapper');
            x.style.display = 'none';
            y.style.display = 'block';
        }
        
        function writeOptions(options, type) {
        	let ret = '';
        	for (const op in options) {
        		  ret = ret.concat('<input type="'+type+'" id="'+op+'" class="check" >'+options[op]+' </input><br>')
        		}
        	return ret;
        }

        function start() {
            fetch('./exam/question', {
                method:'post'
            }).then(response=>response.json()).then(function(json){
            	
                document.getElementById('domanda-testo').innerHTML = json.raw_text;
                document.getElementById('domanda-risposte').innerHTML = writeOptions(JSON.parse(json.options), json.answer_type);
                index = json.question_id;
                
                switcher();
            })
        }

        function getSelected() {
        	console.log('enter get selected func')
        	console.log(document.getElementById('domanda-risposte'))
        	console.log(document.getElementById('domanda-risposte').getElementsByClassName("check"));
    		let risp = document.getElementById('domanda-risposte').getElementsByClassName("check");
 
        }
    		
	      function change() {
            fetch('./exam/question/'+(index++), {
                method:'post',
               	body: JSON.stringify({user_chioce:'ABC'})
            }).then(response=>response.json()).then(function(json){
            	document.getElementById('domanda-testo').innerHTML = json.raw_text;
                document.getElementById('domanda-risposte').innerHTML = writeOptions(JSON.parse(json.options), json.answer_type);
                index = json.question_id;
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
            
        </div>
        <div id="domanda-footer">
            <button id="button-prev">Prev</button>
            <button id="button-next" onclick="change()">Next</button>
        </div>
    </div>
    <button id="button-start" onclick="start()"> START QUIZ </button>
</body>
</html>