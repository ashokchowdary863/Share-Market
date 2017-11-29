$("#forgot-password").click(function(event) {
	event.preventDefault();
	var emailId = $("#recovery-email").val();
	console.log(emailId);

	$.ajax({
		type : "POST",
		data : JSON.stringify(),
		dataType : "json",
		url : "http://192.168.35.189:8080/shareweb/api/users/forgotpassword/" + emailId,
		contentType : "application/json",
		success : function(data, textStatus, jqXHR) {
			if (data.userName === "&%^") {
				alert("Password Sent to your mail");
			} else {
				alert("Email not registered with Sharebroking system");
			}
		}
	});

});