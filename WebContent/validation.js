/**
 * 
 */

/*$(document).ready(function() {
	$('#surname').blur(function() {
		validateName($('#surname').val());
	});
});

function validateSurname(surname) {
	if (surname == null || surname == "") {
		alert("Surname must be filled out");
		return false;
	} else if (isNumeric(surname)) {
		alert("Surname can only contain letters")
} else
		return true;
}*/

$(document).ready(function() {
	$('#name').blur(function() {
		var input=$(this);
		var is_name=$(this).val();
		if(validateName($(this).val())){
				input.removeClass("invalid").addClass("valid");
		}
	    else{
	    		input.removeClass("valid").addClass("invalid");
	    }
		//validateName($('#name').val());
		/*if (validateName($('#name').val()) == false){
			$('#name').css('border-color', '#00FF00');
			$('#name').css('border-radius', '3px');
			$('#name').css('border-style', 'solid');
			$('#name').css('border-width', '3px');
		}
		else{
			$('#name').css('border-color', 'red');
			$('#name').css('border-radius', '3px');
			$('#name').css('border-style', 'solid');
			$('#name').css('border-width', '3px');
		}*/
	});

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

function validateName(name) {
	if (name == null || name == "") {
		//alert("Name must be filled out");
		return false;
	} else if (isNumeric(name)) {
		//alert("Name can only contain letters")
		return false;
	} else{
		return true;
	}
}

function isNumeric(n) {
	for (i = 0; i < n.length; i++) {
		if (isNaN(parseFloat(n)) == false) {
			return true;
		}
	}
	return false;
}