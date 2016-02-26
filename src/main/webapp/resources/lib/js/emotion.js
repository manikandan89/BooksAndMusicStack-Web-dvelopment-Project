var app = angular.module('emotionApp', []);
app.controller('EmotionController', function($scope, $http) {
	
	//console.log(" inside EmotionController");
	
	 	$scope.emotionId = 4;
	    $scope.emotion = null;
	    $scope.selected = {name:'Select your emotion',id:1};
	    $scope.emotions = [
	            {name:'chill', id:2}, 
	            {name:'classical', id:3}, 
	            {name:'fun', id:4},
	            {name:'love', id:5},
	            {name:'dance', id:6},
	            {name:'tradition', id:7}
	         
	     ];
	    
	    $scope.check =function(selected,emotions){
	        var i = null;
	        for(i in emotions){
	       
	            if(emotions[i].id == selected.id){
	                return emotions[i];
	            }
	        }
	    };
	    $scope.setEmotion= function(emotion){
	        $scope.emotionrId = emotion.id;
	        $scope.emotion = emotion.name;
	        
	        var trigger = emotion.name;
	        //console.log(trigger);
	        
	        var hostname = window.location.hostname;
		   	var url = "/user/emotion/music/";
		   	//console.log(url);
		   	if(hostname == "localhost") {
		  	    	//console.log("equal");
		  	    	url =  "http://localhost:8080/booksandmusicstack/user/emotion/music/";
		   	 } else {
		  	    	//console.log("unequal");
		   	  }
	        
	        window.location = url + trigger;
	        

	    };
});