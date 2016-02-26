var app = angular.module('favouriteTrackApp', []);
app.controller('FavouriteTrackController', function($scope, $http) {
	
	//console.log("FavouriteTrackController");
	
	var hostname = window.location.hostname;
   	var url = "/user/track/favourites";
   	//console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/track/favourites";
   	 } else {
  	    	//console.log("unequal");
   	  }

    $http.get(url)
    .success(function(response) {
    	//console.log("response for track favourites");
	    //console.log(response);
	    $scope.tracks = response;
    });
    
});