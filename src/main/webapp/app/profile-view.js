$(document).ready(function() {
	var userId=sessionStorage.getItem("userId");
	$.ajax({
		type : "GET",
		url : "http://192.168.35.189:8080/shareweb/api/users/"+userId,
		success : function(data) {
			console.log(data);
			$("#username").html(data[0].customerUserName);
			$("#firstname").html(data[0].customerFirstName);
			$("#lastname").html(data[0].customerLastName);
			$("#password").val("yourpassword");
			$("#email").html(data[0].customerEmail);
			$("#user_mobileno").html(data[0].customerMobile);
			$("#accountno").html(data[0].bankAccountNumber);
			$("#pan").html(data[0].customerPan);
			$("#state").html(data[0].customerState);
			$("#country").html(data[0].customerCountry);
			$("#zipcode").html(data[0].customerZipCode);
			
		}
	});	
	
});