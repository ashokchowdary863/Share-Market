function onSignIn(googleUser) {
				var id_token = googleUser.getAuthResponse().id_token;
				var profile = googleUser.getBasicProfile();
				console.log('ID: ' + profile.getId()); // Do not send to your
														// backend! Use an ID
														// token instead.
				console.log('Name: ' + profile.getName());
				console.log('Image URL: ' + profile.getImageUrl());
				console.log('Email: ' + profile.getEmail());
				$
						.ajax({
							type : "POST",
							data : JSON.stringify(),
							dataType : "json",
							url : "http://192.168.35.189:8080/shareweb/api/users/addgoogleuser/"
									+ id_token,
							contentType : "application/json",
							success : function(data, textStatus, jqXHR) {
								if (data.role === "customer") {
									alert("User Information Updated Successfully \n Login Creditionals \n :"+data.customerUser+"\nPassword:"+"alacriti123 \nPlease update profile Information after login"+);
								} else if(data.role="ee"){
									alert("Email already Existed");
								}
								else {

									alert("Registration Failed");
								}
							}
						});
				console.log("token:" + id_token);
			}

			function signOut() {
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
				});
			}