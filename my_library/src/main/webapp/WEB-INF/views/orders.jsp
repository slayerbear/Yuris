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
<title>Insert title here</title>
</head>
<body>
<sec:authentication property="name" />
<form:form action="logout" method="post">
	<button>logout</button>
</form:form>
<br>
<a href="admin">Admin page</a>
<br>
Orders
<br>
<c:forEach var="ordersDTO" items="${ordersDTOs}">
	<div style="background-color: aqua">
		${ordersDTO.customer} ${ordersDTO.book} 
<%-- 		<a href="deleteCustomer/${customerDTO.id}">delete</a> --%>
	</div>
	<br>
</c:forEach>
</body>
</html>