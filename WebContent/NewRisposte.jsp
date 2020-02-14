<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="liveForm" class="it.beije.quiz.model.LiveForm" scope="session"></jsp:useBean>
<jsp:setProperty property="numeroRisposte" name="liveForm" param="numeroRisposte"/>	


numero: <jsp:getProperty property="numeroRisposte" name="liveForm"/>	

</body>
</html>