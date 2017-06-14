<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- <link rel="stylesheet" href="css/home.css"> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile</title>
<link rel="stylesheet" href="css/profile.css">
<script src="js/profile.js"></script>
</head>
<body>
	<a href="home">Home page</a>
	<br>


	<div id="121">
		<h1>${customer.name}</h1>
		<h3>${customer.email}</h3>
		<h4>${customer.telephone}</h4>

	</div>
	<div id="12">
		<img src="${customer.pathImage}" alt="add foto" width="100 px"
			height="100 px"> <br>
		<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
			method="post" enctype="multipart/form-data">
			<input   id="foto" type="file" name="image" >
			<button  id="ok">save image</button>
		</form:form>
	</div>


 	<script> 
 		document.getElementById('ok').onclick = function() {
			if (document.getElementById('foto').value == ''  
 					) { 
 				alert("Please choose a photo!!!"); 
 			} 
			
		} 
		
 	</script> 




</body>
</html>