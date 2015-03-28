var Paprj1501 = Paprj1501 || {};

Paprj1501.UserRegistration = function UserRegistration() {

	var validate = function validate($form) {
		var $login = $form.find("#user-login");
		var $name = $form.find("#user-name");
		var $password = $form.find("#user-password");
		var $repeatedPassword = $form.find("#user-repeated-password");
		var $email = $form.find("#user-email");
		
		var validSubmission = true;

		if (isEmpty($login)) {
			detachWithError($login, "Digite um login.");
			validSubmission = false;
		}
		
		if (isEmpty($name)) {
			detachWithError($name, "Digite um nome.");
			validSubmission = false;
		}
		if (isEmpty($password)) {
			detachWithError($password, "Digite uma senha.");
			validSubmission = false;
		}
		if (isEmpty($repeatedPassword)) {
			detachWithError($repeatedPassword, "Repita a sennha digitada.");
			validSubmission = false;
		}
		if (isEmpty($email)) {			
			detachWithError($email, "Digite um email.");
			validSubmission = false;
		}
		if (!isValidPassword($password, $repeatedPassword)) {
			detachWithError($password, "As senhas digitadas são diferentes.");
			detachWithError($repeatedPassword, "As senhas digitadas são diferentes.");
			validSubmission = false;
		}

		return validSubmission;
	}

	var isValidPassword = function isValidPassword(passwordField,
			repeatPasswordField) {
		return passwordField.val() === repeatPasswordField.val();
	}

	var isEmpty = function isEmpty($field) {
		return $field.val().length === 0;
	}	
	
	var detachWithError = function detachWithError($field, message){
		$field.parents(".form-group").addClass("has-error has-feedback");
		$field.after("<span class='error-message'> *" + message + "</span>");
	}
	
	var detachWithSuccess = function detachWithSuccess($field, message){
		$field.parents(".form-group").addClass("has-success");		
	}
	
	var removeDetach = function removeDetach($field){
		
	}

	return {
		validate : validate
	}
}

var userRegistration = new Paprj1501.UserRegistration();
