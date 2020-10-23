<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Application</title>

<link rel="stylesheet" href="<c:url value="/assets/css/result.css" />"/>
</head>
<body>

	<div id="main-div">
	
		<div id="result-box">
    
    		<h1>Result</h1>

            <h4>Test name</h4>
            <p>--</p>
            <h4>Time</h4>
            <p>--</p>
            <h4>Correct questions</h4>
            <p>--</p>
            <h4>Number of questions</h4>
            <p>--</p>
            
            <a class="link" href="./login">OK</a>
    
            </div>
    
        </div>
</body>
</html>