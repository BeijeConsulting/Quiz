<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Start your OnLine Quiz</title>
</head>
<body>
	
	This is the entry page to your Online Quiz<br>
	<br>
	
 	<form method="post" action="./load_quiz">
 	
	 	<h3>Seleziona i libri che desideri fare:</h3>
			<br>
			<button onclick="viewCapitoliOCA()">OCA MANUAL</button>
			<input type="hidden" name="idBook" id="OCA" value="1">
			
			<button onclick="viewCapitoliMANNING()">MANNING</button>	
			<input type="hidden" name="MAN" id="MAN" value="2">
			
		<h3>Seleziona i capitoli che desideri fare:</h3>
		
			<p id="OCA" ></p>
		 	<br>
		 	<p id="MAN" ></p>
			<br>
			
		<label for="nomeQuiz">Nome quiz:</label>
			<input type="text" name="nomeQuiz" id="nomeQuiz" required>
			
		<label for="numberQuestions">Choose how many questions you wanna do:</label>
			<input type="text" name="numberQuestions" id="numberQuestions">	
			
		<input type="submit" value="PREPARA QUIZ">
	</form>
	

 </body>
 
 <script>
 
 function viewCapitoliOCA(){
	 for(var i = 1; i < 7; i++){
		 document.getElementById('OCA').innerHTML+="<label> Capitolo "+i+"<input type="+"checkbox"+" value=1-"+i+" name="+"questions"+"></label><br>" /* value="+"oca_manual\domande_cap"+i+".xml"+" name="+"questions"+"></label><br>"		 */ 
	 }
	 document.getElementById('OCA').innerHTML+="<label> Assessment Test <input type="+"checkbox"+" value=1-"+"Assessment_Test"+" name="+"questions"+"></label><br>" /* value="+"oca_manual\domande_Assessment_Test.xml"+" name="+"questions"+"></label><br>" */
 }
 
 function viewCapitoliMANNING(){
	 for(var i = 1; i < 7; i++){
		 document.getElementById('MAN').innerHTML+="<label> Capitolo "+i+"<input type="+"checkbox"+" value=2-"+i+" name="+"questions"+"></label><br>"		 
	 }
 } 
 
 
 </script>
 
</html>