<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/home.css">
<script src="js/home.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
<form:form action="logout" method="post">
	<button>Назад</button>
</form:form>

	<div>

		<form:form action="loginprocesing" method="post">
			<div class="login-page">
				<div class="form">
				
						<input id="username" name="username" type="text"
							placeholder="login"
							class="validate[required,login[name]] feedback-input"  required/> 
							<br><input
							id="password" name="password" type="password"
							placeholder="password"
							class="validate[required,login[password]] feedback-input" required/> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <br>
						<button id="login">Login</button>
						</div>
						</div>
					</form:form>
					 У ВАС 	ЩЕ НЕМАЄ АКАУНТА???
<form:form action="registration" method="get">
								<button >Registration</button>
							</form:form>
				</div>
				
				
	
<!-- 	<script> -->
<!-- // 		document.getElementById('login').onclick = function() { -->
<!-- // 			if (document.getElementById('username').value == '' || -->
<!-- // 					document.getElementById('password').value == '') { -->
<!-- // 				alert("empty field"); -->
<!-- // 			} -->
			
<!-- // 		} -->
		
<!-- 	</script> -->



</body>
</html>

