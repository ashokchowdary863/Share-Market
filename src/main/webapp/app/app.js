var app = angular.module('angularTable', ['angularUtils.directives.dirPagination']);

app.controller('listdata',function($scope, $http){
	$scope.companies = []; //declare an empty array
	$http.get("http://192.168.35.189:8080/shareweb/api/companies").success(function(response){ 
		$scope.companies = response;  //ajax request to fetch data into $scope.data
		console.log(response);
	});
	
	$scope.sort = function(keyname){
		$scope.sortKey = keyname;   //set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; //if true make it false and vice versa
	}
});
