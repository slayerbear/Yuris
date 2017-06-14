<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/home.css">
<script src="js/home.js"></script>
<title>Home</title>
</head>
<body>








	<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<!-- <button>logout</button>  -->
	</form:form>



	<sec:authorize access="isAuthenticated() and !hasRole('ROLE_ADMIN')">
		<!-- <a href="profile">Profile</a> -->
		<br>
		<a href="basket"><h2>Korzunochka<h2></a>
	</sec:authorize>




	<sec:authorize access="isAuthenticated() and !hasRole('ROLE_ADMIN')">


		<c:forEach var="book" items="${books}">
			<div style="background-color: #00ff80;width=100%;">
				${book.departureAuthor}-${book.company},
				<a
					href="buyBook/${book.id}">
					<button id="bookBook">Купи книжку</button>

				</a>

			</div>
			<br>
		</c:forEach>

	</sec:authorize>
	<sec:authorize access="!isAuthenticated()">
		<c:forEach var="book" items="${books}">
			<div style="background-color: #00ff80;width=100%;">
				${book.departureAuthor}-${book.company},
				 <a href="loginpage">
					<button>Купити книжку</button>

				</a>

			</div>
			<br>
		</c:forEach>

	</sec:authorize>



	<sec:authorize access="!isAuthenticated()">
		<br>
		<a href="loginpage"><h2><div align="center">logins</div></h2></a>
		<br>
		<a href="registration"><h2><div align="center">Regastrazione</div><h2></a>
		<br>
        <br>
	<marquee behavior="alternate" direction="right"><h1>WELCOME</h1></marquee>
	<br>
	</sec:authorize>
	<br>
	<sec:authorize access="hasRole('ROLE_ADMIN')">

		<a href="admin">Admin page</a>

	</sec:authorize>







</body>
</html>