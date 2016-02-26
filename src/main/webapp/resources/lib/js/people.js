angular.module('ui.bootstrap.people', ['ui.bootstrap']);



angular.module('ui.bootstrap.people').controller('PeopleController', function($scope, $http) {

	//console.log("Inside People Controller");
	
	var hostname = window.location.hostname;
	var url = "/user/profile/people/users";
   	//console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/people/users";
   	 } else {
  	    	//console.log("unequal");
   	  }
	
  $scope.selected = undefined;
  $scope.getLocation = function(val) {
    return $http.get(url, {
      params: {
        input: val
      }
    }).then(function(response){
    	//console.log("people response");
      //console.log(response.data);
      $scope.map = response.data.map(function(item){
        return {label:item.username, value:item.userId};
      });
      return $scope.map;
    });
  };
  
  
  function getById(arr, id) {
	 // console.log("getById");
	    for (var d = 0, len = arr.length; d < len; d += 1) {
	    	
	        if (arr[d].label === id) {
	        	
	            return arr[d].value;
	        }
	    }
	}
	

  
  $scope.sendRequest = function () {
  	 // console.log("Entering sendRequest in People controller");
  	 var sample = $scope.map;
	 // console.log(sample);
	  
	  var doc_id_2 = getById(sample, $scope.asyncSelected.userId);
  	 
	  
  	var sendRequestUrl = "/user/profile/people";
   //	console.log(sendRequestUrl);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	sendRequestUrl =  "http://localhost:8080/booksandmusicstack/user/profile/people/";
   	 } else {
  	    	//console.log("unequal");
   	  }
  	  
  	  
        var userObj = new Object();
        userObj.userId = doc_id_2;  
        $http.post(sendRequestUrl, JSON.stringify(userObj))
        .success(function(response) {
        	//console.log("response from People Controller for send request");
        	alert("The friend request has been sent");
        	location.reload();
        });
        
    }
  
  
});

angular.module('ui.bootstrap.people').controller('UsersListController', function($scope, $http) {
	
	

	//console.log("Inside UsersListController");
	
	var hostname = window.location.hostname;
	var url = "/user/profile/people/list";
   	//console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/people/list";
   	 } else {
  	    	//console.log("unequal");
   	  }
	
	  $http.get(url)
	    .success(function(response) {
	    	//console.log("response for retrieving users to connect");
		    //console.log(response);
		    $scope.users = response;
	});
  

  
  $scope.sendRequest = function (user) {
  	  //console.log("Entering sendRequest in UsersListController");
  	   
  	var requestUrl = "/user/profile/people";
   	//console.log(requestUrl);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	requestUrl =  "http://localhost:8080/booksandmusicstack/user/profile/people";
   	 } else {
  	    	//console.log("unequal");
   	  }
  	  
        var id = user.userId;
        //console.log(user.userId);
        var userObj = new Object();
        userObj.userId = id;  
        $http.post(requestUrl, JSON.stringify(userObj))
        .success(function(response) {
        	//console.log("response from People Controller for send request");
        });
        
    }
  
  
});

angular.module('ui.bootstrap.people').controller('PendingRequestController', function($scope, $http) {
	
	//console.log(" inside PendingRequestController");
	
	var hostname = window.location.hostname;
   	var url = "/user/profile/people/requestsGot/pending";
   	//console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/people/requestsGot/pending";
   	 } else {
  	    	//console.log("unequal");
   	  }

    $http.get(url)
    .success(function(response) {
    	//console.log("response for checking pending friend requests");
	    //console.log(response);
	    $scope.friendModels = response;
    });
    
    $scope.acceptRequest = function (friendModel) {
    	  //console.log("Entering acceptRequest in PendingRequestController");
    	  
    	  var acceptUrl = "/user/profile/people/accept/";
    	   	//console.log(acceptUrl);
    	   	if(hostname == "localhost") {
    	  	    	//console.log("equal");
    	  	    	acceptUrl =  "http://localhost:8080/booksandmusicstack/user/profile/people/accept/";
    	   	 } else {
    	  	    	//console.log("unequal");
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
        	  
          	//console.log("response from PendingRequestController for accept request");
          
          	$scope.friendModels = response;
          });
          
      }
    
});

angular.module('ui.bootstrap.people').controller('FriendController', function($scope, $http) {
	
	//console.log(" inside FriendController");
	
	var hostname = window.location.hostname;
   	var url = "/user/profile/people/friendslist";
   	//console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/people/friendslist";
   	 } else {
  	    	//console.log("unequal");
   	  }

    $http.get(url)
    .success(function(response) {
    	//console.log("response for get all friends");
	    //console.log(response);
	    $scope.friendModels = response;
    });
    
});

