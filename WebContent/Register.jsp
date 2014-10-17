<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<<<<<<< HEAD
<title></title>
<link rel="stylesheet" type="text/css" href="register.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src = "validation.js"></script>
=======
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="register.css">
>>>>>>> origin/master
</head>
<body>
	<!--<form action="main.jsp" method="GET">
	 <h1>User Registration</h1>
	<label> Username:<input type="text" name="username" /> <br />

	</label> <label> Password: <input type="password" name="password" /> <br />

	</label> <label> Name: <input type="text" name="name" /> <br />

	</label> <label> Surname: <input type="text" name="surname" /> <br />

	</label> <label> Date of Birth: <input type="date" name="dob" /> <br />

	</label> <label> <input type="radio" name="account" /> Free 
	    Account <input type="radio" name="account" /> Premium Account <br />

	</label> <label> Credit card number: <input type="number" name="cc_num" />
		<br />
	</label> <label> Credit Card expiry date: <input type="date"
		name="expire_date" /> <br />
	</label> <label> CVV: <input type="number" name="expire_date" /> <br />
		<br /> <input type="button" value="Submit" />
	</label>
	
</form>-->
	<div id="register-form">
		<div class='fieldset'>
			<legend>Register</legend>
			<form action="#" method="post" data-validate="parsley">

				<div class='row'>
					<label for='Username'>Username</label> <input type="text"
						placeholder="Username" name='username' id='username'
						data-required="true" data-error-message="Username required">
				</div>

				<div class='row'>
<<<<<<< HEAD
					<label for="password">Password</label> <input type="text"
=======
					<label for="password"><br>Password</label> <input type="text"
>>>>>>> origin/master
						placeholder="Password" name='password' data-required="true"
						data-type="password" data-error-message="Password required">
				</div>

<<<<<<< HEAD
<!-- 				<div class='row'> -->
<!-- 					<label for='Name'>Name</label> <input type="text" -->
<!-- 						placeholder="Name" name='name' id='name' data-required="true" -->
<!-- 						data-error-message="Name required"> -->
<!-- 				</div> -->


					<label for='Name'>Name</label> <input type="text"
						placeholder="Name" name='name' id='name' data-required="true"
						data-error-message="Name required" >

				<div class='row'>
					<label for='Surname'>Surname</label> <input type="text"
=======
				<div class='row'>
					<label for='Name'><br>Name</label> <input type="text"
						placeholder="Name" name='name' id='name' data-required="true"
						data-error-message="Name required">
				</div>

				<div class='row'>
					<label for='Surname'><br>Surname</label> <input type="text"
>>>>>>> origin/master
						placeholder="Surname" name='surname' id='surname'
						data-required="true" data-error-message="Surname required">
				</div>

				<div class='row'>
<<<<<<< HEAD
					<label for='DOB'>Date of Birth</label> <input type="date"
=======
					<label for='DOB'><br>Date of Birth</label> <input type="date"
>>>>>>> origin/master
						placeholder="Date of Birth" name='dob' id='dob'
						data-required="true" data-error-message="Date of Birth required">
				</div>

				<div class='row'>
<<<<<<< HEAD
					<label for='Account'>Free Account</label> <input type="radio">
					<label for='Account'>Premium Account</label> <input type="radio"
						name='account' id='account' data-required="true"
=======
					<label for='Account'><br>Free Account</label> <input type="radio"
						name='account_type' id='account_type' data-required="true"
						data-error-message="Account type required"> <label
						for='Account'>&nbspPremium Account</label> <input type="radio"
						name='account_type' id='account_type' data-required="true"
>>>>>>> origin/master
						data-error-message="Account type required">
				</div>

				<div class='row'>
<<<<<<< HEAD
					<label for='CCNumber'>CreditCard Number </label> <input
=======
					<label for='CCNumber'><br>CreditCard Number</label> <input
>>>>>>> origin/master
						type="number" placeholder="CreditCard Number" name='cc_num'
						id='cc_num' data-required="true"
						data-error-message="CreditCard number required">
				</div>

				<div class='row'>
<<<<<<< HEAD
					<label for='ccexpiry'>CreditCard Expiry Date</label> <input
=======
					<label for='ccexpiry'><br>CreditCard Expiry Date</label> <input
>>>>>>> origin/master
						type="date" placeholder="CreditCard Expiry Date" name='cc_exp'
						id='cc_exp' data-required="true"
						data-error-message="CreditCard Expiry Date required">
				</div>

				<div class='row'>
<<<<<<< HEAD
					<label for='CCV'>CVV</label> <input type="number" placeholder="CVV"
=======
					<label for='CCV'><br>CVV</label> <input type="number" placeholder="CVV"
>>>>>>> origin/master
						name='cvv' id='cvv' data-required="true"
						data-error-message="CVV number required">
				</div>

				<input type="submit" value="Register">
			</form>
		</div>
	</div>
</body>
</html>