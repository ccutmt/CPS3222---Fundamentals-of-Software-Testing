<!doctype html>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>Test</title>

<link rel="stylesheet" type="text/css" href="register.css">
<script type="text/javascript" src="validation.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="parsley.min.js"></script>

</head>

<body>


	<div id="register-form">
		<div class="fieldset">

			<form action="#" method="post" data-validate="parsley">

					<div class="row">
						<label>Name</label> <input type="text" name="name"
							data-required="true" data-parsley-trigger="change" />
					</div>

					<div class="row">
						<label>Name</label> <input type="text" name="name"
							data-required="true" data-parsley-trigger="change"/>

					</div>

					<div class="row">
						<label>Name</label> <input type="text" name="name"
							data-required="true" />
					</div>

					<br /> <input type="submit" value="Submit" class="btn btn-success" />
				</form>
		</div>
	</div>

</body>