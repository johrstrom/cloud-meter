
var CloudMeter = angular.module("CloudMeter", [] );

CloudMeter.controller('CloudMeterController', 
		function($scope) {
			addFileOptsToScope($scope);
			addChangeFunctionsScope($scope);
		}
);

CloudMeter.directive("testplanUi", function() {
    return {
        template : "<p>Made by a directive!<p1>"
    };
});

function addFileOptsToScope($scope){
	$scope.fileopts = ["Open", "Save", "Close"];
}

function addChangeFunctionsScope($scope){
	$scope.fileOptionSelected = fileOptionSelected;
		
}

function fileOptionSelected(option){
	console.log(option)
}
