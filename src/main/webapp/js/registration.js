$("#RegistrationForm").submit(function(event) {
						event.preventDefault();
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
												type : "POST",
												data : JSON
														.stringify(customer),
												dataType : "json",
												url : "http://192.168.35.189:8080/shareweb/api/users/adduser",
												contentType : "application/json",
												success : function(data,textStatus, jqXHR) {
													if(data.role==='customer'){
														alert("Registered Successfully...Please Login");
														window.location="index.jsp";
													}
													else{
														alert("Registration Failed");
													}
												}
										});
										
										
					});