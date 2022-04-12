<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<spring:url value="/webres/css/bootstrap.min.css" var="bootstrapurl"/>
<link rel="stylesheet" href="${bootstrapurl}">
<spring:url value="/webres/css/indexForm.css" var="cssurl"/>
<link rel="stylesheet" href="${cssurl}">
<spring:url value="/webres/img/strike3.png" var="png"/>

<title><spring:message code="loginForm.title"/></title>
<style>
body{
background-image: url("${png}");
color: white;
}
</style>
</head>
<body>

<div class="container" style="display:flex">
<div class="container-fluid">
	<p>
		<spring:message code="loginForm.lang" />
	</p>
	<!-- кнопки смены языка - элементы ajax -->
	<button class="btn btn-primary"
		onClick="javascript:window.location = '?lang=en'">english</button>
	<button class="btn btn-primary"
		onClick="javascript:window.location = '?lang=ru'">русский</button>
</div>
		<div class="container-fluid"  id="slide_show">
			<h1><spring:message code="loginForm.h1" />
			</h1>
		</div>
		<div class="container-fluid">
			<h4>
				<spring:message code="loginForm.name" />
			</h4>
			<form:form action="indexForm.html">
			<table>
				<tr>
					<td>
						<button class="btn btn-success" type="submit" name="input"
							value="reg">
							<spring:message code="loginForm.reg" />
						</button>
					</td>
					<td>
						<button class="btn btn-success" type="submit" name="input"
							value="login">
							<spring:message code="loginForm.input" />
						</button>
					</td>				
			</table>
		</form:form>
			
		</div>
	</div>
	
</body>
</html>