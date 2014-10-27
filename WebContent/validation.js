$(document).ready(function() {	
	//Password real-time validation
	$('#password').blur(function() {
		//var input=$(this);
		//var is_name=input.val();
		if(validatePassword($('#password').val())){
				$('#password').removeClass("invalid");
				$('#password').addClass("valid");
		}
	    else{
	    		$('#password').removeClass("valid");
	    		$('#password').addClass("invalid");
	    }
	});
	
	//Name real-time validation
	$('#name').blur(function() {
		//var input=$(this);
		//var is_name=input.val();
		if(validateName($('#name').val())){
				$('#name').removeClass("invalid");
				$('#name').addClass("valid");
		}
	    else{
	    		$('#name').removeClass("valid");
	    		$('#name').addClass("invalid");
	    }
	});
	
	//Surname real-time validation
	$('#surname').blur(function() {
		//var input=$(this);
		//var is_name=input.val();
		if(validateSurame($('#surname').val())){
				$('#surname').removeClass("invalid");
				$('#surname').addClass("valid");
		}
	    else{
	    		$('#surname').removeClass("valid");
	    		$('#surname').addClass("invalid");
	    }
	});
	
	//Credit Card Expiry Date real-time validation
	$('#cc_exp').blur(function() {
		//var input=$(this);
		//var is_name=input.val();
		if(validateCCExpiryDate($('#cc_exp').val())){
				$('#cc_exp').removeClass("invalid");
				$('#cc_exp').addClass("valid");
		}
	    else{
	    		$('#cc_exp').removeClass("valid");
	    		$('#cc_exp').addClass("invalid");
	    }
	});
	

	//Register button, checks that all fields are correct before submitting the data
	$("#register").click(function(event){
		var form_data=$("#register_form").serializeArray();
		var error_free=true;
		for (var input in form_data){
			var element=$("#" + form_data[input]['name']);
			var valid=element.hasClass("valid");
			var error_element=$("span", element.parent());
			if (!valid){
				error_element.removeClass("error").addClass("error_show"); 
				error_free=false;
			}
			else{
				error_element.removeClass("error_show").addClass("error");
			}
		}

		if (!error_free){
			event.preventDefault();
		}
		else{
			alert('No errors: Form will be submitted');
		}
	});
});

//Checks whether the password given by the user is 8 characters long
function validatePassword(password){
	if(password.length > 8)
		return true;
	else
		return false;
}


//This function checks that the name given by the user is not empty, does not contain any white spaces and also does not contain any numbers
function validateName(name) {
	if (name == null || name == "") {
		//alert("Name must be filled out");
		return false;
	} else if (containsNumbers(name) == true) {
		//alert("Name can only contain letters")
		return false;
	} else{
		return true;
	}
}

//This function checks that the surname given by the user is not empty, does not contain any white spaces and also does not contain any numbers
function validateSurname(surname) {
	if (surname == null || surname == "")
		return false;
	else if (containsNumbers(surname) == true)
		return false;
	else
		return true;
}

//This function checks whether the credit card expiry date given by the user is in the future or not
function validateCCExpiryDate(expiry_date){
	if(expiry_date >= "2014-10" && expiry_date <= "2050-12")
		return true;
	else 
		return false;
}

//The below function will check a string if it contains any numbers
function containsNumbers(n) {
	var nan = false;
	for (i = 0; i < n.length; i++) {
		if (isNaN(n.charAt(i)) == false) {
			nan = false;
			break;
		}
		else
			nan = true;
	}
	
	if(nan == false)
		return true;
	else
		return false;
}

//The below function checks whether the parameter passed is a number or not
/*function isNumeric(n) {
		if (isNaN(parseFloat(n)) == false) 
			return true;
		else
			return false;
}*/