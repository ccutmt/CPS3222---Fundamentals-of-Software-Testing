<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet"  type="text/css" href="login.css">
</head>
<body>
	<div id="login-form">
		<div class='fieldset'>
			<legend>Login</legend>
			<form action="#" method="post" data-validate="parsley">
				<div class='row'>
					<label for='username'>Username</label> <input type="text"
						placeholder="Username" name='username' id='username'
						data-required="true"
						data-error-message="Username required!">
				</div>
				<div class='row'>
					<label for="password">Password</label> <input type="text"
						placeholder="Password" name='password' data-required="true"
						data-error-message="Password required">
				</div>
				<input type="submit" value="Login">
				<div class='row'>
					<br><a href="http://localhost:8080/SoftwareTesting/Register.jsp">Register</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>