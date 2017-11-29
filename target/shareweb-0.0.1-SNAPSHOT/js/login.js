$("#login-form").submit(function(event) {
						event.preventDefault();
										var username = $("#username").val();
										var password = $("#password").val();
										var loginData = {
												"userName": username,
											    "password":password
											    
										};
										
										$.ajax({
												type : "POST",
												data : JSON
														.stringify(loginData),
												dataType : "json",
												url : "http://192.168.35.189:8080/shareweb/api/login",
												contentType : "application/json",
												success : function(data,textStatus, jqXHR) {
													console.log(data);
													if(data.userId!=0){
														alert("Logged in successfully");
														window.location="Dashboard.jsp";
														 sessionStorage.setItem("userId",data.userId);
														 sessionStorage.setItem("userName",data.userName);
														 sessionStorage.setItem("userRole",data.role);
													}
													else{
														alert("Incorrect username or password");
													}
												}
										});
										
										
					});