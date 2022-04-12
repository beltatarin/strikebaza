<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java" errorPage="exception/defaultException.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<link rel="stylesheet"
	href="<c:url value="/webres/css/bootstrap.min.css"/>">
	<link rel="stylesheet"
	href="<c:url value="/webres/css/loginAdmin.css"/>">
<title><spring:message code="loginAdmin.title" /></title>
<style>
body{
background-image: url("<c:url value="/webres/img/strike2.jpg"/>");
background-repeat: no-repeat;
background-size: cover;
background-position: top center !important;
background-attachment: fixed;
color: white;
}
footer{
position: fixed; 
    bottom: 0; 
    width: 100%; 
    background-color: grey;
}
</style>
</head>
<body>

	<form:form action="loginAdmin.html" modelAttribute="updateForm">
		<div class="container">
		<div class="row">
			
			<div class="mx-auto">
						<h1><spring:message code="loginAdmin.strike" /></h1>
					</div>
					</div>
		
		
			<div class="row">
				<div class="col-xs-2">

					

					<table class="table table-dark table-bordered">
						<thead>
							<tr>
								<th scope="col"><spring:message
										code="loginAdmin.greeting" /></th>
								<th scope="col">${user.role}</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row"><spring:message code="loginAdmin.login" /></th>
								<td>${user.login}</td>
							</tr>
							<tr>
								<th scope="row"><spring:message code="loginAdmin.password" /></th>
								<td>${user.password}</td>
							</tr>
							<tr>
								<th scope="row"><spring:message code="loginAdmin.email" /></th>
								<td>${user.email}</td>
							</tr>
							
						</tbody>
					</table>
				</div>
				<div class="col">
					<table class="table">
						<thead>
							<tr>
								<th></th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td><button class="btn btn-success" type="submit"
										name="input" value="unlockUser">
										<spring:message code="loginAdmin.unlock" />
									</button></td>
									<td>
									<c:if test="${param.input == 'unlockUser'}">
						<table class="table">

							<tbody>
								<tr>
									<th scope="row"><form:select path="userName"
											style="width: 150px">
											<c:forEach var="user" items="${users}">
												<form:option value="${user.login}">${user.login} </form:option>
											</c:forEach>
										</form:select></th>
									<td>
										<button class="btn btn-primary" type="submit" name="input"
											value="unlock">
											<spring:message code="loginAdmin.unlock" />
										</button>
									</td>
								</tr>
							</tbody>
						</table>
					</c:if>
					</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-success" type="submit" name="input"
										value="lockUser">
										<spring:message code="loginAdmin.lock" />
									</button>
								</td>
								<td>
								<c:if test="${param.input == 'lockUser'}">
						<table class="table">

							<tbody>
								<tr>
									<th scope="row"><form:select path="userName"
											style="width: 150px">
											<c:forEach var="user" items="${users}">
												<form:option value="${user.login}">${user.login} </form:option>
											</c:forEach>
										</form:select></th>
									<td>
										<button class="btn btn-primary" type="submit" name="input"
											value="lock">
											<spring:message code="loginAdmin.lock" />
										</button>
									</td>
								</tr>
							</tbody>
						</table>
					</c:if>
					</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-success" type="submit" name="input"
										value="delUser">
										<spring:message code="loginAdmin.delUser" />
									</button>
								</td>
								<td>
								<c:if test="${param.input == 'delUser'}">
						<table class="table">

							<tbody>
								<tr>
									<th scope="row"><form:select path="userName"
											style="width: 150px">
											<c:forEach var="user" items="${users}">
												<form:option value="${user.login}">${user.login} </form:option>
											</c:forEach>
										</form:select></th>
									<td>
										<button class="btn btn-primary" type="submit" name="input"
											value="deleteUser">
											<spring:message code="loginAdmin.delete" />
										</button>
									</td>
								</tr>
							</tbody>
						</table>
					</c:if>
					</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-success" type="submit" name="input"
										value="delEvent">
										<spring:message code="loginAdmin.delEvent" />
									</button>
								</td>
								<td>
								<c:if test="${param.input == 'delEvent'}">
						<table class="table">
							<tbody>
								<tr>
									<th scope="row"><form:select path="eventName"
											style="width: 150px">
											<c:forEach var="event" items="${events}">
												<form:option value="${event.eventName}">${event.eventName} </form:option>
											</c:forEach>
										</form:select></th>
									<td>
										<button class="btn btn-primary" type="submit" name="input"
											value="deleteEvent">
											<spring:message code="loginAdmin.delete" />
										</button>
									</td>
								</tr>
							</tbody>
						</table>
					</c:if>
								</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-primary" type="submit" name="input"
										value="back">
										<spring:message code="loginAdmin.exit" />
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				
					

					
					

					
				</div>
			</div>
			<div class="row">
				<div class="col">


					<h3><spring:message code="loginAdmin.showUserAll" /></h3>
					<table class="table table-hover table-dark">
						<thead>
							<tr>
								
								<th scope="col"><spring:message code="loginAdmin.login" /></th>
								<th scope="col"><spring:message code="loginAdmin.password" /></th>
								<th scope="col"><spring:message code="loginAdmin.email" /></th>
								<th scope="col"><spring:message code="loginAdmin.status" /></th>
								<th scope="col"><spring:message code="loginAdmin.access" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									
									<td>${user.login}</td>
									<td>${user.password}</td>
									<td>${user.email}</td>
									<td>${user.role}</td>
									<td>${user.access}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>

				</div>


				<div class="col">
					<h3><spring:message code="loginAdmin.showAll" /></h3>
					
					<table class="table table-hover table-dark">
						<thead>
							<tr>

								<th scope="col"><spring:message code="loginAdmin.name" /></th>
								<th scope="col"><spring:message code="loginAdmin.date" /></th>
								<th scope="col"><spring:message code="loginAdmin.location" /></th>
								<th scope="col"><spring:message code="loginAdmin.price" /></th>
								<th scope="col"><spring:message code="loginAdmin.col" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="event" items="${events}">
							<tr>
									<td>${event.eventName}</td>
									<td>${event.eventDate}</td>
									<td>${event.eventLocation}</td>
									<td>${event.price}</td>
									<td>${event.col}</td>
									<td></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
<div class="col">
					<h3><spring:message code="loginAdmin.showAllArchiv" /></h3>
					<table class="table table-dark">


						<thead>
							<tr>
								<th scope="col"><spring:message code="loginAdmin.name" /></th>
								<th scope="col"><spring:message code="loginAdmin.date" /></th>
								<th scope="col"><spring:message code="loginAdmin.location" /></th>
								<th scope="col"><spring:message code="loginAdmin.price" /></th>
								
							</tr>
						</thead>
						<tbody>


							<c:forEach var="archiv" items="${archivs}">
								<tr>
									
									<td>${archiv.eventName}</td>
									<td>${archiv.eventDate}</td>
									<td>${archiv.eventLocation}</td>
									<td>${archiv.price}</td>
									
								</tr>

							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>
		</div>


	</form:form>

<footer>
                <div class="row"><div class="mx-auto">Copyright &copy; 2019 All rights reserved.ItStep.by</div></div>       
            
        </footer>
</body>
</html>