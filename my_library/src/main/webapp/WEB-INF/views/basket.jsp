<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<link rel="stylesheet" href="css/home.css">
<html>
<head>
<title>Basket</title>

 <script src="/js/jquery-3.1.1.min.js"></script>
</head>
<body>

	<a href="home">Home page</a>
	<br>
	<input type="hidden" name="csrf_name" value="${_csrf.parameterName}" />
	<input type="hidden" name="csrf_value" value="${_csrf.token}" />

	<c:forEach var="book" items="${books}">
	 <div style="background-color: #00ff80;width=100%;">
    ${book.departureAuthor} ${book.company}
   </div>
	 <a href="deleteFromOrder/${book.id}">delete From Basket</a>

		<br>
	</c:forEach>



</body>
</html>