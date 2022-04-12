<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java" errorPage="exception/defaultException.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="stylesheet"
	href="<c:url value="/webres/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/webres/css/loginAdmin.css"/>">
<script type="text/javascript"
	src="<c:url value="/webres/js/regform.js"/>"></script>
<title><spring:message code="regForm.title" /></title>
<style>
body{
background-image: url("<c:url value="/webres/img/strike8.jpg"/>");
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
</style>
</head>
<body>
<div class="mx-auto" style="width:150px">
			
			
		</div>
<div class="container" style="margin-top: 50px; width:300px; padding-bottom:50px;">
		<div class="mx-auto">
			<h1>
				<spring:message code="regForm.title" />
			</h1>
			
		</div>
		
<form:form action="regform.html" modelAttribute="regform" class="needs-validation" onsubmit="return validateForm();">
  <div class="form-row">
    <div class="col">
      <label for="userName"><spring:message code="regForm.login" /></label><div class="text-danger"><form:errors path="userName" /></div>
      <div id="userName_err" class="err"><spring:message code="Wrong.userName" /></div>
      <div id="userName_err1" class="err"><spring:message code="Duplicate.userName" /></div>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="validationTooltipUsernamePrepend"><img alt="" width="20" height="20" src="<c:url value="/webres/img/login.jpg"/>"></span>
        </div>
      <form:input path="userName"  class="form-control" id="userName" placeholder="Login" title="Логин должен содержать латинские буквы" pattern="\w+" required=""/>
    </div>
    </div>
   </div>
    <div class="form-row">
     <div class="col">
      <label for="pass"><spring:message code="regForm.password" /></label><form:errors path="password" />
      <div id="pass_err" class="err"><spring:message code="Wrong.password" /></div>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="validationTooltipUsernamePrepend"><img alt="" width="20" height="20" src="<c:url value="/webres/img/password.jpg"/>"></span>
        </div>
      <form:password path="password" class="form-control" name="pass" id="pass" placeholder="password" value="${fn:escapeXml(param.password)}" title="Пароль должен содержать латинские буквы, длина пароля не менее 6 символов, обязательно должны присутствовать: 1 буква в нижнем регистре, 1 буква в верхнем регистре и 1 цифра" required=""/>		
    </div>
     </div>
    </div>
   <div class="form-row">
    <div class="col">
      <label for="pass2"><spring:message code="regForm.confirmPassword" /></label><form:errors path="passwordSecond" />
      <div id="pass_err2" class="err"><spring:message code="Wrong.password" /></div>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="validationTooltipUsernamePrepend"><img alt="" width="20" height="20" src="<c:url value="/webres/img/password.jpg"/>"></span>
        </div>
      <form:password path="passwordSecond" class="form-control" name="passwordSecond" id="pass2" placeholder="password" value="${fn:escapeXml(param.passwordSecond)}" title="Пароли должны совпадать" required=""/>		
    </div>
     </div>
    </div>
  <div class="form-row">
    <div class="col">
      <label for="email"><spring:message code="regForm.email" /></label><div id="email_err" class="err"><spring:message code="Wrong.email" /></div>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="validationTooltipUsernamePrepend">@</span>
        </div>
        <form:input path="email" name="email" class="form-control" id="email" type="email"
							placeholder="Email"	title="Адрес должен содержать только латинские буквы, точку, дефис, нижнее подчеркивание. Обязательно присутствие символа @, домена  после него и минимум 3 символа до него" aria-describedby="validationTooltipUsernamePrepend" required=""/>
			    
      </div>
       </div>
    </div>
 <div class="form-row">
    <div class="col">
      <label for="tel"><spring:message code="regForm.telefon" /></label><form:errors path="telefon" />
      <div id="tel_err" class="err"><spring:message code="Wrong.tel" /></div>
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="validationTooltipUsernamePrepend"><img alt="" width="20" height="20" src="<c:url value="/webres/img/tel.jpg"/>"></span>
        </div>
      <form:input type="tel" path="telefon" class="form-control" name="phone" id="tel" placeholder="phone" title="Только цифры формат 375295555555" pattern="[0-9]{12}" required=""/>		
    </div>
     </div>
    </div>
    <div class="form-row">
    <div class="col">
      <label for="validationTooltip03"><spring:message code="regForm.role" /></label><form:errors path="role" />
     
      <form:select path="role" class="form-control" id="validationTooltip03">
								<form:option value="player">player</form:option>
								<form:option value="organizer">organizer</form:option>
							</form:select>
    </div>
   
   
  </div>
 <div class="form-row"  style="padding-top:20px; padding-bottom:0px; ">
 <div class="col">

  <button class="btn btn-primary" name="input" value="add">
	<spring:message code="regForm.save" /></button>
	</div>
	<div class="col">
<button class="btn btn-primary" type="submit" name="input" onclick="history.back()" value="back">
<spring:message code="regForm.back" />
</button>
</div>
</div>
</form:form>
</div>
</body>
</html>