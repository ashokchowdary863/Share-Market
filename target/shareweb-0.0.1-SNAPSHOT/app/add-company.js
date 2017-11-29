$("#addCompanyForm").submit(function(event) {
						event.preventDefault();
										var companyName = $("#companyName").val();
										var companyOwner = $("#companyOwner").val();
										var companyDesc = $("#companyDesc").val();
										var growth = $("#growth").val();
										
										var companyData = {
												"companyName": companyName,
											    "companyOwner": companyOwner,
											    "companyDescription": companyDesc,
											    "growth":growth
											
										};
										
										$.ajax({
												type : "POST",
												data : JSON
														.stringify(companyData),
												dataType : "json",
												url : "http://192.168.35.189:8080/shareweb/api/companies",
												contentType : "application/json",
												success : function(data,textStatus, jqXHR) {
													if(data.companyName != null){
														alert("New company added successfully...");
														window.location="Companies.jsp";
													}
													else{
														alert("Error Occured while adding a new company");
													}
												}
										});
										
										
					});