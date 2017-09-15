var hireApp = angular.module('hireApp', []);

hireApp.controller("hireAppController", function($scope, $http) {

	$scope.step = 0;

	$scope.sendData = function() {
		$scope.step = 4;
		console.log($scope.userData);
		var requestData = {
			method : 'POST',
			url : 'rest/service/verify',
			headers : {
				"Content-Type" : "application/json; charset=UTF-8"
			},
			data : $scope.userData
		}
		$http(requestData).then(function successCallback(response) {
			$scope.step = 5;
		}, function errorCallback(response) {
			$scope.step = 6;
		});
	}

	$scope.increaseStep = function() {
		if (!$scope.checkStepRequirements())
			$scope.step++;
	};

	$scope.decreaseStep = function() {
		$scope.step--;
	};

	$scope.checkStepRequirements = function() {
		if ($scope.step == 1) {
			return !formUser.name.validity.valid
					|| !formUser.email.validity.valid;
		} else {
			false;
		}
	};

	$scope.$watch('step', function() {
		if ($scope.step == 3) {
			$scope.sendData();
		}
	});

});