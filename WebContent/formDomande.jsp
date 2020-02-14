<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{



}

h1 {

  color:red;
  text-align:center;
  
  }
  
  
label { 
text-align:right; 
padding-top:2px;  
margin-right:2px;



}

textarea {  

 
overflow: auto;
border-style: double;


}
#testo{
width: 100%;
}

div{
text-align:center;
}


</style>
</head>
<body>
<title>DOMANDE</title>
<h1> Seleziona domanda:</h1>



<tr> Seleziona il libro: <textarea id="testo" rows="1" placeholder="es.OCA Oracle Certified Associate Java SE 8 [2014]"></textarea>

<br><br><br>

Capitolo: <input type="text" name="capitolo" placeholder="es.1,3,ecc.">

&nbsp;&nbsp;
</tr>
Domanda: <input type="text" name="domanda" placeholder="es.1">
<br><br>

<p>Testo della domanda:</p>
<textarea id="testo" cols="10" rows="10" ></textarea>
<br> <br>

<p>Risposta:</p>
<textarea id="testo" rows="1" placeholder="A-B-C-A,B.."></textarea>
<p>Risposte corrette:</p>
<textarea id="testo" rows="1" placeholder="A-BC.."></textarea>
<br><br>
<p align="center">Spiegazione risposta:</p>

<div>
<textarea id="testo" align="center" rows="20"></textarea>
</div>

</table>

</body>
</html>