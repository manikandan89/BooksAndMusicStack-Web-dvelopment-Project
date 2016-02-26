var app = angular.module('viewAlbumRecommendationApp', []);
app.controller('ViewAlbumRecommendationController', function($scope, $http) {
	
	//console.log(" inside ViewAlbumRecommendationController");
	
	var hostname = window.location.hostname;
  	var url = "/user/profile/recommendation/album/received";
  	//console.log(url);
  	if(hostname == "localhost") {
	    	//console.log("equal");
	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/recommendation/album/received";
  	 } else {
	    	//console.log("unequal");
  	  }

    $http.get(url)
    .success(function(response) {
    	//console.log("response for received album recommendations");
	    //console.log(response);
	    $scope.albumRecommendationModels = response;
    });
    
});