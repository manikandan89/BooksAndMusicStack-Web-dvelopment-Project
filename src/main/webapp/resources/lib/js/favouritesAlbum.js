var app = angular.module('favAlbumApp', []);
app.controller('favAlbumController', function($scope, $http) {
	
	//console.log("Inside favAlbumController");
	
	var hostname = window.location.hostname;
   	var url = "/user/music/favourites";
   	//console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/music/favourites";
   	 } else {
  	    	//console.log("unequal");
   	  }
	
	 $http.get(url)
	    .success(function(response) {
		    //console.log(response);
		    $scope.albums = response;
	    });  
    
    
    
});