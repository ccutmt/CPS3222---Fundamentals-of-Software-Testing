/**
 * 
 */

//$(document).ready(function() {
//	$('#surname').blur(function() {
//		validateName($('#surname').val());
//	});
//});
//
//function validateSurname(surname) {
//	if (surname == null || surname == "") {
//		alert("Surname must be filled out");
//		return false;
//	} else if (isNumeric(surname)) {
//		alert("Surname can only contain letters")
//	} else
//		return true;
//}


//$(document).ready(function() {
//	$('#name').blur(function() {
//		if (validateName($('#name').val()) == true){
//			/*$('#name').css('border-color', '#00FF00');
//			$('#name').css('border-radius', '3px');
//			$('#name').css('border-style', 'solid');*/
//			$('#name').css('border-width', '0px');
//		}
//		else{
//			$('#name').css('border-color', 'red');
//			$('#name').css('border-radius', '3px');
//			$('#name').css('border-style', 'solid');
//			$('#name').css('border-width', '2px');
//			$('#name').before('<p>Invalid Name.</p>');
//		}
//	});
//	
//	$('#username').blur(function() {
//		validate(('#name').val());
//	});
//});
//
//function validateName(name) {
//	if (name == null || name == "") {
//		//alert("Name must be filled out");
//		return false;
//	} else if (isNumeric(name)) {
//		//alert("Name can only contain letters")
//		return false;
//	} else{
//		return true;
//	}
//}
//
//function isNumeric(n) {
//	for (i = 0; i < n.length; i++) {
//		if (isNaN(parseFloat(n)) == false) {
//			return true;
//		}
//	}
//	return false;
//}