<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Studentenverwaltung</title>
</head>
<!--  Hier könnte der Script stehen wenn JavaScript eingebunden werdeen soll  "" <script>
	
	alert("Willkommen zur Buchverwaltung");
	alert("Hier kannst du deine gespeicherten Bücher ansehen,verarbeiten und neue anlegen");
	</script>  -->
<body>


	<div align="center">
		<h1>Angelegte Studenten</h1>

		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Telephone</th>
				<th>Action</th>
			<tr>
				<c:forEach var="employee" items="${listEmployee}">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.email}</td>
						<td>${employee.address}</td>
						<td>${employee.telephone}</td>
						<td><a href="editEmployee?id=${employee.id}">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deleteEmployee?id=${employee.id}">Delete</a></td>

					</tr>
				</c:forEach>
		</table>
		<h3>
			Neuen Studenten anlegen <a href="newEmployee">klicke hier</a>
		</h3>
	</div>

</body>
</html>