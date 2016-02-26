var app = angular.module('emotionBookApp', []);
app.controller('EmotionBookController', function($scope, $http) {
	
	//console.log(" inside EmotionBookController");
	
	//console.log(document.getElementById("emotionidval").value);
	var emotionid = document.getElementById("emotionidval").value;
	
	var hostname = window.location.hostname;
	var url = "/user/emotion/book/results/";
	//console.log(url);
	if(hostname == "localhost") {
    	//console.log("equal");
    	url =  "http://localhost:8080/booksandmusicstack/user/emotion/book/results/";
	 } else {
    	//console.log("unequal");
	  }
    
	
	
	$http.get(url +  emotionid)
    .success(function(response) {
    	//console.log("response for received emotion book");
	    //console.log(response);
	    $scope.books = response;
    })
	
});