var app = angular.module('pendingRequestApp', []);
app.controller('PendingRequestController', function($scope, $http) {
	
	console.log(" inside PendingRequestController");
	
	var hostname = window.location.hostname;
   	var url = "/user/profile/people/requestsGot/pending";
   	console.log(url);
   	if(hostname == "localhost") {
  	    	console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/people/requestsGot/pending";
   	 } else {
  	    	console.log("unequal");
   	  }

    $http.get(url)
    .success(function(response) {
    	console.log("response for checking pending friend requests");
	    console.log(response);
	    $scope.friendModels = response;
    });
    
    $scope.acceptRequest = function (friendModel) {
    	  console.log("Entering acceptRequest in PendingRequestController");
    	  
    	  var acceptUrl = "/user/profile/people/accept";
    	   	console.log(acceptUrl);
    	   	if(hostname == "localhost") {
    	  	    	console.log("equal");
    	  	    	acceptUrl =  "http://localhost:8080/booksandmusicstack/user/profile/people/accept";
    	   	 } else {
    	  	    	console.log("unequal");
    	   	  }
        
          var friendObj = new Object();
          friendObj.mapId = friendModel.mapId;  
          friendObj.recepientName = friendModel.recepientName;  
          friendObj.requestName = friendModel.requestName;  
          friendObj.recepientId = friendModel.recepientId;  
          friendObj.requestId = friendModel.requestId;  
          friendObj.state = friendModel.state;  
          $http.post(acceptUrl, JSON.stringify(friendObj))
          .success(function(response) {
          	console.log("response from PendingRequestController for accept request");
          });
          
      }
    
});