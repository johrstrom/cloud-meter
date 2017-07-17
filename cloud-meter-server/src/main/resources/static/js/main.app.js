
var CloudMeter = angular.module("CloudMeter", ['ui.bootstrap.contextMenu'] );

CloudMeter.controller('CloudMeterController', ["$scope", "$http", function($scope,$http) {
	
	$scope.fileopts = ["Open", "New", "Save"];
	$scope.testplan = [{}];

	$scope.treeOptionsForNode = function (element) {
		if ( element['type'] === 'testplan' ){
			return testPlanTreeOptions;
		}else if ( element['type'] === 'thread-group' ){
			console.log('opening thread group options')
			return [];
		}else if ( element['type'] === 'sampler' ){
			console.log('opening thread group options')
			return [];
		}else {
			console.log('returning no options, element type is ' + element['type'])
			return [];
		}
	};
	
	
	var menuTreeItemHtml = function(text){
		return '<div class="testplan-menu-tree">' + text + '</div>';
	}
	
	var testPlanTreeOptions = [
		{
			html: menuTreeItemHtml('Add'),
			children: [
				{
					html: menuTreeItemHtml('Threads'),
					children: [
						{
							html: menuTreeItemHtml('Thread Group'),
							click: function ($itemScope, $event, modelValue, text, $li) {
								
								var promise = $http.get("http://localhost:8080/api/v1/testelement?type=thread-group&name=Thread Group");
								promise.then(function successCallBack(response){
																		
									$itemScope.node.hashTree.push(response.data);
									
								}, function errorCallback(error){
									
								});
							},
						},
					],
				},

			],
			
		},
	];
	

	
	

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
	
	$scope.testElementMenu = function(element) {
		console.log("testElementMenu called on " + element.testelement.properties["TestElement.name"].value)
	}
	
    $scope.deleteTestElement = function(element) {
        element.hashTree = [];
    };
    
    $scope.addTestElement = function ($itemScope, $event, modelValue, text, $li) {
        //$scope.selected = $itemScope.item.name;
    }
    
    $scope.getCSSCLassForElement = function(element) {
    	
    	if (element !== undefined)
    		return element['type'];
    	else 
    		return "";
    	
    }
    

	
	
}]);

















































//var car = {type:"Fiat", model:"500", color:"white"};