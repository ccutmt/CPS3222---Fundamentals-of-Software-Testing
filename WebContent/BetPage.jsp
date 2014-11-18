<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="register.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="betvalidation.js"></script>

<title>Bet Page</title>

</head>
<body>

	<div id="register-form">
		<div class="fieldset">

			<legend>Bets</legend>
			<form id="bet_form" action="" method="post">

				<div class="row">
					<label for="risk"><br></label> Risk Level <br><br> Low
					<input type="radio" name="risk_lvl" id="risk_lvl" value="0" checked/> Medium
					<input type="radio" name="risk_lvl" id="risk_lvl" value="1"/> High 
					<input type="radio" name="risk_lvl" id="risk_lvl" value="2"/> 
				</div>

				<div class="row">
					<label for="BetAmount"><br>Bet Amount </label> 
					<input type="number" placeholder="Bet Amount" name="bet_amt" id="bet_amt"/>
					<span class="error">Error in the Bet Amount field </span>
				</div>
								
				<div id="place_bet">
					<input type="submit" value="Place Bet"></input>
				</div>
				<div class='row'>
					<br><a href="http://localhost:8080/SoftwareTesting/HomePage.jsp">Logout</a>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>