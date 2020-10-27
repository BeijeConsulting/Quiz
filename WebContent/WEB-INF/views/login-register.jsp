<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Quiz</title>

    <%-- BOOTSTRAP --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <%-- CSS --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/waves.css" />

    <%-- JS --%>
    <script src="${pageContext.request.contextPath}/resources/js/old/login-register.js"></script>

    <%-- FONTS --%>
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">

    <c:if test="${errore != null}">
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong>Credenziali Errate!</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <div class="row justify-content-around">
        <!-- TABS LOGIN-REGISTER -->
        <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item" role="presentation">
                <a class="nav-link active" href="#login" data-toggle="tab" aria-controls="login" aria-selected="true">Login</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" href="#register" data-toggle="tab" aria-controls="register" aria-selected="true">Registrati</a>
            </li>
        </ul>
    </div>
    <div class="tab-content" id="myTabContent">
        <!-- LOGIN FORM -->
        <div role="tabpanel" class="tab-pane fade show active" id="login">
            <form class="form-horizontal" method="post" action="./signIn">
                <div class="form-group " >
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                        </div>
                        <input id="login_email" type="email" name="login_email"
                               class="form-control" placeholder="Email" required="required" value="" onchange="validateEmail()">
                        <div class="invalid-feedback">
                            Email invalida.
                        </div>
                        <div class="valid-feedback">
                            Email trovata.
                        </div>
                    </div>
                </div>
                <div class="form-group ">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-key"></i></span>
                        </div>
                        <input id="login_password" type="password"
                               name="login_password" class="form-control" placeholder="Password"
                               required>
                    </div>
                </div>
                <div class="row justify-content-around">
                    <input type="submit" value="Login" class="btn btn-primary btn-custom">
                </div>
            </form>
        </div>

        <!-- REGISTER FORM -->
        <div role="tabpanel" class="tab-pane fade" id="register">
            <form class="form-horizontal" method="post" action="./signUp">
                <div class="form-group ">
                    <div class="form-row">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fa fa-user"></i></span>
                            </div>
                            <input type="text" name="name" class="form-control" placeholder="Nome" required="required" value="">
                            <input type="text" name="surname" class="form-control" placeholder="Cognome" required="required" value="">
                        </div>
                    </div>
                </div>
                <div class="form-group ">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-envelope"></i></span>
                        </div>
                        <input type="email" name="email" class="form-control" placeholder="Email" required="required" value="">
                    </div>
                </div>
                <div class="form-group ">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-lock"></i></span>
                        </div>
                        <input type="password" name="password" class="form-control" placeholder="Password" required="required">
                    </div>
                </div>
                <div class="form-group ">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-lock"></i></span>
                        </div>
                        <input type="password" name="cpassword" class="form-control" placeholder="Conferma Password" required="required">
                    </div>
                </div>
                <div class="row justify-content-around">
                    <input type="submit" value="Registrati" class="btn btn-primary btn-custom">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- SVG WAVES TO ADD SOMETHING NICE -->
<div class="ocean">
    <div class="wave"></div>
    <div class="wave"></div>
</div>
</body>
</html>