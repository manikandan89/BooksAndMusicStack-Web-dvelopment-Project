var app = angular.module('viewRecommendationApp', []);
app.controller('ViewRecommendationController', function($scope, $http) {
	
	//console.log(" inside ViewRecommendationController");
	
	var hostname = window.location.hostname;
  	var url = "/user/profile/recommendation/track/received";
  	//console.log(url);
  	if(hostname == "localhost") {
	    	//console.log("equal");
	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/recommendation/track/received";
  	 } else {
	    	//console.log("unequal");
  	  }

    $http.get(url)
    .success(function(response) {
    	//console.log("response for received track recommendations");
	    //console.log(response);
	    $scope.trackRecommendationModels = response;
    });
    
});