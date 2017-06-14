<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/home.css">
<title>New country</title>
</head>
<body>
	<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
	<br>
	<a href="admin">Admin page</a>
	<br>





	<c:forEach var="country" items="${countries}">
		${country.name}
		<a href="deleteCountry/${country.id}">delete</a>
		<br>


	</c:forEach>


<form:form modelAttribute="country" action="saveCountry" method="post">

	<label for="name">${exception} </label>

	<form:input path="name" placeholder="country"
		class="validate[required,custom[name]] feedback-input" required="required"/>

	
	<button>Save country</button>

</form:form>


</body>
</html>