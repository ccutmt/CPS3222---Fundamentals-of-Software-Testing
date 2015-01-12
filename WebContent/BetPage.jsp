<%@page import="Functions.BettingFunctions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="register.css">
<link rel="stylesheet" type="text/css" href="table.css">
<script src="jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="betvalidation.js"></script>

<title>Bet Page</title>

</head>
<body>

	<div id="register-form">
		<div class="fieldset">

			<legend>Bets</legend>
			<form id="register_form" action="BetServlet" method="GET">

				<%
					if (session.getAttribute("usernameforbet") == null) {
						response.sendRedirect("Pages/NullUserBet.html");
						return;
					}
				%>

				<p>User Logged in as: <b><%=session.getAttribute("usernameforbet")%> </b><br></p>
				<input type="hidden" name="username"
					value=<%=session.getAttribute("usernameforbet")%> /> 

				<div class="row">
				<div class="CSSTableGenerator">
					<table style="width: 100%">
						<tr>
							<td>BetID</td>
							<td>Risk Level</td>
							<td>Amount</td>
						</tr>
						<%
							BettingFunctions bf = new BettingFunctions();
							out.print(bf.getAllBets(session.getAttribute("usernameforbet")
									.toString()));
						%>
					</table>
					</div>
				</div>
				<div class="row">
					<label for="risk"><br></label> Risk Level <br> <br>
					Low <input type="radio" name="risk_lvl" id="low" value="0" checked />
					Medium <input type="radio" name="risk_lvl" id="medium" value="1" />
					High <input type="radio" name="risk_lvl" id="high" value="2" />
				</div>

				<div class="row">
					<label for="BetAmount"></label> <input
						type="number" placeholder="Bet Amount" name="bet_amt" id="bet_amt" />
					<span id="error_bet_amt" class="error">Error in the Bet
						Amount field </span>
				</div>

				<div id="register">
					<input type="submit" value="Place Bet" id="bet"></input>
				</div>
				<div class='sub'>
					<p>
						<br> <a id="logout"
							href="http://localhost:8080/SoftwareTesting/HomePage.jsp">Logout</a>
					</p>
				</div>
			</form>

		</div>
	</div>
</body>
</html>