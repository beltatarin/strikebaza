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
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title><spring:message code="loginsuccess.title" /></title>
<style>
body{
background-image: url("<c:url value="/webres/img/strike8.jpg"/>");
background-repeat: no-repeat;
background-size: cover;
background-position: top center !important;

background-attachment: fixed;
color: black;

}
.container{
	background-color: rgb(255,255,255,0.5);
}
</style>
</head>
<body>
	
		<div class="container">
			<div class="row">

				<div class="mx-auto">
					<h1>
						<spring:message code="loginForm.title" />
					</h1>
				</div>
			</div>
			<form:form action="loginsuccess.html" modelAttribute="updateForm">
			<div class="row">
			
				<div class="col-xs-2">
					<table class="table table-bordered">
						<thead>
							
							<tr>
								<th scope="col"><spring:message
										code="loginsuccess.greeting" /></th>
								<th scope="col">${user.role}</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row"><spring:message
										code="loginsuccess.login" /><div class="text-danger"><form:errors path="login" /></div></th>
								<td><input name="loginNew" value="${user.login}"></input></td>
							</tr>
							<tr>
								<th scope="row"><spring:message
										code="loginsuccess.password" /></th>
								<td><input name="passwordNew" value="${user.password}"></input></td>
							</tr>
							<tr>
								<th scope="row"><spring:message
										code="loginsuccess.email" /></th>
								<td><input name="emailNew" value="${user.email}"></input></td>
							</tr>
							
							<tr>
							<th><button class="btn btn-success" type="submit"
										name="input" value="img">
										<spring:message code="loginsuccess.img" />
									</button></th>
								<td><button class="btn btn-success" type="submit"
										name="input" value="save">
										<spring:message code="loginsuccess.save" />
									</button></td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="col-xs-2" style="height:100px;"><img style="height:200px;  width:300px;" src="<c:url value="/webres/img/${user.imgUrl}"/>" alt=""/></div>
				<div class="col-xs-2">
				
					<table class="table">

						<tbody>
							<tr>
								<td><button class="btn btn-success" type="submit"
										name="input" value="add">
										<spring:message code="loginsuccess.add" />
									</button></td>
									
									</tr>
									<tr>
									<td><c:if test="${param.input == 'add'}">

						<table class="table">

							<tbody>
								<tr>
									<th scope="row"><spring:message code="loginsuccess.name" /></th>
									<td><form:input path="eventName" /></td>
								</tr>
								<tr>
									<th scope="row"><spring:message code="loginsuccess.date" /></th>
									<td><form:input type="datetime-local" path="eventDate" /></td>
								</tr>
								<tr>
									<th scope="row"><spring:message code="loginsuccess.location" /></th>
									<td><form:input path="eventLocation" /></td>
								</tr>
								<tr>
									<th scope="row"><spring:message code="loginsuccess.price" /></th>
									<td><form:input path="price" /></td>
								</tr>
								<tr>
								<td>
								
    </td>
								</tr>
						
							</tbody>
						</table>
						<button class="btn btn-primary" type="submit" name="input"
							value="addEvent">
							<spring:message code="loginsuccess.add" />
						</button>

					</c:if>
					</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-success" type="submit" name="input"
										value="delete">
										<spring:message code="loginsuccess.delete" />
									</button>
								</td>
								</tr>
								<tr>
								<td><c:if test="${param.input == 'delete'}">
						<table class="table">

							<tbody>
								<tr>
									<th scope="row">
									<form:select path="eventName" style="width: 150px">
											<c:forEach var="event" items="${myList}">
												<form:option value="${event.eventName}">${event.eventName} </form:option>
											</c:forEach>
										</form:select></th>
									<td>
										<button class="btn btn-primary" type="submit" name="input"
											value="deleteEvent">
											<spring:message code="loginsuccess.delete" />
										</button>
									</td>
								</tr>
							</tbody>
						</table>
					</c:if></td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-primary" type="submit" name="input"
										value="back">
										<spring:message code="loginsuccess.exit" />
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
			</form:form>
			<c:if test="${param.input == 'img'}">
			 <div class="form-row">
			  <div class="input-group">
	<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/>
    <button class="btn btn-success" type="submit" value="Submit">
										<spring:message code="loginsuccess.save" />
									</button>
</form>
    </div>
     </div>
     </c:if>
			<div class="row">

				<div class="col">


					<h3><spring:message code="loginsuccess.show" /></h3>
					<table class="table table-hover table-dark">
						<thead>
							<tr>

								<th scope="col"><spring:message code="loginsuccess.name" /></th>
								<th scope="col"><spring:message code="loginsuccess.date" /></th>
								<th scope="col"><spring:message code="loginsuccess.location" /></th>
								<th scope="col"><spring:message code="loginsuccess.price" /></th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="event" items="${myList}" varStatus="loop">
								<tr data-toggle="modal" data-target="#${loop.getIndex()+1}">
									<td>${event.eventName}</td>
									<td>${event.eventDate}</td>
									<td>${event.eventLocation}</td>
									<td>${event.price}</td>
									
								</tr>
<!-- Modal -->
<div class="modal fade" id="${loop.getIndex()+1}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">${event.eventName}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <c:forEach var="user" items="${event.getUsers()}">
      <div><span>login: ${user.login} </span></div>
      <div><span> role: ${user.role} </span></div>
      <div><span> phone: ${user.phone}</span></div>
      <div>__________________________________</div>
      </c:forEach>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col">
					<h3><spring:message code="loginsuccess.showAll" /></h3>
					
					<table class="table table-hover table-dark">
						<thead>
							<tr>

								<th scope="col"><spring:message code="loginsuccess.name" /></th>
								<th scope="col"><spring:message code="loginsuccess.date" /></th>
								<th scope="col"><spring:message code="loginsuccess.location" /></th>
								<th scope="col"><spring:message code="loginsuccess.price" /></th>
								<th scope="col"><spring:message code="loginsuccess.col" /></th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach var="event" items="${events}" varStatus="loop">

							<tr data-toggle="modal" data-target="#${loop.getIndex()+100}">
							
									<td>${event.eventName}</td>
									<td>${event.eventDate}</td>
									<td>${event.eventLocation}</td>
									<td>${event.price}</td>
									<td>${event.col}</td>
									<td></td>
									
							</tr>
							<!-- Modal -->
<div class="modal fade" id="${loop.getIndex()+100}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">${event.eventName}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <img src="<c:url value="/webres/description/${event.descriptionUrl}"/>" style="width:480px;" alt=""/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div>
				
			</div>
		</div>
</body>
</html>