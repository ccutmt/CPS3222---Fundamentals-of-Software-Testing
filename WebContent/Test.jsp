<!doctype html>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>Test</title>

<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link />

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="parsley.min.js"></script>

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="span6 offset3">

				<form data-validate="parsley">

					<label>Name</label> <input type="text" name="name"
						data-required="true" /> <label>Name</label> <input type="text"
						name="name" data-required="true" /> <label>Name</label> <input
						type="text" name="name" data-required="true" /> <br /> <input
						type="submit" value="Submit" class="btn btn-success" />

				</form>
			</div>
		</div>
	</div>
</body>