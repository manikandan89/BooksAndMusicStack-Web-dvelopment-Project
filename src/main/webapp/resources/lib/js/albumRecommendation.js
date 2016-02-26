angular.module('ui.bootstrap.AlbumRecommendation', ['ui.bootstrap']);

angular.module('ui.bootstrap.AlbumRecommendation').controller('AlbumRecommendationController', function($scope, $http) {
	//console.log("Inside AlbumRecommendationController");
	
	//console.log(document.getElementById("albumidval").value);
	var albumid = document.getElementById("albumidval").value;
	
	 var hostname = window.location.hostname;
  	var url = "/user/profile/people/friends";
  	//console.log(url);
  	if(hostname == "localhost") {
	    	//console.log("equal");
	    	url =  "http://localhost:8080/booksandmusicstack/user/profile/people/friends";
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
    	//console.log("Friends response");
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
  
  
  $scope.recommendAlbum = function () {
	  
  	  //console.log("Entering recommendAlbum in AlbumRecommendationController");
  	  
	  	var albumRecommendUrl = "/user/music/recommend/";
	  	//console.log(albumRecommendUrl);
	  	if(hostname == "localhost") {
		    	//console.log("equal");
		    	albumRecommendUrl =  "http://localhost:8080/booksandmusicstack/user/music/recommend/";
	  	 } else {
		    	//console.log("unequal");
	  	  }
	  	
        var id = $scope.asyncSelected.userId;
        
        var sample = $scope.map;
	    var doc_id_2 = getById(sample, id);
        
        //console.log(id);
        var userObj = new Object();
        userObj.userId = doc_id_2;  
        
        $http.post(albumRecommendUrl + albumid, JSON.stringify(userObj))
        .success(function(response) {
        	//console.log("response from AlbumRecommendationController for recommendation");
        	alert("The album has been recommended to your friend.");
        	location.reload();
        });
        

    }

});

