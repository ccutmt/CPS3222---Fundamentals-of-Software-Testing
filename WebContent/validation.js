/**
 * 
 */

$(document).ready(function() {
	$('#name').blur(function() {
		validateName($('#name').val());
	});
});

function validateName(name) {
	if (name == null || name == "") {
		alert("First name must be filled out");
		return false;
	} else if (isNumeric(name)) {
		alert("Name can only contain letters")
	} else
		return true;
}

function isNumeric(n) {
	for (i = 0; i < n.length; i++) {
		if (isNaN(parseFloat(i)) && isFinite(i)) {
			return false;
		}
	}
	return true;
}