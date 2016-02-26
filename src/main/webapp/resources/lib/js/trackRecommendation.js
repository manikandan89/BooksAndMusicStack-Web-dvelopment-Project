angular.module('ui.bootstrap.TrackRecommendation', ['ui.bootstrap']);

angular.module('ui.bootstrap.TrackRecommendation').controller('TrackRecommendationController', function($scope, $http) {
	//console.log("Inside TrackRecommendationController");
	
	var hostname = window.location.hostname;
  	var url = "/user/profile/people/friends";
  	//console.log(url);
  	if(hostname == "localhost") {
	    	//console.log("equal");
	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/people/friends";
  	 } else {
	    	//console.log("unequal");
  	  }
	
	//console.log(document.getElementById("trackidval").value);
	var trackid = document.getElementById("trackidval").value;
	
  $scope.selected = undefined;
  $scope.getLocation = function(val) {
    return $http.get(url, {
      params: {
        input: val
      }
    }).then(function(response){
    	//console.log("Friends response");
      //console.log(response.data);
      $scope.map = response.data.map(function(item){
        return {label:item.username, value:item.userId};
      });
      return $scope.map;
    });
  };
  
  function getById(arr, id) {
	  //console.log("getById");
	    for (var d = 0, len = arr.length; d < len; d += 1) {
	    	
	        if (arr[d].label === id) {
	        	
	            return arr[d].value;
	        }
	    }
	}
  
  
  $scope.recommendTrack = function () {
  	  //console.log("Entering recommendTrack in TrackRecommendationController");
  	  
	  	
	  	var recommendtrackUrl = "/user/track/recommend/";
	  	//console.log(recommendtrackUrl);
	  	if(hostname == "localhost") {
		    	//console.log("equal");
		    	recommendtrackUrl =  "http://localhost:8080/booksandmusicstack/user/track/recommend/";
	  	 } else {
		    	//console.log("unequal");
	  	  }
  	  
        var id = $scope.asyncSelected.userId;
        
        var sample = $scope.map;
	    var doc_id_2 = getById(sample, id);
        
        //console.log(doc_id_2);
        var userObj = new Object();
        userObj.userId = doc_id_2;  
        
        $http.post(recommendtrackUrl + trackid, JSON.stringify(userObj))
        .success(function(response) {
        	//console.log("response from TrackRecommendationController for recommendation");
        	alert("The track has been recommended to your friend.");
        	location.reload();
        });
        
    }

});

