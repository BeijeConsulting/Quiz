<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Quiz Application</title>
	
	<link rel="stylesheet" href="<c:url value="/assets/css/newexam.css" />"/>
	<script src="<c:url value="/assets/js/newexam.js" />"></script>
	
</head>
<body>
	
	<div id="main-div">

            <div id="create-box">
    
                <h1>Create quiz</h1>
    
                <form method="POST" action="./load_quiz">
                
   					<h4>Choose books:</h4>
					<br>
					<input class="button" type="button" onclick="viewCapitoliOCA()" value="OCA MANUAL" id="OCA-button">
					<input type="hidden" name="idBook" id="OCA" value="1">
			
					<input class="button" type="button" onclick="viewCapitoliMANNING()" value="MANNING" id="MAN-button">
					<input type="hidden" name="MAN" id="MAN" value="2">
			
					<h4>Choose chapters:</h4>
		
					<p id="OCA-view" ></p>
		 			<br>
		 			<p id="MAN-view" ></p>
					<br>
			
					<h4>Test name:</h4><br>
					<input class="input-box" type="text" name="nomeQuiz" id="nomeQuiz" required><br>
					<h4>Choose how many questions you wanna do:</h4><br>
					<input class="input-box" type="text" name="numberQuestions" id="numberQuestions" required><br>
                    <input class="submit-button" type="submit" value="START" />
    
                </form>
    
                <a class="link" href="./login">Back</a>
    
            </div>
    
        </div>
	

 </body>
 
</html>