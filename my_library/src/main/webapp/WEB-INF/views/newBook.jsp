<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>new Book</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>
<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
	<br>
<a href="admin" class="button">Admin page</a>
<br>
	<c:forEach var="book" items="${books}">
	<div style="background-color: #88ff4d;width=100%;">
		${book}
		</div>
		<a href="deleteBook/${book.id}">delete book</a>
		<br>
	</c:forEach>



	<form:form action="saveBook" modelAttribute="book" method="post">




		<form:input  path="number" name="number" placeholder="number" required="required"/>
		<br>
		<form:input path="company" name="company" placeholder="title" required="required"/>
		<%-- <form:input path="title" name="title" placeholder="title" required="required"/> --%>
		<br>
               Choose  Author  


		<form:select path="departureAuthor" items="${authors}"
			itemLabel="name" itemValue="id" required="required">

	 	</form:select>
		<br>
		
		
		
			<%-- 	Choose arrival Author
			   <form:select path="arrivalAuthor" items="${authors}"
			itemLabel="name" itemValue="id" required="required">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form:select>
		<br> --%> 


		<br>
		<input type="date" name="some" required>
		<br>
		<input name="price" placeholder="price" required>
	

		<button>Save book</button>


	</form:form>
</body>
</html>