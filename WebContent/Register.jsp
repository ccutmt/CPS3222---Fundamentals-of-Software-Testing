<html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<form action="main.jsp" method="GET">
<h1>User Registration</h1>
		<label> <span>Username:</span> <input type="text"
			name="username" /> <br /> <br />
		</label> 
		
		<label>
		Surname: <input	type="text" name="surname" /> <br /> <br />
		</label>
		
		<label>
			Password: <input type="password" name="password" /> <br /> <br />
		</label> 
		
		<label>
			Name: <input type="text" name="name"> <br /> <br />
		</label>
		
		<label>
		Surname: <input type="text" name="surname" /> <br /> <br /> 
		</label>
		
		<label>
		Date of	Birth: <input type="date" name="dob" /> <br /> <br /> 
		</label>
		
		<label>
		 <input type="checkbox"
			name="free_acc" /> Free Account <input type="checkbox"
			name="prem_acc" /> Premium Account <br /> <br /> 
		</label>
			
		<label>
			Credit card	number: <input type="number" name="cc_num" /> <br /> <br /> 
		</label>
		
		<label>
			Credit Card expiry date: <input type="date" name="expire_date" /> <br /> <br />
		</label>
			
	    <label>
		CVV: <input type="number" name="expire_date" /> <br /> <br /> <input
			type="submit" value="Submit" />
		</label>
	</form>
</html>