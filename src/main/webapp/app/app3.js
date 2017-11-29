var app = angular.module('angularTableShares',
		[ 'angularUtils.directives.dirPagination' ]);
var userId=sessionStorage.getItem("userId");
app.controller('listdataShares', function($scope, $http,$filter) {
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
