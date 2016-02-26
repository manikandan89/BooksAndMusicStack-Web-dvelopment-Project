<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>SiteHome</title>
	<link href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.css" rel="stylesheet"/>
<link href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/lib/js/jquery-1.11.1.js"></script>
<script src="<%=request.getContextPath()%>/resources/lib/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/lib/js/angular.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div ng-app="myApp" ng-controller="SampleController"> 

<ul>
  <li ng-repeat="book in books">
    {{ book.title }}
  </li>
</ul>

</div>


<script>
var app = angular.module('myApp', []);
app.controller('SampleController', function($scope, $http) {
    $http.get("<%=request.getContextPath()%>/test/")
    .success(function(response) {
	    console.log(response);
	    //$scope.books = response;
    });
});
</script> 




</body>
</html>
