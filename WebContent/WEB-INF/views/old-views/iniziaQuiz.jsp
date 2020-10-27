<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Crea un nuovo Quiz</title>

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/media/favicon.ico" />

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/quizCreator.css" />

</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <h3>Crea Un Nuovo Quiz</h3>
    </div>
    <div class="row justify-content-center">
        <form method="post" action="./startQuiz">
            <div class="form-group">
                <label for="nomeQuiz">Nome Quiz</label>
                <input type="text" class="form-control" name="nomeQuiz" id="nomeQuiz" aria-describedby="emailHelp">
                <small id="emailHelp" class="form-text text-muted">Opzionale</small>
            </div>
            <div class="row justify-content-center">
                <div class="col-4">
                    <h5>OCA MANUAL</h5>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="2-1" name="questions"
                               class="custom-control-input" id="ocacap1" onClick = updateQuestions()>
                        <label class="custom-control-label" for="ocacap1"> Capitolo 1</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="2-2" name="questions"
                               class="custom-control-input" id="ocacap2" onClick = updateQuestions()>
                        <label class="custom-control-label" for="ocacap2"> Capitolo 2</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="2-3" name="questions"
                               class="custom-control-input" id="ocacap3" onClick = updateQuestions()>
                        <label class="custom-control-label" for="ocacap3"> Capitolo 3</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="2-4" name="questions"
                               class="custom-control-input" id="ocacap4" onClick = updateQuestions()>
                        <label class="custom-control-label" for="ocacap4"> Capitolo 4</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="2-5" name="questions"
                               class="custom-control-input" id="ocacap5" onClick = updateQuestions()>
                        <label class="custom-control-label" for="ocacap5"> Capitolo 5</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="2-6" name="questions"
                               class="custom-control-input" id="ocacap6" onClick = updateQuestions()>
                        <label class="custom-control-label" for="ocacap6"> Capitolo 6</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="2-0" name="questions"
                               class="custom-control-input" id="assess" onClick = updateQuestions()>
                        <label class="custom-control-label" for="assess"> Assessment Test</label>
                    </div>
                </div>

                <div class="col-4">
                    <h5>MANNING</h5>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="1-1" name="questions"
                               class="custom-control-input" id="man1" onClick = updateQuestions()>
                        <label class="custom-control-label" for="man1"> Capitolo 1</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="1-2" name="questions"
                               class="custom-control-input" id="man2" onClick = updateQuestions()>
                        <label class="custom-control-label" for="man2"> Capitolo 2</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="1-3" name="questions"
                               class="custom-control-input" id="man3" onClick = updateQuestions()>
                        <label class="custom-control-label" for="man3"> Capitolo 3</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="1-4" name="questions"
                               class="custom-control-input" id="man4" onClick = updateQuestions()>
                        <label class="custom-control-label" for="man4"> Capitolo 4</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="1-5" name="questions"
                               class="custom-control-input" id="man5" onClick = updateQuestions()>
                        <label class="custom-control-label" for="man5"> Capitolo 5</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="1-6" name="questions"
                               class="custom-control-input" id="man6" onClick = updateQuestions()>
                        <label class="custom-control-label" for="man6"> Capitolo 6</label>
                    </div>
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="1-0" name="questions"
                               class="custom-control-input" id="man7" onClick = updateQuestions()>
                        <label class="custom-control-label" for="man7">Capitolo 7</label>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <p style="display: none" id="timerP">Tempo disponibile: <span id="timer"></span></p>
            </div>
            <div class="row justify-content-center">
                <div class="form-group">
                    <label for="totDomande">Domande Selezionate</label>
                    <input type="number" class="form-control" name="totDomande" id="totDomande"
                           placeholder="Domande selezionate" max="" min="0" onchange="updateTime()">
                </div>
            </div>
            <div class="row justify-content-center">
                    <div class="custom-control custom-checkbox">
                        <input type="checkbox" value="true" name="shuffle"
                               class="custom-control-input" id="shuffle">
                        <label class="custom-control-label" for="shuffle">Domande in ordine casuale?</label>
                </div>
            </div>
            <div class="row justify-content-center">
                <button type="submit" id="submitButton" disabled class="btn btn-success">INIZIA</button>
            </div>
        </form>
    </div>
</div>
<script src="<c:url value="/resources/js/quizCreatorAjax.js"/>"></script>
</body>
</html>