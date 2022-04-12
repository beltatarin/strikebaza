<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
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
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title><spring:message code="loginPlayer.title" /></title>
<style>
body {
	background-image: url("<c:url value="/webres/img/strike3.jpg"/>");
	background-repeat: no-repeat;
	background-size: cover;
	background-position: top center !important;
	background-attachment: fixed;
	color: black;
}

.container {
	background-color: rgb(255, 255, 255, 0.5);
}

footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: grey;
}
</style>
</head>
<body>
	

		<div class="container">
			<div class="row">

				<div class="mx-auto">
					<h1>
						<spring:message code="loginPlayer.title" />
					</h1>
				</div>
			</div>

<form:form action="loginPlayer.html" modelAttribute="updateForm">

			<div class="row">
				<div class="col-xs-2">



					<table class="table table-bordered">
						<thead>
							
							<tr>
								<th scope="col"><spring:message
										code="loginPlayer.greeting" /></th>
								<th scope="col">${user.role}</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row"><spring:message
										code="loginPlayer.login" /><div class="text-danger"><form:errors path="login" /></div></th>
								<td><input name="loginNew" value="${user.login}"></input></td>
							</tr>
							<tr>
								<th scope="row"><spring:message
										code="loginPlayer.password" /></th>
								<td><input name="passwordNew" value="${user.password}"></input></td>
							</tr>
							<tr>
								<th scope="row"><spring:message
										code="loginPlayer.email" /></th>
								<td><input name="emailNew" value="${user.email}"></input></td>
							</tr>
							
							<tr>
							<th><button class="btn btn-success" type="submit"
										name="input" value="img">
										<spring:message code="loginPlayer.img" />
									</button></th>
								<td><button class="btn btn-success" type="submit"
										name="input" value="save">
										<spring:message code="loginPlayer.save" />
									</button></td>
							</tr>

						</tbody>
					</table>
				</div>
				<div class="col-xs-2" style="height:100px;"><img style="height:200px; width:300px;" src="<c:url value="/webres/img/${user.imgUrl}"/>" alt=""/></div>
			
				<div class="col-xs-2">
					<table class="table">

						<tbody>
							<tr>
								<td><button class="btn btn-success" type="submit"
										name="input" value="add">
										<spring:message code="loginPlayer.add" />
									</button></td>
									</tr>
									<tr>
									<td>
									<c:if test="${param.input == 'add'}">
									<table class="table">

							<tbody>
								<tr>
									<th scope="row">
									<form:select path="eventName" style="width: 150px">
											<c:forEach var="event" items="${events}">
												<form:option value="${event.eventName}">${event.eventName} </form:option>
											</c:forEach>
										</form:select></th>
										<td>
										<button class="btn btn-primary" type="submit" name="input"
											value="addEvent">
											<spring:message code="loginPlayer.add" />
										</button></td>
								</tr>
							</tbody>
						</table>
					</c:if>
					</td>
					</tr>
							
							<tr>
								<td>
									<button class="btn btn-success" type="submit" name="input"
										value="delete">
										<spring:message code="loginPlayer.delete" />
									</button>
								</td>
								</tr>
								<tr>
								<td>
								<c:if test="${param.input == 'delete'}">
						<table class="table">
							<tbody>
								<tr>
									<th scope="row">
									<form:select path="eventName"
											style="width: 150px">
											<c:forEach var="event" items="${myList}">
												<form:option value="${event.eventName}">${event.eventName} </form:option>
											</c:forEach>
										</form:select></th>
									<td>
										<button class="btn btn-primary" type="submit" name="input"
											value="deleteEvent">
											<spring:message code="loginPlayer.delete" />
										</button></td>
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
										<spring:message code="loginPlayer.exit" />
									</button>
								</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-primary" type="submit" name="input"
										value="sorted">
										<spring:message code="loginPlayer.sortedEvent" />
									</button>
								</td>
							</tr>

						</tbody>
					</table>

					
					
					<c:if test="${param.input == 'sorted'}">
						<form:select path="compar" style="width: 150px">

							<form:option value="eventName">Название </form:option>
							<form:option value="eventDate">Дата</form:option>
							<form:option value="eventPrice">Стоимость</form:option>
						</form:select>
						
						<button class="btn btn-primary" type="submit" name="input"
							value="sortedEvent">
							<spring:message code="loginPlayer.sortedEvent" />
						</button>
					</c:if>
				</div>
			</div>
			</form:form>
			<c:if test="${param.input == 'img'}">
			 <div class="form-row">
			  <div class="input-group">
	<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <input type="file" name="file" /><br/>
    <button class="btn btn-success" type="submit" value="Submit">
										<spring:message code="loginPlayer.save" />
									</button>
</form>
    </div>
     </div>
     </c:if>
			<div class="row">

				<div class="col">


					<h3><spring:message code="loginPlayer.show" /></h3>
					<table class="table table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col"><spring:message code="loginPlayer.name" /></th>
								<th scope="col"><spring:message code="loginPlayer.date" /></th>
								<th scope="col"><spring:message code="loginPlayer.location" /></th>
								<th scope="col"><spring:message code="loginPlayer.price" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="event" items="${myList}" varStatus="loop">
								<tr>
									<th scope="row">${loop.getIndex()+1}</th>
									<td>${event.eventName}</td>
									<td>${event.eventDate}</td>
									<td>${event.eventLocation}</td>
									<td>${event.price}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>

				</div>


				<div class="col">

					<h3><spring:message code="loginPlayer.showAll" /></h3>

					<table class="table table-hover table-dark">


						<thead>
							<tr>

								<th scope="col"><spring:message code="loginPlayer.name" /></th>
								<th scope="col"><spring:message code="loginPlayer.date" /></th>
								<th scope="col"><spring:message code="loginPlayer.location" /></th>
								<th scope="col"><spring:message code="loginPlayer.price" /></th>
								<th scope="col"><spring:message code="loginPlayer.col" /></th>
							</tr>
						</thead>
						<tbody>


							<c:forEach var="event" items="${events}" varStatus="loop">
								<tr data-toggle="modal" data-target="#${loop.getIndex()+1}">

									<td>${event.eventName}</td>
									<td>${event.eventDate}</td>
									<td>${event.eventLocation}</td>
									<td>${event.price}</td>
									<td>${event.col}</td>
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


	
	<footer>
		<div class="row">
			<div class="mx-auto">Copyright &copy; 2019 All rights
				reserved.ItStep.by</div>
		</div>

	</footer>
</body>
</html>