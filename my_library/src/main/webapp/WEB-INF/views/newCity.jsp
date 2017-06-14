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
<title>new city</title>
</head>
<body>
	<sec:authentication property="name" />
	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
	<br>
	<a href="admin">Admin page</a>
	<br>
	<c:forEach var="city" items="${cities}">
		${city.city_name}
		<a href="deleteCity/${city.id}">delete city</a>
		<br>
	</c:forEach>





	<form:form modelAttribute="city" action="saveCity" method="post">
		<div>
			<label for="name">${exception} </label>
		</div>
		<form:input path="city_name" />



		<form:select path="country" items="${countries}"
			itemLabel="name" itemValue="id">
		</form:select>


		<button>save city</button>
	</form:form>


</body>
</html>