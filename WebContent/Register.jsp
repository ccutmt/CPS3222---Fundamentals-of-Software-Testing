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
			<form id="register_form" action="" method="post">
			
				<div class="row">
					<label for="username">Username</label>
					<input type="text" name="username" id="username" placeholder="Username"/>
					<span class="error">Please enter a valid Username</span>
				</div>

				<div class="row">
					<label for="password"><br>Password</label> 
					<input type="password" placeholder="Password" name="password" id="password"/>
					<span class="error">Password required</span>
				</div>


				<div class="row">
					<label for="Name"><br>Name</label> 
					<input type="text" placeholder="Name" name="name" id="name"></input>
					<span class="error">Name required</span>
				</div>

				 <div class="row">
					<label for="Surname"><br>Surname</label> 
					<input type="text" placeholder="Surname" name="surname" id="surname"/>
					<span class="error">Surname required</span>
				</div>

				<div class="row">
					<label for="DOB"><br>Date of Birth</label> 
					<input type="date" name="dob" id="dob"/>
					<span class="error">Date of Birth required</span>	
				</div>

				<div class="row">
					<label for="Account"><br>Free Account</label> 
					<input type="radio" name="account_type" id="account_type"/>
					<span class="error">Account type required</span>
					
					<label for="Account">&nbspPremium Account</label> 
					<input type="radio" name="account_type" id="account_type"/>
					<span class="error">Account type required</span>
				</div>

				<div class="row">
					<label for="CCNumber"><br>CreditCard Number </label> 
					<input type="number" placeholder="CreditCard Number" name="cc_num" id="cc_num"/>
					<span class="error">CreditCard Required</span>
				</div>

				<div class="row">
					<label for="ccexpiry"><br>CreditCard Expiry Date</label> 
					<input type="month" name="cc_exp" id="cc_exp" min="2014-10" max="2050-12"/>
					<span class="error">CreditCard Expiry date required</span>	
				</div>

				<div class="row">
					<label for="CCV"><br>CVV</label> 
					<input type="number" placeholder="CVV" name="cvv" id="cvv" />
					<span class="error">CVV number required</span>
				</div>
				
				<div id="register">
					<input type="submit" value="Register"></input>
				</div>

				<!-- <div id="register">
					<button type="submit">Submit</button>
				</div>-->
			</form>
			
		</div>
	</div>
</body>
</html>