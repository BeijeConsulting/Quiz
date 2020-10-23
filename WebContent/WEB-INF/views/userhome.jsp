<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Application</title>

<link rel="stylesheet" href="<c:url value="/assets/css/userhome.css" />"/>
<script src="<c:url value="/assets/js/userhome.js" />"></script>
</head>
<body>

	<div id="main-div">
	
        	<div id="home-box">
        
        	<h1>Homepage</h1>

        	<h4>Welcome ${name} ${surname}</h4>
        	
        	<hr>

        	<a href="./newexam" >CREATE NEW QUIZ</a><br/>

			<br>

            <h4>History</h4>

            <table>
                <thead>
                    <tr>
                        <th>Test name</th>
                        <th>Start</th>
                        <th>Finish</th>
                        <th>Questions number</th>
                        <th>Score</th>
                    </tr>
                </thead>
                
                <tbody id="myTable">
                
				</tbody>
				
            </table>

        </div>

    </div>

</body>
<script>
 
	
</script>
</html>