<html>
<head>
<title>User Registration</title>
<link rel="stylesheet" href="style.css">
</head>
<form action="main.jsp" method="GET">
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
</form>
</html>