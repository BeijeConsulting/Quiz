<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scelta Domande</title>
</head>
<body>
<form action="gen_test" method="POST">
            <label for="book">Guide Manning o Manual?</label>
            <select id="book" name="book" onchange="updateForm(this)">
                <option disabled selected>Seleziona</option>
                <option value="guide">Guide Manning</option>
                <option value="manual">Manual</option>
            </select>
		<div id="guide" style="display: none">
 		<label for="chapter">Set Domande</label>
            <select id="chapter" name="chapter">
                <option disabled selected>Seleziona</option>
                <c:forEach var="i" items="1,2,3,4,5,6,7">
                    <option value="cap${i}">domande capitolo ${i}</option>
                </c:forEach>
            </select>
        </div>
		<div id="manual" style="display: none">
 		<label for="chapter">Set Domande</label>
            <select id="chapter" name="chapter">
                <option disabled selected>Seleziona</option>
                <c:forEach var="i" items="1,2,3,4,5,6">
                    <option value="cap${i}">domande capitolo ${i}</option>
                </c:forEach>
                	<option value="Assessment_Test">Assesment Test</option>
            </select>
        </div> 
         NOME TEST<input type="text" value="" name="name"/>
         <input type="submit" value="Confirm">       
</form>
<h3><a href ="./log">Home</a></h3>
<script>
function updateForm(selector){
    let value = selector.value;
    let divManual = document.getElementById('manual');
    let divGuide = document.getElementById('guide');
    if (value === 'guide'){
    	divGuide.style.display = '';
    	divManual.style.display = 'none';
    } else {
    	divManual.style.display = '';
    	divGuide.style.display = 'none';
    }
}
</script>
</body>
</html>