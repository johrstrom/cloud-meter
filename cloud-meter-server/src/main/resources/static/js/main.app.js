
var CloudMeter = angular.module("CloudMeter", [] );

CloudMeter.controller('CloudMeterController', ["$scope", "$http", function($scope,$http) {
	
	$scope.fileopts = ["Open", "New", "Save"];
	$scope.testplan = {};
	
	$scope.GetTestPlan = function () {
		var promise = $http.get("http://localhost:8080/api/v1/testplan?name=blank.jmx");
		promise.then(function successCallBack(response){
			$scope.testplan = response.data.TestPlan
			
		}, function errorCallback(error){
			
		});
	}
	
	$scope.fileOptionsChanged = function() { 
		if ($scope.selectedFileOption === $scope.fileopts[1] ){
			console.log("creating new testplan");
			$scope.GetTestPlan()
		} 
		console.log("new option is " + $scope.selectedFileOption)
	};
	
	
}]);


















































//var car = {type:"Fiat", model:"500", color:"white"};