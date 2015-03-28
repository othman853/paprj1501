var Paprj1501 = Paprj1501 || {};

Paprj1501.UserRegistration = function UserRegistration() {

	var validate = function validate($form) {
		var $login = $form.find("#user-login");
		var $name = $form.find("#user-name");
		var $password = $form.find("#user-password");
		var $repeatedPassword = $form.find("#user-repeated-password");
		var $email = $form.find("#user-email");
		
		var fields = [{field:$login, message:"Digite o Login."}, {field:$name, message:"Digite o nome."}, 
		              {field:$password, message:"Digite uma senha."}, {field:$repeatedPassword, message:"Digite a senha novamente."}, 
		              {field:$email, message:"Digite um email."}];
		
		var validSubmission = true;
		
		fields.forEach(function(entry){			
			validSubmission = !isEmpty(entry.field);			
			(validSubmission)? removeDetach(entry.field):detachWithError(entry.field, entry.message);
		});

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
		$parent = $field.parents(".form-group"); 
		
		$parent.addClass("has-error");
		
		if($parent.find(".error-message").length === 0){
			$parent.append("<span class='error-message'> *" + message + "</span>");			
		}		
	}
	
	var detachWithSuccess = function detachWithSuccess($field, message){
		$field.parents(".form-group").addClass("has-success");		
	}
	
	var removeDetach = function removeDetach($field){
		$parent = $field.parents(".form-group");
		
		if($parent.hasClass("has-error")){
			$parent.removeClass("has-error");
			$parent.find(".error-message").remove();
		}
	}

	return {
		validate : validate
	}
}

var userRegistration = new Paprj1501.UserRegistration();
