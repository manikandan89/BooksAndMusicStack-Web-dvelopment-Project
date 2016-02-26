var app = angular.module('emotionApp', []);
app.controller('EmotionController', function($scope, $http) {
	
	console.log(" inside EmotionController");
	//var emotion = "chill";
 /*   $http.get("http://localhost:8080/booksandmusicstack/user/emotion/" + emotion )
    .success(function(response) {
    	console.log("response for received emotion");
	    console.log(response);
	    $scope.trackEmotionModels = response;
    });*/
/*	$scope.selectedItem = "Items";
	  $scope.OnItemClick = function(event) {
		   console.log("into o item click");
		    $scope.selectedItem = event;
		    console.log($scope.selectedItem);
		  }*/
	  
	  $scope.colorId = 4;
	    $scope.shade = null;
	    $scope.color = null;
	    $scope.selected = {name:'Red', value: 'red',id:1};
	    $scope.colors = [
	            {name:'chill', shade: 'Chiller',id:1}, 
	            {name:'Red', shade: 'white',id:1}, 
	            {name:'Orange', shade: 'red',id:2}, 
	            {name:'Yellow', shade: 'blue',id:3}, 
	            {name:'Green', shade: 'yellow',id:4}, 
	            {name:'Blue', shade: 'indigo',id:5}, 
	            {name:'Indigo', shade: 'violet',id:6}, 
	            {name:'Violet', shade: 'orange',id:7}
	     ];
	    $scope.check =function(selected,colors){
	        var i = null;
	        for(i in colors){
	            if(colors[i].id == selected.id){
	                return colors[i];
	            }
	        }
	    };
	    $scope.setColor= function(color){
	        $scope.colorId = color.id;
	        $scope.shade = color.shade;
	        $scope.color = color.name;
	        
	        var trigger = color.name;
	        console.log(trigger);
	        
	        if(trigger == "chill") {
		    	console.log("equal");
		    	$http.get("http://localhost:8080/booksandmusicstack/user/emotion/" + trigger )
		        .success(function(response) {
		        	console.log("response for received emotion");
		    	    console.log(response);
		    	   // $scope.trackEmotionModels = response;
		        })
	    	 } else {
		    	console.log("unequal");
	    	  }
	    };
    
});