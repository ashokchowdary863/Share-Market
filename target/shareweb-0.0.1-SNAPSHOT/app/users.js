var app = angular.module('angularTableUsers',
		[ 'angularUtils.directives.dirPagination' ]);
var userId=sessionStorage.getItem("userId");
app.controller('listdataUsers', function($scope, $http,$filter) {
	$scope.users = []; // declare an empty array
	$http.get("http://192.168.35.189:8080/shareweb/api/users").success(
			function(response) {
				$scope.users = response; // ajax request to fetch data into
											// $scope.data
			});

	$scope.sort = function(keyname) {
		$scope.sortKey = keyname; // set the sortKey to the param passed
		$scope.reverse = !$scope.reverse; // if true make it false and vice
											// versa
	}

	$scope.loadUser = function(uid) {
		$scope.userData = [];
		$http.get("http://192.168.35.189:8080/shareweb/api/users/" + uid)
				.success(function(user) {
					$scope.userData = user; // ajax request to fetch
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

		$scope.updateUser = function(uid) {
			console.log(sid);
			var numberofShares=document.getElementById("noofShares").value;
			console.log(numberofShares);
			var today = $filter('date')(new Date(),'yyyy-MM-dd');
			var data = JSON.stringify({
				userId : userId,
				shareId : sid,
				noOfShares : numberofShares,
				performedDate : today

			});
			console.log(data);
			$http.post("http://192.168.35.189:8080/shareweb/api/transactions/buy/",
					data).success(function(data, status) {
						alert(data);
			})
		}

	}
});
