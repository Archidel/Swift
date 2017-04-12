$(documnet).ready(function() {
	
	$('#form-sign-in').submit(function() {
		
		$.ajax({
			url: 'Controller',
			type: 'GET',
			dataType: 'json',
			date: $('#user_login'), 
			
			success: function(date) {
				if(date.isValid){
					$('#dispName').html('Your name is: ' + date.user_login);
					$('#userLogin').slideDown(500);
				}else{
					alter('please enter a valid login')
				}
			}
		});
		
		return false;
	});
	
});