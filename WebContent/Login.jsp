<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="register.css">
<script src="jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
	<div id="register-form">
		<div class='fieldset'>
			<legend>Login</legend>
			<form id="register_form" action="LoginServlet" method="GET">

				<div class="row">
					<label for="username"></label> <input type="text"
						name="username" id="username" placeholder="Username" /> <span
						id="error_username" class="error">Invalid Username</span>
				</div>

				<div class="row">
					<label for="password"></label> <input
						type="password" placeholder="Password" name="password"
						id="password" /> <span id="error_password" class="error">Invalid
						Password</span>
				</div>

				<div id="register">
					<input type="submit" value="Login" id="login">
				</div>

				<div class='sub'>
					<br>
					<p>
						<a href="Register.jsp">Register</a>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>