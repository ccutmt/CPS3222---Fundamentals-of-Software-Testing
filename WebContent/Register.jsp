<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="register.css">
<script type="text/javascript" src="validation.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="parsley.min.js"></script>

<title>Register Page</title>

</head>
<body>

	<div id="register-form">
		<div class='fieldset'>

			<legend>Register</legend>
			<form action="#" method="post" data-validate="parsley">

				<div class='row'>
					<label>Email</label><input type="text" name="email" 
					data-required="true" data-type="email"
						 data-error-message="Please enter a valid Email Address"/>
				</div>

				<div class='row'>
					<label for='username'>Username</label><input type="text" name="username" placeholder="Username"
					data-required="true" data-type="alphanum"
						data-parsley-trigger="change" data-error-message="Please enter a valid Username"/>
				</div>

				<div class='row'>

					<label for="password">Password</label> <input type="text"
						placeholder="Password" name='password' data-required="true"
						data-type="password" data-error-message="Password required">
				</div>


				<div class='row'>
					<label for='Name'>Name</label> <input type="text"
						placeholder="Name" name='name' id='name' data-required="true"
						data-error-message="Name required">
				</div>


				<!-- <label for='Name'>Name</label> <input type="text" placeholder="Name"
					name='name' id='name' data-required="true"
					data-error-message="Name required">
					-->

				<div class='row'>
					<label for='Surname'>Surname</label> <input type="text"
						placeholder="Surname" name='surname' id='surname'
						data-required="true" data-error-message="Surname required">
				</div>

				<div class='row'>

					<label for='DOB'>Date of Birth</label> <input type="date"
						placeholder="Date of Birth" name='dob' id='dob'
						data-required="true" data-error-message="Date of Birth required">
				</div>

				<div class='row'>

					<label for='Account'><br>Free Account</label> <input
						type="radio" name='account_type' id='account_type'
						data-required="true" data-error-message="Account type required">
					<label for='Account'>&nbspPremium Account</label> <input
						type="radio" name='account_type' id='account_type'
						data-required="true" data-error-message="Account type required">
				</div>

				<div class='row'>

					<label for='CCNumber'>CreditCard Number </label> <input
						type="number" placeholder="CreditCard Number" name='cc_num'
						id='cc_num' data-required="true"
						data-error-message="CreditCard number required">
				</div>

				<div class='row'>

					<label for='ccexpiry'>CreditCard Expiry Date</label> <input
						type="date" placeholder="CreditCard Expiry Date" name='cc_exp'
						id='cc_exp' data-required="true"
						data-error-message="CreditCard Expiry Date required">
				</div>

				<div class='row'>

					<label for='CCV'>CVV</label> <input type="number" placeholder="CVV"
						name='cvv' id='cvv' data-required="true"
						data-error-message="CVV number required">
				</div>

				<input type="submit" value="Register">
			</form>
			
		</div>
	</div>
</body>
</html>