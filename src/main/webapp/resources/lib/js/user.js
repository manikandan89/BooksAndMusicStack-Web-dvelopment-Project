angular.module('ui.bootstrap.home', ['ui.bootstrap']);

angular.module('ui.bootstrap.home').controller('RecentController', function($scope, $http) {
	//console.log("Inside RecentController");
    //console.log(window.location.hostname);
    
    var hostname = window.location.hostname;
    //String hostString = new String(hostname);
    //var latesturl = hostname + "/user/music/latest";
    	var latesturl = "/user/music/latest";
    	//console.log(latesturl);
    if(hostname == "localhost") {
    	//console.log("equal");
    	latesturl =  "http://localhost:8080/booksandmusicstack/user/music/albums/recent";
    } else {
    	//console.log("unequal");
    	//latesturl = "booksandmusicstack-" + hostname + "/user/music/latest"
    }
    
    $http.get(latesturl)
    .success(function(response) {
	    //console.log(response);
	    //console.log(response[0].images[0].url);
	    $scope.albums = response;
    });  
    
    $scope.showtracks = function () {
  	  //console.log("Entering show tracks in Latest controller");
        var id = $scope.album.id;
        //console.log($scope.album.id);
        $http.get("http://localhost:8080/booksandmusicstack/user/music/" + id)
        .success(function(response) {
        	//console.log("response from Latest Controller");
    	    //console.log(response);
        });
        
    }
});