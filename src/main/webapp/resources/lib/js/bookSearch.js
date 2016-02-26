var app = angular.module('bookApp', ['ui.bootstrap']);

app.controller('BookSearchController', function($scope, $http) {

	//console.log("Inside BookSearchController");
	
	var hostname = window.location.hostname;
	var url = "/user/book/search";
   	//console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/book/search";
   	 } else {
  	    	//console.log("unequal");
   	  }
	
    
	 $scope.selected = undefined;
	  $scope.getLocation = function(val) {
		  //console.log("inside func");
	    return $http.get(url, {
	      params: {
	        input: val
	      }
	    }).then(function(response){
	    	//console.log("book search response");
	      //console.log(response.data);
	      $scope.map = response.data.map(function(item){
	        return {label:item.bestBook.title, value:item.bestBook.id};
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
	  
	  
	  $scope.showbooks = function () {
		 // console.log("inside show books");
	      var id = $scope.asyncSelected.id;
	      var sample = $scope.map;
	      var doc_id_2 = getById(sample, id);
	      
	      //console.log(doc_id_2);
	      
	      var hostname = window.location.hostname;
		   	var url = "/user/book/";
		   	//console.log(url);
		   	if(hostname == "localhost") {
		  	    	//console.log("equal");
		  	    	url =  "http://localhost:8080/booksandmusicstack/user/book/";
		   	 } else {
		  	    	//console.log("unequal");
		   	  }
	      
	    
	      var completeurl = url + doc_id_2;
	      //console.log(completeurl);
	      window.location = completeurl;
	     
	  }
	  
	  var recommendedurl = "/user/book/recommended";
	   //	console.log(recommendedurl);
	   	if(hostname == "localhost") {
	  	    	//console.log("equal");
	  	    	recommendedurl =  "http://localhost:8080/booksandmusicstack/user/book/recommended";
	   	 } else {
	  	    	//console.log("unequal");
	   	  }
	  
	  
	  $http.get(recommendedurl)
	    .success(function(response) {
	    	//console.log("response for book recommendation");
		    //console.log(response);
		    $scope.books = response;
	    });
});