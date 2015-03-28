Paprj1501 = Paprj1501 || {};

Paprj1501.EventBinder = function EventBinder(){
	
	var bind = function bind(){
		
		$("#user-registration-submit").on("click", function(e){
			e.preventDefault();
			
			$form = $("#user-registration");
			
			if(userRegistration.validate($form)){
				$form.submit();			
			}		
		});		
	} 
	
	return{
		bind: bind
	}
	
}

var eventBinder = new Paprj1501.EventBinder();

