var app = angular.module('angularDashboardTable', ['angularUtils.directives.dirPagination']);

app.controller('listdata',function($scope, $http){
	var userId=sessionStorage.getItem("userId");
	$scope.dashboard = []; //declare an empty array
	$http.get("http://192.168.35.189:8080/shareweb/api/dashboard/"+userId).success(function(response){ 
		$scope.dashboard = response;  //ajax request to fetch data into $scope.data
		console.log(userId);
	});
	
});
