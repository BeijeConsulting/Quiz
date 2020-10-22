<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inizia il tuo Quiz Online</title>
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

<script>
    let domandeSelected = document.getElementById('totDomande');
    let timerP = document.getElementById('timerP');
    let timerSpan = document.getElementById('timer');
    let submitButton = document.getElementById('submit').disabled;

    function clean(){
        domandeSelected.value = 0;
        domandeSelected.max = 0;
        timerP.style.display = "none";
        submitButton.disabled = true;
    }

    function getTime(numberOfQuestions){
        return numberOfQuestions * 60 * 2
    }

    function updateTime(){
        let seconds = getTime(domandeSelected.value);
        if (seconds > 0){
            timerP.style.display = "";
        } else {
            timerP.style.display = "none";
        }
        timerSpan.innerText = seconds.toHHMMSS();
    }

    Number.prototype.toHHMMSS = function () {
        let sec = this;
        let hours   = Math.floor(sec / 3600);
        let minutes = Math.floor((sec - (hours * 3600)) / 60);
        let  seconds = sec - (hours * 3600) - (minutes * 60);

        if (hours   < 10) {hours   = "0"+hours;}
        if (minutes < 10) {minutes = "0"+minutes;}
        if (seconds < 10) {seconds = "0"+seconds;}
        return hours+':'+minutes+':'+seconds;
    }

    function updateQuestions(){
        let selected = document.querySelectorAll('input[type="checkbox"]:checked');
        if (selected.length === 0){
            clean();
        } else {
            let books = [], chapters = [];

            for (let select of selected){
                select = String(select.value).split("-");
                books.push(select[0]);
                chapters.push(select[1]);
            }
            books = books.join()
            chapters = chapters.join()

            let totDomande;

            fetch("/Quiz/rest/countQuestions/" + books + "/" + chapters + "")
                .then(r => r.json())
                .then(j => totDomande = j)
                .then(() => {
                    domandeSelected.value = totDomande;
                    domandeSelected.max = totDomande;
                    updateTime(getTime(totDomande));
                });
            submitButton.disabled = false
        }
    }
</script>
</body>

</html>