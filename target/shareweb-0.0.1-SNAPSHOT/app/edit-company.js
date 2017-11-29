var app = angular.module('angularTableSharesEdit',
		[ 'angularUtils.directives.dirPagination' ]);

app.controller('listdataSharesEdit', function($scope, $http,$filter) {
	$scope.shares = []; // declare an empty array
	$http.get("http://192.168.35.189:8080/shareweb/api/shares").success(
			function(response) {
				$scope.shares = response; // ajax request to fetch data into
											// $scope.data
			});

	$scope.sort = function(keyname) {
		$scope.sortKey = keyname; // set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; // if true make it false and vice
											// versa
	}

	$scope.loadCompany = function(cid, sid) {
		$scope.companyData = [];
		$http.get("http://192.168.35.189:8080/shareweb/api/companies/" + cid)
				.success(function(company) {
					$scope.companyData = company; // ajax request to fetch
													// data into $scope.data
					console.log(company);
				});

		$scope.shareData = [];
		$http.get("http://192.168.35.189:8080/shareweb/api/shares/" + sid).success(
				function(sharedata) {
					$scope.shareData = sharedata; // ajax request to fetch
													// data into $scope.data
					console.log(sharedata);
					console.log(sid);
				});

		$scope.buyShare = function(sid) {
			console.log(sid);
			var numberofShares=document.getElementById("noofShares").value;
			console.log(numberofShares);
			var today = $filter('date')(new Date(),'yyyy-MM-dd');
			var data = JSON.stringify({
				userId : 1,
				shareId : sid,
				noOfShares : numberofShares,
				performedDate : today

			});
			console.log(data);
			$http.post("http://192.168.35.189:8080/shareweb/api/transactions/buy/",
					data).success(function(data, status) {
				alert("Successfully bought the share");
			})
		}

	}
});

function editCompany(){
	
	var sid=document.getElementById("shareId").value;
	var cid=document.getElementById("companyId").value;
	var cPrice=document.getElementById("csprice").value;
	var pPrice=document.getElementById("pprice").value;
	var bPerc=document.getElementById("bpercent").value;
	var noOf=document.getElementById("noofshares").value;
	var companyData = {
			
			"cid": cid,
		    "sid": sid,
		    "currentSharePrice": cPrice,
		    "previousSharePrice":pPrice,
		    "noOfShares": noOf,
		    "brokeragePercentage": bPerc
		   
		
	};
	console.log(companyData);
	$.ajax({
			type : "PUT",
			data : JSON
					.stringify(companyData),
			dataType : "json",
			url : "http://192.168.35.189:8080/shareweb/api/shares/"+sid,
			contentType : "application/json",
			success : function(data,textStatus, jqXHR) {
				if(data.sid>0){
				alert("Succesfully Updated");
				window.location="EditCompanies.jsp";
				}else
					{
					alert("Not Updated");
					}
			}
	});
	
}

