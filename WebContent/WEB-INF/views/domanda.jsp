<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>QUIZ</title>
</head>
<body>

<div id ="timer" style="width: 98%; text-align:right;"></div>

<script type="text/javascript">
var ore = ${ ore };
var minuti = ${ minuti };
var secondi = ${ secondi };

function formattaTimer(hours,minutes,seconds) {
	var t = "0" + hours;
	t = t + ":" + ( minutes < 10 ? "0" : "") + minutes;
	t = t + ":" + ( seconds < 10 ? "0" : "") + seconds;
	return t;
}

function myTimer() {
	document.getElementById("timer").innerHTML = formattaTimer(ore, minuti, secondi--);
  if (secondi < 0) {
	  if(minuti > 0) {
		  secondi = 59;
		  minuti--;
	  }else if (ore > 0) {
		  secondi = 59;
		  minuti = 59;
		  ore--;
	  } else {
    		clearInterval(timer);
    		document.getElementById("timer").innerHTML = 'TEMPO SCADUTO';
    		//location.href = "/quiz/risposta";
	  }
  }
  
}

myTimer();

var timer = setInterval(myTimer, 1000);

</script>
<div class="ml-4">
<h3>DOMANDA ${ index + 1 } di ${ totDomande }</h3>

<div class="m-4">${testoDomanda}</div>

<form action = "/quiz/domanda" method = "post">
	<div>
  <input type="hidden" name="index" value="${ index }">
  <c:forEach var="scelte" items="${ risposte }">
    <input type = "${ answerType }" name='rspt_${ answerType eq "radio" ? "radio" : scelte.value }' value = "${ scelte.value }"
    ${ rispUtente.contains(scelte.value) ? "checked" : "" } > ${ scelte.text } <br>
  </c:forEach>
  <br><button class="btn btn-primary" type="submit" value="Invio">Invio</button>
  </div>
</form>
<br>
<br>

<c:if test="${index > 0 }"><a href="/quiz/domanda/${ index - 1 }">&lt;&lt;Prec.</a></c:if>
&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${index < tot-1 }"><a href="/quiz/domanda/${ index + 1 }">Succ.&gt;&gt;</a></c:if>

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>