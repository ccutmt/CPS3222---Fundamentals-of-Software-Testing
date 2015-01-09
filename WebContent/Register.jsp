<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="register.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="validation.js"></script>

<title>Register Page</title>

</head>
<body>

	<div id="register-form">
		<div class="fieldset">

			<legend>Register</legend>
			<form id="register_form" action="ServletRegistration" method="GET">
			
				<%session.invalidate(); %>
			
				<div class="row">
					<label for="username"></label>
					<input type="text" name="username" id="username" placeholder="Username"/>
					<span id="error_username" class="error">Invalid Username</span>
				</div>

				<div class="row">
					<label for="password"></label> 
					<input type="password" placeholder="Password" name="password" id="password"/>
					<span id="error_password" class="error">Invalid Password</span>
				</div>


				<div class="row">
					<label for="Name"></label> 
					<input type="text" placeholder="Name" name="name" id="name"></input>
					<span id="error_name" class="error">Invalid Name</span>
				</div>

				 <div class="row">
					<label for="Surname"></label> 
					<input type="text" placeholder="Surname" name="surname" id="surname"/>
					<span id="error_surname" class="error">Invalid Surname</span>
				</div>

				<div class="row">
					<label for="DOB"></label> 
					<input type="text" placeholder="Date of Birth" name="dob" id="dob"/>
					<span id="error_dob" class="error">Invalid Date of Birth</span>	
				</div>

				<div class="row">
					<label for="Account"><br></label> Free Account
					<input type="radio" name="account_type" id="account_type0" value="0" checked/> Premium Account
					<input type="radio" name="account_type" id="account_type1" value="1"/> 
				</div>

				<div class="row">
					<label for="CCNumber"><br></label> 
					<input type="number" placeholder="CreditCard Number" name="cc_num" id="cc_num"/>
					<span id="error_cc_num" class="error">Invalid Credit Card</span>
				</div>

				<div class="row">
					<label for="ccexpiry"></label> 
					<input type="text" placeholder="Credit Card Expiry Date" name="cc_exp" id="cc_exp" />
					<span id="error_cc_exp" class="error">Invalid Credit Card Expiry Date</span>	
				</div>

				<div class="row">
					<label for="CCV"></label> 
					<input type="number" placeholder="CVV" name="cvv" id="cvv" />
					<span id="error_cvv" class="error">Invalid CVV</span>
				</div>
				
				<div id="register">
					<input type="submit" value="Register" id="register"></input>
				</div>

				<!-- <div id="register">
					<button type="submit">Submit</button>
				</div>-->
			</form>
			
		</div>
	</div>
</body>
</html>