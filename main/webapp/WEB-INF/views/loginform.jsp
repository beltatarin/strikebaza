<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true" errorPage="exception/defaultException.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="stylesheet" href="<c:url value="/webres/css/bootstrap.min.css"/>">
<title><spring:message code="loginForm.title"/></title>
<style>
body{
background-image: url("<c:url value="/webres/img/strike6.jpg"/>");
background-repeat: no-repeat;
background-size: cover;
background-position: top center !important;

background-attachment: fixed;
color: black;
height: 100vh;
}
.container{
	background-color: rgb(255,255,255,0.5);
	
}
.form-signin {
            width: 100%;
            max-width: 400px;
            padding: 15px;
            margin: 0 auto;
        }
</style>
</head>
<body>
<div class="container" style="margin-top: 50px; width:350px; padding-bottom:50px;">
 
        <div class="text-center mb-4">
            
            <h1 class="h1 mb-3 font-weight-normal">
                <font style="vertical-align: inherit;">
                    <font style="vertical-align: inherit;">
                    <spring:message code="loginForm.title" />
			</font>
                </font>
            </h1>
        </div>
<form:form class="form-signin" action="loginform.html" modelAttribute="loginform">
        <div class="form-label-group">
         <label for="inputLogin">
                <font style="vertical-align: inherit;">
                    <font style="vertical-align: inherit;"><spring:message code="loginForm.login" /></font>
                </font>
            </label><form:errors path="login" />
            <form:input type="text" id="inputLogin" class="form-control" path="login" placeholder="Login" required="" autofocus=""/>
           
        </div>
 		<%-- <div class="form-label-group">
         <label for="inputPhone">
                <font style="vertical-align: inherit;">
                    <font style="vertical-align: inherit;"><spring:message code="loginForm.phone" /></font>
                </font>
            </label><form:errors path="phone" />
            <form:input type="text" id="inputPhone" class="form-control" path="phone" placeholder="phone"  title="Только цифры формат 375295555555" required="" autofocus=""/>
           
        </div> --%>
        <div class="form-label-group">
        <label for="inputPassword">
                <font style="vertical-align: inherit;">
                    <font style="vertical-align: inherit;"><spring:message code="loginForm.password" /></font>
                </font>
            </label><form:errors path="password"/>
            <form:input type="password" path="password" id="inputPassword" class="form-control" placeholder="Password" required=""/>
            
        </div>
<br>
       
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="input" value="input">
           
                <font style="vertical-align: inherit;"><spring:message code="loginForm.input" /></font>
          
        </button>
         
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="input"	value="back">
							
                <font style="vertical-align: inherit;"><spring:message code="loginForm.back" /></font>
         
		</button>
		<button class="btn btn-lg btn-primary btn-block" type="submit" name="input" value="mail">
								<spring:message code="loginForm.mail" />
		</button> 
        <p class="mt-5 mb-3 text-muted text-center">
            <font style="vertical-align: inherit;">
                <font style="vertical-align: inherit;">© 2019</font>
            </font>
        </p>
   </form:form>
   <c:if test="${param.input == 'mail'}">
<form class="form-signin" action="emailForm">
		<div class="form-label-group">
		
		
		<div class="form-label-group">
        <label for="loginEmail">
                <font style="vertical-align: inherit;">
                    <font style="vertical-align: inherit;"><spring:message code="loginForm.login" /></font>
                </font>
            </label>
            <input type="text" name="login" id="loginEmail" class="form-control" placeholder="login" required>
            
        </div>
        <div class="form-label-group">
        <label for="emailEmail">
                <font style="vertical-align: inherit;">
                    <font style="vertical-align: inherit;"><spring:message code="loginForm.email" /></font>
                </font>
            </label>
            <input type="email" name="email" id="emailEmail" class="form-control" placeholder="email" required>
            
        </div>
        <div class="form-label-group">
       
            <input type="text" name="text" id="textlEmail" class="form-control" style="height: 100px;" placeholder="text" required>
            
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" name="input"	value="input">
							<font style="vertical-align: inherit;">
                <font style="vertical-align: inherit;"><spring:message code="loginForm.send" /></font>
            </font>
		</button>
				
		
		</div>
	</form>	
	</c:if>
	</div>
</body>
</html>