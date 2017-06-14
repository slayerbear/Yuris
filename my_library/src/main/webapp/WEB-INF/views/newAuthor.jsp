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
<title>New author</title>

</head>
<sec:authentication property="name" />
<form:form action="logout" method="post">
	<button>logout</button>
</form:form>
<br>
<a href="admin">Admin page</a>
<br>
<c:forEach var="author" items="${authors}">
		${author.name}
		<a href="deleteAuthor/${author.id}">delete author</a>
	<br>
</c:forEach>




<form:form modelAttribute="author" action="saveAuthor" method="post">

	<label for="name">${exception} </label>

	<form:input path="name" placeholder="author"
		class="validate[required,custom[name]] feedback-input" />

	 <form:select path="city" items="${cities}" itemLabel="city_name"
		itemValue="id" class="validate[required,custom[name]] feedback-input">
	</form:select>
	<button>save author</button>

</form:form>





</body>
</html>