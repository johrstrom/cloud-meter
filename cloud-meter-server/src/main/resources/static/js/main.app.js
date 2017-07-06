
var CloudMeter = angular.module("CloudMeter", [] );

CloudMeter.controller('CloudMeterController', ["$scope", "$http", function($scope,$http) {
	
	$scope.fileopts = ["Open", "New", "Save"];
	$scope.testplan = [{}];
	
	$scope.GetTestPlan = function () {
		var promise = $http.get("http://localhost:8080/api/v1/testplan?name=cm-test.jmx");
		promise.then(function successCallBack(response){
			$scope.testplan = response.data.CloudMeterTestPlan
			
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
	
	
    $scope.deleteTestElement = function(data) {
        data.nodes = [];
    };
    
    $scope.addTestElement = function(data) {
        var post = data.nodes.length + 1;
        var newName = data.name + '-' + post;
        data.nodes.push({name: newName,nodes: []});
    };
    
    $scope.getCSSCLassForElement = function(element) {
    	console.log("get css called")
    	return "sampler"
    }
    
    
    $scope.tree = [{name: "Node", nodes: []}];
	
	
}]);


















































//var car = {type:"Fiat", model:"500", color:"white"};