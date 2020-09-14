var app = angular.module('app', []);

app.controller('postOfficeController', function($scope, $http, $location) {
	$scope.createOffice = function(){
		//var url = $location.absUrl() + "postproject";
		var url = "postOffice";
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		var data = {
				officeLocation: $scope.offLocation
            
        };
		
		
		$http.post(url, data, config).then(function (response) {
			
			if (response.data.status == "Success") {
				$scope.postOfficeCreateMessage = "Sucessful! " + response.data.data;

			} else {
				$scope.postOfficeCreateMessage = "Failed!, Please Choose a different Name for Office!";
			}
			
			
			
		}, function (response) {
			$scope.postOfficeCreateMessage = "Failed!, Please Choose a different Name";
		});
		
		$scope.offLocation = "";
	}
});


app.controller('postProjectController', function($scope, $http, $location) {
	$scope.submitForm = function(){
		//var url = $location.absUrl() + "postproject";
		var url = "postproject";
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		var data = {
            projectname: $scope.projectname,
            projectdesc: $scope.projectdesc,
            loc1: $scope.loc1,
			loc2: $scope.loc2
        };
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = "Sucessful!";
		}, function (response) {
			$scope.postResultMessage = "Fail!";
		});
		
		$scope.projectname = "";
		$scope.projectdesc = "";
		$scope.loc1 = "";
		$scope.loc2 = "";
	}
});

app.controller('getallProjectsController', function($scope, $http, $location) {
	
	$scope.showAllCustomers = false;

	$scope.getAllProjects = function() {
		var url =  "findallProjects";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.allProjects = response.data;
				$scope.showAllProjects = true;

			} else {
				$scope.getResultMessage = "get All Projects Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Failed in populating the data here!";
		});

	}
});

app.controller('getcustomerController', function($scope, $http, $location) {
	
	$scope.showCustomer = false;
	
	$scope.getCustomer = function() {
		var url = $location.absUrl() + "customer/" + $scope.customerId;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.customer = response.data;
				$scope.showCustomer = true;

			} else {
				$scope.getResultMessage = "Customer Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});

app.controller('getcustomersbylastnameController', function($scope, $http, $location) {
	$scope.showCustomersByLastName = false;
	$scope.getCustomersByLastName = function() {
		var url = $location.absUrl() + "findbylastname";
		var config = {
			headers : {	'Content-Type' : 'application/json;charset=utf-8;' },
			params: { 'lastName' : $scope.customerLastName }
		}
		$http.get(url, config).then(function(response) {
			if (response.data.status == "Done") {
				$scope.allcustomersbylastname = response.data;
				$scope.showCustomersByLastName = true;
			} else {
				$scope.getResultMessage = "Customer Data Error!";
			}
		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});
	}
});
