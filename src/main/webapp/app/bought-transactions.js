var app = angular.module('angularTableBoughtTransactions', ['angularUtils.directives.dirPagination']);
var userId=sessionStorage.getItem("userId");
app.controller('listdata',function($scope, $http){
	$scope.buytransactions = []; //declare an empty array
	$http.get("http://192.168.35.189:8080/shareweb/api/transactions/users/"+userId+"/buy").success(function(response){ 
		$scope.buytransactions = response;  //ajax request to fetch data into $scope.data
		console.log(response);
	});
	$scope.transactionId=0;
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}

	$scope.define=function(tid){
		$scope.transactionId=tid;
		return tid;
	}
	
	$scope.sellShare=function(){
		
		var data;
		$http.post("http://192.168.35.189:8080/shareweb/api/transactions/sell/"+$scope.transactionId,
				data).success(function(data, status) {
			alert("Successfully sold the share");
			window.location="BoughtShares.jsp";
		})
		
	}
	
});
