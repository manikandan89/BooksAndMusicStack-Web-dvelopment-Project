
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
    
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Music</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/pluton/css/bootstrap.css" />
        <%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.min.css" /> --%>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/pluton/css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/pluton/css/style.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/pluton/css/pluton.css" />
     
     
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/pluton/css/jquery.cslider.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/pluton/css/jquery.bxslider.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/pluton/css/animate.css" />
        
        
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/resources/lib/pluton/images/ico/apple-touch-icon-144.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/resources/lib/pluton/images/ico/apple-touch-icon-114.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/resources/lib/pluton/images/apple-touch-icon-72.png">
        <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/resources/lib/pluton/images/ico/apple-touch-icon-57.png">
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/lib/pluton/images/ico/favicon.ico">
        
         <script src="<%=request.getContextPath()%>/resources/lib/pluton/js/jquery.js"></script>
         <script src="<%=request.getContextPath()%>/resources/lib/js/jquery-ui.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/jquery.mixitup.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/bootstrap.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/modernizr.custom.js"></script>	
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/jquery.bxslider.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/jquery.cslider.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/jquery.placeholder.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/jquery.inview.js"></script>
         
        <!-- Load google maps api and call initializeMap function defined in app.js -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&amp;callback=initializeMap"></script>
        
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/app.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/angular.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/pendingRequest.js"></script>
      
    </head>
    
    <body ng-app="pendingRequestApp">
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                  
                    <!-- Navigation button, visible on small resolution -->
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <i class="icon-menu"></i>
                    </button>
                    <!-- Main navigation -->
                    <div class="nav-collapse collapse pull-right">
                        <ul class="nav">
                        	<li class="active"><a href="#home">Home</a></li>
                      
                           
                            <li>
                              <a href="<%=request.getContextPath()%>/user/music/">Music</a> 
                            </li>
                            <li>
                              <a href="<%=request.getContextPath()%>/user/book/">Books</a>
                            </li>
                           <%--  <li>
                              <a href="<%=request.getContextPath()%>/user/emotion/">Emotions</a>
                            </li> --%>
                            <li>
                              <a href="<%=request.getContextPath()%>/user/profile/people">Friends</a>
                            </li>
                            <li>
                              <a href="<%=request.getContextPath()%>/user/profile/favourites/album">Favourites</a>
                            </li>
                           	<li>
                             <a href="http://booksandmusicstack-mani89.rhcloud.com/j_spring_security_logout">Logout</a>
                            </li>
                        </ul> 
                    </div> 
                    <!-- End main navigation -->
                </div>
            </div>
        </div>   
   
   <br />
   <br />
   

   
<div class="section secondary-section " id="portfolio">
  
    <div class="triangle"></div>
    <div class="container">
    	<br />
    	<br />
    	
    	<div  ng-controller="PendingRequestController" class="container"> 
			<table class="table">
			  <tbody>
			    <tr ng-repeat="friendModel in friendModels" >
			      <td> <h3>{{friendModel.requestName}}</h3></td>
			      <td><button ng-click="acceptRequest(friendModel)" id="accept" class="btn btn-md btn-success">Accept</button></td>
			    </tr>  
			  </tbody>
			</table>
		</div>
    	
    	<!-- <div class='container-fluid' ng-controller="TypeaheadCtrl">
           <h4>Asynchronous results</h4>
           <pre>Model: {{asyncSelected | json}}</pre>
           <input type="text" ng-model="asyncSelected.id" placeholder="Locations loaded via $http" typeahead="address.value for address in getLocation($viewValue)" typeahead-loading="loadingLocations" class="form-control">
       
            <form>
           <button ng-click="showtracks(asyncSelected)" class="btn btn-success">Show tracks</button>
           </form>
           
       </div> -->
   
   
   <br />
   <br />
      <!--   <div class="container" ng-controller="LatestController">
  			  <ul id="portfolio-grid" class="thumbnails row">
  			<li ng-repeat="album in albums" class="span4 mix identity">
                        <div class="thumbnail">
                            <img src="{{ album.images[1].url }}" alt="project 9">
                            <a href="#single-project" class="show_hide more" ng-click="showTracks(album)" >
                            <a href="http://localhost:8080/booksandmusicstack/user/music/{{ album.id }}" class="show_hide more">
                                <i class="icon-plus"></i>
                            </a>
                            <h3>{{ album.name }}</h3>
                            <div class="mask"></div>
                        </div>
                    </li>
              </ul> 
  			</div> -->
  			
  		</div>
  	</div>

        <!-- Footer section start -->
        <div class="footer">
            <p>&copy; 2013 All Rights Reserved</p>
        </div>
        <!-- Footer section end -->
        <!-- ScrollUp button start -->
        <div class="scrollup">
            <a href="#">
                <i class="icon-up-open"></i>
            </a>
        </div>

        
    </body>
    </html>