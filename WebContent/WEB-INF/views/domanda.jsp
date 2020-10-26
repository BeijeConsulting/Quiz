<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>QUIZ</title>
</head>
 <link rel="stylesheet" href="<c:url value="/resources/static/attivita2.css" />">
<body>
<br>
<div id ="timer" style="width: 80%;  text-align:right;"></div>

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
<div class="main">
QUESTION ${ index + 1 } of ${ questionSize }<br>
<br>
${questionText}

<form action = "/quiz/question" method = "post">
  <input type="hidden" name="index" value="${ index }">
  <c:forEach var="answer" items="${ singleanswers }">
  <%-- Ho aggiunto la lettera della risposta che prima non c'era --%>
    <input type = "${ answerType }" name='rspt_${ answerType eq "radio" ? "radio" : answer.getFirst() }' value = "${ answer.getFirst() }"
    ${ userAnswer.contains(answer.getFirst()) ? "checked" : "" } > ${answer.getFirst()}. ${answer.getLast()} <br>
  </c:forEach><br>
 <c:if test="${index > 0 }"><button type="submit" name="prec" value="true">&lt;&lt;Back.</button></c:if>
  &nbsp;&nbsp;&nbsp;&nbsp;
  <c:if test="${index < questionSize -1 }"><button type="submit">Next.&gt;&gt;</button></c:if>
  <c:if test="${index == questionSize -1 }"><button type="submit">SUBMIT</button></c:if>
</form>

<br>
<br>
</div>
</body>
</html>