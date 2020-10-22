<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inizia il tuo Quiz Online</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>
Questa è la pagina di ingresso al tuo Quiz Online

<%-- SEZIONE SELEZIONE DOMANDE --%>

<form method="post" action="./startQuiz" >
    <label for="nomeQuiz">Nome quiz:</label>
    <input type="text" name="nomeQuiz" id="nomeQuiz" required>
    <h3>Seleziona le sezioni che desideri fare:</h3>
    <b>OCA MANUAL</b>
    <br>
    <label> Capitolo 1
        <input type="checkbox" value="2-1" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 2
        <input type="checkbox" value="2-2" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 3
        <input type="checkbox" value="2-3" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 4
        <input type="checkbox" value="2-4" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 5
        <input type="checkbox" value="2-5" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 6
        <input type="checkbox" value="2-6" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Assessment Test
        <input type="checkbox" value="2-0" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <b>MANNING</b>
    <br>
    <label> Capitolo 1
        <input type="checkbox" value="1-1" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 2
        <input type="checkbox" value="1-2" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 3
        <input type="checkbox" value="1-3" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 4
        <input type="checkbox" value="1-4" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 5
        <input type="checkbox" value="1-5" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 6
        <input type="checkbox" value="1-6" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <label> Capitolo 7
        <input type="checkbox" value="1-7" name="questions" onClick = updateQuestions()>
    </label>
    <br>
    <br>
    <input type="number" placeholder="Domande selezionate" name="totDomande" id="totDomande" max="" min="0" onchange="updateTime()">
    <br>
    <br>
    <p style="display: none" id="timerP">Tempo disponibile: <span id="timer"></span></p>
    <br>
    <br>
    <label> Domande in ordine casuale?
        <input type="checkbox" value="true" name="shuffle">
    </label>
    <br>
    <input type="submit" id="submit" value="INIZIA QUIZ">
</form>

<script src="${pageContext.request.contextPath}/resources/js/quizCreatorAjax.js"></script>
</body>
</html>