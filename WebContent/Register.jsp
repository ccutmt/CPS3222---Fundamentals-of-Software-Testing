<html>
<head>
<title>User Registration</title>
<link rel="stylesheet"  type="text/css" href="style.css">
</head>
<!--<form action="main.jsp" method="GET">
	 <h1>User Registration</h1>
	<label> Username:<input type="text" name="username" /> <br />

	</label> <label> Password: <input type="password" name="password" /> <br />

	</label> <label> Name: <input type="text" name="name" /> <br />
	
	</label> <label> Surname: <input type="text" name="surname" /> <br />

	</label> <label> Date of Birth: <input type="date" name="dob" /> <br />

	</label> <label> <input type="checkbox" name="free_acc" /> Free
		Account <input type="checkbox" name="prem_acc" /> Premium Account <br />

	</label> <label> Credit card number: <input type="number" name="cc_num" />
		<br />
	</label> <label> Credit Card expiry date: <input type="date"
		name="expire_date" /> <br />
	</label> <label> CVV: <input type="number" name="expire_date" /> <br />
		<br /> <input type="button" value="Submit" />
	</label>
	
</form>-->
	<div id="registration-form">
	<div class='fieldset'>
    <legend>Register</legend>
		<form action="#" method="post" data-validate="parsley">
			<div class='row'>
				<label for='firstname'>First Name</label>
				<input type="text" placeholder="First Name" name='firstname' id='firstname' data-required="true" data-error-message="Your First Name is required">
			</div>
			<div class='row'>
				<label for="email">E-mail</label>
				<input type="text" placeholder="E-mail"  name='email' data-required="true" data-type="email" data-error-message="Your E-mail is required">
			</div>
			<div class='row'>
				<label for="cemail">Confirm your E-mail</label>
				<input type="text" placeholder="Confirm your E-mail" name='cemail' data-required="true" data-error-message="Your E-mail must correspond">
			</div>
			<input type="submit" value="Register">
		</form>
	</div>
</div>
</html>