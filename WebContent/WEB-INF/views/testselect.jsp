<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scelta Domande</title>
<link rel="stylesheet" href="<c:url value="/resources/static/attivita.css" />">

</head>
<body>
<div align="center"><h1>Select test</h1></div>
<div align="right"><h3><a href ="home">Home page</a></h3></div>
<div class="main">
<form action="gen_test" method="POST">
            <label for="book">Guide Manning o Manual?</label>
            <select id="book" name="book" onchange="updateForm(this)">
                <option disabled selected>Select</option>
                <option value="guide">Guide Manning</option>
                <option value="manual">Manual</option>
            </select><br><br>
		<div id="guide" style="display: none">
 		<label for="chapter">Set Domande</label>
            <select id="chapter" name="chapter">
                <option disabled selected>Select</option>
                <c:forEach var="i" items="1,2,3,4,5,6,7">
                    <option value="cap${i}">domande capitolo ${i}</option>
                </c:forEach>
            </select>
        </div>
		<div id="manual" style="display: none">
 		<label for="chapter">Set Domande </label>
            <select id="chapter" name="chapter">
                <option disabled selected>Select</option>
                <c:forEach var="i" items="1,2,3,4,5,6">
                    <option value="cap${i}">domande capitolo ${i}</option>
                </c:forEach>
                	<option value="Assessment_Test">Assesment Test</option>
            </select>
        </div> 
        <br>
        <input type="radio" value="random" name="random" id="randomq"/>
        <label for="randomq">Random</label><br>
        <input type="radio" value="normal" name="random" id="normalq" checked/>
        <label for="normalq">Normal</label><br>
         Test name: <input type="text" value="" name="name"/><br><br>
         <button type="submit" disable ><span>Confirm</span></button>       
</form>
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
</div>
</body>
</html>