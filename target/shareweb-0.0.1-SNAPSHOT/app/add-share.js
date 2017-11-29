var options = {
	url: "http://192.168.35.189:8080/shareweb/api/companies",

	getValue: "companyName",

	list: {
		match: {
			enabled: true
		}
	}
};

$("#provider-json").easyAutocomplete(options);

$("#addShareForm").submit(function(event) {
	event.preventDefault();
					var companyName = $("#provider-json").val();
					var sharePrice = $("#sharePrice").val();
					var noOfShares = $("#noOfShares").val();
					var BPerc = $("#BPerc").val();
					
					var shareData = {
							"companyName": companyName,
						    "currentSharePrice": sharePrice,
						    "noOfShares": noOfShares,
						    "brokeragePercentage":BPerc
						
					};
					
					$.ajax({
							type : "POST",
							data : JSON
									.stringify(shareData),
							dataType : "json",
							url : "http://192.168.35.189:8080/shareweb/api/shares",
							contentType : "application/json",
							success : function(data,textStatus, jqXHR) {
								if(data.companyName===companyName){
									alert("Share Registered Successfully");
									window.location="Shares.jsp";
								}else if(data.companyName==="NE"){
									alert("Company not registered with Share broking....please register to proceed");
								}else{
									alert("Error Occured");
								}
							}
					});
					
					
});