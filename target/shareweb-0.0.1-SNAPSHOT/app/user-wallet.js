var app = angular.module('angularTableWalletTransactions', ['angularUtils.directives.dirPagination']);
var userId=sessionStorage.getItem("userId");
app.controller('listdata',function($scope, $http){
	$scope.wallettransactions = []; //declare an empty array
	$http.get("http://192.168.35.189:8080/shareweb/api/wallet/users/"+userId).success(function(response){ 
		$scope.wallettransactions = response;  //ajax request to fetch data into $scope.data
		console.log(response);
	});
	
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}
});
