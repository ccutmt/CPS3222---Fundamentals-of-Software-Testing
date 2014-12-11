$(document).ready(function() {

	// Username real-time validation
	$("#username").blur(function() {
		var element = $("#username");
		if (validateUsername(element.val())) {
			element.removeClass('invalid').addClass('valid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');
		} else {
			element.removeClass('valid').addClass('invalid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// Password real-time validation
	$("#password").blur(function() {		
		var element = $("#password");
		if (validatePassword(element.val())) {
			element.removeClass('invalid').addClass('valid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');			
		} else {
			element.removeClass('valid').addClass('invalid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// Name real-time validation
	$("#name").blur(function() {
		var element = $("#name");
		if (validateName(element.val())) {
			element.removeClass('invalid').addClass('valid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');
		} else {
			element.removeClass('valid');// .addClass('invalid');
			element.addClass('invalid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// Surname real-time validation
	$("#surname").blur(function() {
		var element = $("#surname");
		if (validateSurname(element.val())) {
			element.removeClass('invalid').addClass('valid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');
		} else {
			element.removeClass('valid').addClass('invalid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// DOB real-time validation
	$("#dob").blur(function() {
		var element = $("#dob");
		if (validateDOB(element.val())) {
			element.removeClass('invalid').addClass('valid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');
		} else {
			element.removeClass('valid').addClass('invalid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// credit card number real-time validation
	$("#cc_num").blur(function() {
		var element = $("#cc_num");
		var cctype = validateCCType(element.val());
		if ((cctype != 0) && LuhnAlgorithm(element.val())) {
			element.removeClass('invalid').addClass('valid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');
		} else {
			element.removeClass('valid').addClass('invalid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// Credit Card Expiry Date real-time validation
	$("#cc_exp").blur(function() {		
		var element = $("#cc_exp");
		if (validateCCExpiryDate(element.val())) {
			element.removeClass('invalid').addClass('valid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error_show').addClass('error');
		} else {
			element.removeClass('valid').addClass('invalid');
			
			var error_element = $("span", element.parent());
			error_element.removeClass('error').addClass('error_show');
		}
	});

	// Credit Card CVV real-time validation
	$("#cvv").blur(function() {
		var element = $("#cvv");
		if (validateCVV(element.val())) {
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

	$("#register").click(function(event) {
		var form_data = $("#register_form").serializeArray();
		var error_free = true;
		for ( var input in form_data) {
			var element = $("#" + form_data[input]['name']);
			var valid = element.hasClass('valid');
			var error_element = $("span", element.parent());
			if (form_data[input]['name'] != "account_type") {
				//account type can never be invalid
				if (!valid) {
					element.removeClass('valid').addClass('invalid');
					error_element.removeClass('error').addClass('error_show');
					error_free = false;
				} else {
					error_element.removeClass('error_show').addClass('error');
					//document.getElementById("register").href = "http://localhost:8080/SoftwareTesting/BetPage.jsp";
					//document.href = "http://localhost:8080/SoftwareTesting/BetPage.jsp>;
				}
			}
		}

		if (!error_free) {
			event.preventDefault();
		}
	});
});

// Checks whether the username is alphanumeric or not and has to be longer than
// 6
function validateUsername(username) {
	// RegEx expression that accepts A-Z, a-z, 0-9
	if (/^[a-zA-Z0-9]+$/.test(username) && (username.length > 6))
		return true;
	else
		return false;
}

// Checks whether the CVV is valid or not, accepts only 3 or 4 digit number
function validateCVV(cvv) {
	// RegEx expression
	if (/^[0-9]{3}$/.test(cvv))
		return true;
	else
		return false;
}

function validateCCType(ccnum) {

	// if type remains 0, card type not accepted
	var cctype = 0;

	// eliminate non-digit characters
	ccnum = ccnum.replace(/\D/g, "");
	if (/^4\d{12,15}$/.test(ccnum)) {
		// VISA: 4 and 12/15 digits
		cctype = 1;
	} else if (/^5[1-5]\d{14}$/.test(ccnum)) {
		// Mastercard
		cctype = 2;
	} else if (/^3[47]\d{13}$/.test(ccnum)) {
		// American Express
		cctype = 3;
	}
	return cctype;
}

// Checks whether the credit card number is valid or not
function LuhnAlgorithm(ccnum) {

	// accept only digits, dashes or spaces, RegEx expression
	if (/[^0-9-\s]+/.test(ccnum))
		return false;
	else {
		var result = 0;
		var intNum = 0;
		var even = false;

		// select all non digit string and eliminate
		ccnum = ccnum.replace(/\D/g, "");

		// start from the back of number
		for (var n = ccnum.length - 1; n >= 0; n--) {
			var strNum = ccnum.charAt(n);

			// convert back to digit
			var intNum = parseInt(strNum, 10);

			// alternate numbers
			if (even) {
				if ((intNum *= 2) > 9)
					// same result as summing the digits of the product
					intNum -= 9;
			}

			result += intNum;
			even = !even;
		}

		// if no remainder true else false
		return (result % 10) == 0;
	}

}

// Checks whether the password given by the user is 8 characters long
function validatePassword(password) {
	if (password.length > 8)
		return true;
	else
		return false;
}

// This function checks that the name given by the user is not empty, does not
// contain any white spaces and also does not contain any numbers
function validateName(name) {
	if (name == null || name == "") {
		// alert("Name must be filled out");
		return false;
	} else if (containsNumbers(name) == true) {
		// alert("Name can only contain letters")
		return false;
	} else {
		return true;
	}
}

// This function checks that the surname given by the user is not empty, does
// not contain any white spaces and also does not contain any numbers
function validateSurname(surname) {
	if (surname == null || surname == "") {
		return false;
	} else if (containsNumbers(surname) == true) {
		return false;
	} else
		return true;
}

// Function to check whether the player registering is bigger than 18-years old
function validateDOB(dob) {
	var pl_dob = new Date(dob); // date the player inserted in the DOB field
	var today = new Date(); // current date
	if ((today.getFullYear() - pl_dob.getFullYear()) > 18) {
		return true;
	} else if ((today.getFullYear() - pl_dob.getFullYear()) == 18) {
		if ((today.getMonth()) > pl_dob.getMonth()) {
			return true;
		} else if (today.getMonth() == pl_dob.getMonth()) {
			if (today.getDate() >= pl_dob.getDate()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	} else {
		return false;
	}
}

// function that will check that one of the radio button is checked out
function validateAccountType(acc_type) {
	if (acc_type == null) {
		return false;
	} else {
		return true;
	}
}

// This function checks whether the credit card expiry date given by the user is
// in the future or not
function validateCCExpiryDate(exp_dt) {
	var today = new Date();
	var expiry_date = new Date(exp_dt)
	if (expiry_date.getFullYear() > today.getFullYear()) {
		return true;
	} else if (expiry_date.getFullYear() == today.getFullYear()) {
		if (expiry_date.getMonth() >= today.getMonth()) {
			return true;
		} else {
			return false;
		}
	} else {
		return false;
	}
}

// The below function will check a string if it contains any numbers
function containsNumbers(n) {
	var nan = false;
	for (i = 0; i < n.length; i++) {
		if (isNaN(n.charAt(i)) == false) {
			nan = false;
			break;
		} else
			nan = true;
	}

	if (nan == false)
		return true;
	else
		return false;
}

// The below function checks whether the parameter passed is a number or not
/*
 * function isNumeric(n) { if (isNaN(parseFloat(n)) == false) return true; else
 * return false; }
 */