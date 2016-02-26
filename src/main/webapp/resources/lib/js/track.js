
var app = angular.module('trackApp', []);
app.controller('TrackController', function($scope, $http) {
	//console.log(document.getElementById("hiddenelement"));
	//console.log(document.getElementById("styleidval").value);
	var albumid = document.getElementById("styleidval").value;
	
	var hostname = window.location.hostname;
 	var url = "/user/music/tracks/";
 	//console.log(url);
 	if(hostname == "localhost") {
	    	//console.log("equal");
	    	url =  "http://localhost:8080/booksandmusicstack/user/music/tracks/";
 	 } else {
	    	//console.log("unequal");
 	  }
     
	
    $http.get(url + albumid)
    .success(function(response) {
    	//console.log("response for tracks");
	    //console.log(response);
	    $scope.tracks = response;
    });
    
    $scope.insertFavouriteTrack = function (track) {
    	  //console.log("Inserting favourite track");
    	  
    	  var favouriteTrackUrl = "/user/track/";
    	 	//console.log(favouriteTrackUrl);
    	 	if(hostname == "localhost") {
    		    	//console.log("equal");
    		    	favouriteTrackUrl =  "http://localhost:8080/booksandmusicstack/user/track/";
    	 	 } else {
    		    	//console.log("unequal");
    	 	  }
    	  
    	  //console.log(track);
          //var id = $scope.tracks.indexOf(track);
    	  //console.log("wrong id" + albumid);
          //console.log(track.trackId);
          var trackObj = new Object();
          trackObj.trackId = track.trackId;
          $http.post(favouriteTrackUrl, JSON.stringify(trackObj))
          .success(function() {
          	//console.log("response from Controller for persisting track favourites");
          	alert("The track has been added to your favorites.");
          });
          
     }
    
    $scope.insertFavouriteAlbum = function () {
  	  //console.log("Inserting favourite album");
  	  
	  	var favouriteAlbumUrl = "/user/music/";
	 	//console.log(favouriteAlbumUrl);
	 	if(hostname == "localhost") {
		    	//console.log("equal");
		    	favouriteAlbumUrl =  "http://localhost:8080/booksandmusicstack/user/music/";
	 	 } else {
		    	//console.log("unequal");
	 	  }
  	 
        //var id = $scope.tracks.indexOf(track);
  	  	//console.log("correct id" + albumid);
        
        var albumObj = new Object();
        albumObj.albumId = albumid;
        $http.post(favouriteAlbumUrl, JSON.stringify(albumObj))
        .success(function() {
        	//console.log("response from Controller for persisting album favourites");
        	alert("The album has been added to your favorites.");
        });
        
   }
    
    $scope.recommendTrack = function (track) {
    	  console.log("Recommend track");
    	  
    	  var recommendTrackUrl = "/user/track/recommend/";
  	 	//console.log(recommendTrackUrl);
  	 	if(hostname == "localhost") {
  		    	//console.log("equal");
  		    	recommendTrackUrl = "http://localhost:8080/booksandmusicstack/user/track/recommend/";
  	 	 } else {
  		    	//console.log("unequal");
  	 	  }
    	 
    	  //console.log(track);
          //console.log(track.trackId);
          var id = track.trackId;
         
          window.location=recommendTrackUrl + id;
     }
    
    $scope.recommendAlbum = function () {
  	  //console.log("Recommend album");
  	  
  	  var recommendAlbumUrl = "/user/music/recommend/";
	 	//console.log(recommendAlbumUrl);
	 	if(hostname == "localhost") {
		    	//console.log("equal");
		    	recommendAlbumUrl = "http://localhost:8080/booksandmusicstack/user/music/recommend/";
	 	 } else {
		    	//console.log("unequal");
	 	  }
  	 
  	  //console.log(albumid);
       
        var id = albumid;
        
        window.location = recommendAlbumUrl + id;
   }
    
});

