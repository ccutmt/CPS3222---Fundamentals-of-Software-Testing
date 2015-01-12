$(document).ready(function() {

	// Bet Amount real-time validation
	/*$("#bet_amt").blur(function() {
		if (validateBetAmount($("#bet_amt").val())) {
			$("#bet_amt").removeClass('invalid');
			$("#bet_amt").addClass('valid');
		} else {
			$("#bet_amt").removeClass('valid');
			$("#bet_amt").addClass('invalid');
		}
	});*/
	
	$("#bet_amt").blur(function() {
		var element = $("#bet_amt");
		if (validateBetAmount(element.val())) {
			element.removeClass('invalid').addClass('valid');

			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');
		} else {
			element.removeClass('valid').addClass('invalid');

			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// Register button, checks that all fields are correct before submitting the
	// data
	$("#place_bet").click(function(event) {
		var form_data = $("#bet_form").serializeArray();
		var error_free = true;
		for ( var input in form_data) {
			var element = $("#" + form_data[input]['name']);
			var valid = element.hasClass('valid');
			var error_element = $("span", element.parent());
			if (!valid) {
				error_element.removeClass('error').addClass('error_show');
				error_free = false;
			} else {
				error_element.removeClass('error_show').addClass('error');
			}
		}

		if (!error_free) {
			event.preventDefault();
		} else {
			alert('No errors: Form will be submitted');
		}
	});
});

// The below function will check the amount if it contains any characters which are not integers
function validateBetAmount(n) {
	var nan = false;
	if(n == 0){
		return false;
	}
	else {
		for (i = 0; i < n.length; i++) {
			if (isNaN(n.charAt(i)) == true) {
				nan = true;
				break;
			} else{
				nan = false;
			}
		}
	}

	if (nan == true)
		return false;
	else
		return true;
}