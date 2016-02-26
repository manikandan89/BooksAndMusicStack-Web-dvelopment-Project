var app = angular.module('emotionMusicApp', []);
app.controller('EmotionMusicController', function($scope, $http) {
	
	//console.log(" inside EmotionMusicController");
	
	//console.log(document.getElementById("emotionidval").value);
	var emotionid = document.getElementById("emotionidval").value;
	
	var hostname = window.location.hostname;
	var url = "/user/emotion/music/results/";
	//console.log(url);
	if(hostname == "localhost") {
    	//console.log("equal");
    	url =  "http://localhost:8080/booksandmusicstack/user/emotion/music/results/";
	 } else {
    	//console.log("unequal");
	  }
	
	$http.get(url +  emotionid)
    .success(function(response) {
    	//console.log("response for received emotion music");
	    //console.log(response);
	    $scope.trackEmotionModels = response;
    })
	
});