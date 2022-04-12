<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java" errorPage="/exception/defaultException.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="stylesheet"
	href="<c:url value="/webres/css/bootstrap.min.css"/>">
<title><spring:message code="exception.title"/></title>
</head>
<body>
<div class="container">
	<h1>
		<spring:message code="exception.message" />
	</h1>
	<form:form action="loginsuccess.html">
		<button class="btn btn-primary" type="submit" name="input" value="back">
			<spring:message code="loginsuccess.exit" />
		</button>
	</form:form>
	</div>
</body>
</html>
