<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="register.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
	<div id="register-form">
		<div class='fieldset'>
			<legend>Login</legend>
			<form id="register_form" action="LoginServlet" method="GET">
			
				<div class="row">
					<label for="username">Username</label>
					<input type="text" name="username" id="username" placeholder="Username"/>
					<span class="error">Invalid Username</span>
				</div>
				
				<div class="row">
					<label for="password"><br>Password</label> 
					<input type="password" placeholder="Password" name="password" id="password"/>
					<span class="error">Invalid Password</span>
				</div>
				
				<input type="submit" value="Login">
				<div class='row'>
					<br><a href="Register.jsp">Register</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>