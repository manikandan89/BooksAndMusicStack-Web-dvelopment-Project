 <!DOCTYPE html>
<html lang="en">
<head>
    <title>AngularJS Routes example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular-route.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.5/angular-route.min.js.map"></script>
</head>

<body ng-app="sampleApp">

<a href="#/route1/abcd">Route 1 + param</a><br/>
<a href="#/route2/1234">Route 2 + param</a><br/>


<div ng-view></div>

<script>
    var module = angular.module("sampleApp", ['ngRoute']);

    module.config(['$routeProvider',
        function($routeProvider, $locationProvider) {
            $routeProvider.
                    when('/route1/:param', {
                    	controller: 'RouteController',
                           templateUrl: 'http://localhost:8080/booksandmusicstack/sample1' 
                        
                    });
        }]);

    module.controller("RouteController", function($rootScope,$scope, $routeParams) {
        console.log("Into the contrl");
        console.log($routeParams.param);
        $rootScope.$on('$routeChangeSuccess', function(){
				console.log($routeParams.param);
            });
    })
</script>



</body>
</html> 





