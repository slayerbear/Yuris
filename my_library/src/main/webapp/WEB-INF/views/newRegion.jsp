<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New region</title>
</head>
<body>
	<c:forEach var="region" items="${regions}">
		${region.region_name}
		<a href="deleteCRegion/${region.id}">delete</a>

		<c:forEach var="city" items="${region.cities}">
			${city.city_name}
			<a href="deleteCityFromRegion/${city.id}">delete city</a>

		</c:forEach>
		<br>
	</c:forEach>
	




	<form:form modelAttribute="region" action="saveRegion" method="post">
		<form:input path="region_name" />



		<form:select path="country" items="${countries}"
			itemLabel="country_name" itemValue="id">
		</form:select>


		<button>save region</button>
	</form:form>
</body>
</html>