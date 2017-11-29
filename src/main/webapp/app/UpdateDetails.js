$(document).ready(function() {
	var userId=sessionStorage.getItem("userId");
	$.ajax({
		type : "GET",
		url : "http://192.168.35.189:8080/shareweb/api/users/"+userId,
		success : function(data) {
			console.log(data);
			$("#username").val(data[0].customerUserName);
			$("#firstname").val(data[0].customerFirstName);
			$("#lastname").val(data[0].customerLastName);
			$("#password").val();
			$("#email").val(data[0].customerEmail);
			$("#user_mobileno").val(data[0].customerMobile);
			$("#accountno").val(data[0].bankAccountNumber);
			$("#pan").val(data[0].customerPan);
			$("#state").val(data[0].customerState);
			$("#country").val(data[0].customerCountry);
			$("#zipcode").val(data[0].customerZipCode);
			
		}
	});	
	
});

$("#UpdateForm").submit(function(event) {
	event.preventDefault();
	var userId=sessionStorage.getItem("userId");		
					var username = $("#username").val();
					var firstname = $("#firstname").val();
					var lastname = $("#lastname").val();
					var password = $("#password").val();
					var email=$("#email").val();
					var user_mobileno=$("#user_mobileno").val();
					var accountno = $("#accountno").val();
					var pan = $("#pan").val();
					var state=$("#state").val();
					var country=$("#country").val();
					var zipcode=$("#zipcode").val();
					
					var customer = {
							
							"customerUserName": username,
						    "customerFirstName": firstname,
						    "customerLastName": lastname,
						    "customerPassword":password,
						    "customerEmail": email,
						    "customerMobile": user_mobileno,
						    "bankAccountNumber": accountno,
						    "customerPan":pan,
						    "customerState": state,
						    "customerCountry": country,
						    "customerZipCode": zipcode
						
					};
					
					$.ajax({
							type : "PUT",
							data : JSON
									.stringify(customer),
							dataType : "json",
							url : "http://192.168.35.189:8080/shareweb/api/users/"+userId,
							contentType : "application/json",
							success : function(data,textStatus, jqXHR) {
								if(data.id>0){
									alert("User Information Updated Successfully");
								}
								else{
									alert("Update Failed");
								}
							}
					});
					
					
});