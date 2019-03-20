<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    		//document.getElementById("timer").innerHTML = 'TEMPO SCADUTO';
    		location.href = "/quiz/risposta";
	  }
  }
  
}

myTimer();

var timer = setInterval(myTimer, 1000);

</script>

DOMANDA ${ index + 1 } di ${ totDomande }<br>
<br>
${testoDomanda }

<form action = "risposta" method = "post">
  <input type="hidden" name="index" value="${ index }">
  <c:forEach var="scelte" items="${ risposte }">
  <input type = "${ answerType}"  name="${ scelte.value }" value = "${ scelte.value }" 
  <c:if test="${ rispUtente.contains(scelte.value)} ">checked</c:if > > ${ scelte.text } <br>
  </c:forEach>
  <br><input type="submit" value="Invio">
</form>
<br>
<br>

<c:if test="${index > 0 }"><a href="${ index - 1 }">&lt;&lt;Prec.</a></c:if>
&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${index != tot }"><a href="${ index + 1 }">Succ.&gt;&gt;</a></c:if>
</body>
</html>