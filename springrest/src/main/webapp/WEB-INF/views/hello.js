var test=angular.module('demo', []);
test.controller('Hello', function($scope, $http)
{
	$scope.getRequest= function()
	{
		$http.get('/springrest/employees').then(function(response)
		{
			  $scope.employees = response.data.employees;
	  	});
	}
	
	
	
	$scope.postRequest = function() {
	    $http.post("http://urlforapi.com/", data).then(
	      function successCallback(response) {
	        console.log("Successfully POST-ed data");
	      },
	      function errorCallback(response) {
	        console.log("POST-ing of data failed");
	      }
	    );
	  };
   
});
