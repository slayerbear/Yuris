<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registration</title>
<link rel="stylesheet" href="css/registration.css">

<a href="home">Home page</a>
<br>

<form:form modelAttribute="customer" action="saveCustomer" method="post">
	<div id="form-main">
		<div id="form-div">
			<form class="form" id="form1">

				<p class="name">
				<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
				<div>
					<label for="name">${exception} </label>
				</div>
				<div style="text-align: center; color: red; margin: 5px">
							<label for="name">${customernameException}</label>
						</div>
						<form:input path="name" type="text"
							class="validate[required,custom[onlyLetter],length[0,100]] feedback-input"
							placeholder="Name" id="name"/>
					</p>

					<p class="email">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="email">${emailException}</label>
						</div>
						<form:input path="email" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="email" placeholder="Email" />
					</p>

					<p class="password">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="password">${passwordException}</label>
						</div>
						<form:input path="password" type="text"
							class="validate[required,custom[email]] feedback-input"
							id="password" placeholder="password" />
					</p>

					<p class="telephone">
						<div style="text-align: center; color: red; margin: 5px">
							<label for="telephone">${telephoneException}</label>
						</div>
						<form:input path="telephone" type="text"
							class="validate[required,custom[password]] feedback-input"
							id="telephone" placeholder="phone" />
					</p>

					<div class="submit">
						<input type="submit" value="Збережи мене" id="button-blue" />
						<div class="ease"></div>
					</div>
					
				</form>
			</div>
	</form:form>

У тебе вже є АКАУНТ?????
<form:form action="loginprocesing" method="post">
								<button >Log in</button>
							</form:form>