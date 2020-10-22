<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
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

DOMANDA ${ index + 1 } di ${ totDomande }<br>
<br>
${questionText}

<form action = "/quiz/domanda" method = "post">
  <input type="hidden" name="index" value="${ index }">
  <c:forEach var="answers" items="${ possibleAnswers }">
  <%-- Ho aggiunto la lettera della risposta che prima non c'era --%>
    <input type = "${ answerType }" name='rspt_${ answerType eq "radio" ? "radio" : answers.value }' value = "${ answers.value }"
    ${ userAnswer.contains(answers.value) ? "checked" : "" } > ${answers.value} ) ${ answers.text } <br>
  </c:forEach>
  <br><input type="submit" value="Invio">
</form>
<br>
<br>

<c:if test="${index > 0 }"><a href="/quiz/domanda/${ index - 1 }">&lt;&lt;Prec.</a></c:if>
&nbsp;&nbsp;&nbsp;&nbsp;
<%--era da modificare tot in totDomande per visualizzare il link, svista negli attributi del model --%>
<c:if test="${index < totDomande-1 }"><a href="/quiz/domanda/${ index + 1 }">Succ.&gt;&gt;</a></c:if>
</body>
</html>