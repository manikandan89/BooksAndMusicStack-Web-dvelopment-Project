
var app = angular.module('bookSearchResultsApp', []);
app.controller('BookSearchResultsController', function($scope, $http) {
	//console.log("Inside BookSearchResultsController");
	//console.log(document.getElementById("bookidval").value);
	var id = document.getElementById("bookidval").value;
	
	var hostname = window.location.hostname;
	var url = "/user/book/reviews/";
   //	console.log(url);
   	if(hostname == "localhost") {
  	    	//console.log("equal");
  	    	url =  "http://localhost:8080/booksandmusicstack/user/book/reviews/";
   	 } else {
  	    	//console.log("unequal");
   	  }
	
    $http.get(url + id)
    .success(function(response) {
    	//console.log("response for book search in booksearchresults");
	   // console.log(response);
	    $scope.book = response;
    });
});









