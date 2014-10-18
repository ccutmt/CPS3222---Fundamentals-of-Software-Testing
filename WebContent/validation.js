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


$(document).ready(function() {
	$('#name').blur(function() {
		validateName($('#name').val());
	});
});

function validateName(name) {
	if (name == null || name == "") {
		alert("Name must be filled out");
		return false;
	} else if (isNumeric(name)) {
		alert("Name can only contain letters")
		return false
	} else
		return true;
}

function isNumeric(n) {
	for (i = 0; i < n.length; i++) {
		if (!isNaN(parstFloat(i))) {
			return true;
		}
	}
	return false;
}