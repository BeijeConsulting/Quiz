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
<%-- Timer per il quiz, gestito dallo script JS --%>
<div id ="timer" style="width: 98%; text-align:right;"></div>

DOMANDA ${index + 1} di ${totDomande}<br>
<br>
${testoDomanda}
<%-- Aggiunta ${pageContext.request.contextPath} per far funzionare correttamente i link     --%>
<form action = "${pageContext.request.contextPath}/domanda" method = "post">
  <input type="hidden" name="index" value="${index}">
  <c:forEach var="scelte" items="${risposte}">
    <input type="${answerType}"
           name='rspt_${answerType eq "radio" ? "radio" : scelte.value}'
           value = "${scelte.value}"
           id = "${scelte.value}"
           ${rispUtente.contains(scelte.value) ? "checked" : ""}>
      <%-- Aggiunta label così posso cliccare sul testo della risposta per selezionarla --%>
      <label for="${scelte.value}">${scelte.text}</label>
      <br>
  </c:forEach>
  <br><input type="submit" value="Invio">
</form>
<br>
<br>

<a href="${pageContext.request.contextPath}/risultati">Risultati</a>

<c:if test="${index > 0 }"><a href="${pageContext.request.contextPath}/domanda/${ index - 1 }">&lt;&lt;Prec.</a></c:if>
&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${index < tot-1 }"><a href="${pageContext.request.contextPath}/domanda/${ index + 1 }">Succ.&gt;&gt;</a></c:if>
</body>

<script type="text/javascript">
    // Script per la gestione del timer
    let ore = ${ ore };
    let minuti = ${ minuti };
    let secondi = ${ secondi };

    function formattaTimer(hours,minutes,seconds) {
        let t = "0" + hours;
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
            }
        }
    }
    myTimer();
    let timer = setInterval(myTimer, 1000);
</script>
</html>