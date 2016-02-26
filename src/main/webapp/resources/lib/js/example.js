angular.module('ui.bootstrap.demo', ['ui.bootstrap']);

angular.module('ui.bootstrap.demo').controller('LatestController', function($scope, $http) {
	//console.log("Inside LatestController");
    //console.log(window.location.hostname);
    
    var hostname = window.location.hostname;
    //String hostString = new String(hostname);
    //var latesturl = hostname + "/user/music/latest";
    	var latesturl = "/user/music/latest";
    	//console.log(latesturl);
    if(hostname == "localhost") {
    	//console.log("equal");
    	latesturl =  "http://localhost:8080/booksandmusicstack/user/music/latest";
    } else {
    	//console.log("unequal");
    	//latesturl = "booksandmusicstack-" + hostname + "/user/music/latest"
    }
    
    $http.get(latesturl)
    .success(function(response) {
	    //console.log(response);
	    $scope.albums = response;
    });  
    
    $scope.showtracks = function () {
  	 // console.log("Entering show tracks in Latest controller");
        var id = $scope.album.id;
        //console.log($scope.album.id);
        
        var hostname = window.location.hostname;
    	var url = "/user/music/";
    	//console.log(url);
    	if(hostname == "localhost") {
	    	//console.log("equal");
	    	url =  "http://localhost:8080/booksandmusicstack/user/music/tracks";
    	 } else {
	    	//console.log("unequal");
    	  }
        
    	var albumModel = new Object();
    	albumModel.albumId = id;
    	albumModel.albumName = $scope.album.albumName;
    	albumModel.imgae = $scope.album.image;
    	
        $http.get(url,JSON.stringify(userObj))
        .success(function(response) {
        	//console.log("response from show tracks");
    	    //console.log(response);
        });
        
    }
});

angular.module('ui.bootstrap.demo').controller('TypeaheadCtrl', function($scope, $http) {

	var hostname = window.location.hostname;
 	var url = "/user/music/album";
 	//console.log(url);
 	if(hostname == "localhost") {
	    	//console.log("equal");
	    	url =  "http://localhost:8080/booksandmusicstack/user/music/album";
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
    	//console.log("album response");
      //console.log(response.data);
      $scope.map = response.data.map(function(item){
        return {label:item.albumName, value:item.albumId};
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
  
  
  $scope.showtracks = function () {
	  
      var id = $scope.asyncSelected.albumId;
      
      var sample = $scope.map;
	  //console.log(sample);
	  
	  var doc_id_2 = getById(sample, id);
      
      var hostname = window.location.hostname;
	   	var url = "/user/music/";
	   	//console.log(url);
	   	if(hostname == "localhost") {
	  	    	//console.log("equal");
	  	    	url =  "http://localhost:8080/booksandmusicstack/user/music/";
	   	 } else {
	  	    	//console.log("unequal");
	   	  }
      
      var url = url + doc_id_2;
      window.location=url;
  }
  
  
});

