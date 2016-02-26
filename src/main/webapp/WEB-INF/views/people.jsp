
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
    
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>People</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/bootstrap.css" />
        <%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.min.css" /> --%>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/style.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/mani.css" />
     
     
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/jquery.cslider.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/jquery.bxslider.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/animate.css" />
        
        
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/resources/lib/mani/images/ico/apple-touch-icon-144.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/resources/lib/mani/images/ico/apple-touch-icon-114.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/resources/lib/mani/images/apple-touch-icon-72.png">
        <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/resources/lib/mani/images/ico/apple-touch-icon-57.png">
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/lib/mani/images/ico/favicon.ico">
        
         <script src="<%=request.getContextPath()%>/resources/lib/mani/js/jquery.js"></script>
         <script src="<%=request.getContextPath()%>/resources/lib/js/jquery-ui.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/jquery.mixitup.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/bootstrap.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/modernizr.custom.js"></script>	
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/jquery.bxslider.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/jquery.cslider.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/jquery.placeholder.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/jquery.inview.js"></script>
         
        <!-- Load google maps api and call initializeMap function defined in app.js -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&amp;callback=initializeMap"></script>
        
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/app.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/angular.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/ui-bootstrap-tpls-0.12.1.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/people.js"></script>
         
        
         
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.1/css/foundation.css"/>
         <style>
		        #footer {
		   position:relative;
		   bottom:0px;
		   width:100%;
		   height:30px;   
		   background:#000000;
		   text-align:center;
				}

           </style>
         
       
      
    </head>
    
    <body ng-app="ui.bootstrap.people">
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">
                     
                    </a>
                    <!-- Navigation button, visible on small resolution -->
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <i class="icon-menu"></i>
                    </button>
                    <!-- Main navigation -->
                    <div class="nav-collapse collapse pull-right">
                        <ul class="nav">
                        	<li><a href="<%=request.getContextPath()%>/user/">Home</a></li>
                         
                            <li>
                              <a href="<%=request.getContextPath()%>/user/music/">Music</a> 
                            </li>
                            <li>
                              <a href="<%=request.getContextPath()%>/user/book/">Books</a>
                            </li>
                           <li>
                              <a href="<%=request.getContextPath()%>/user/emotion/">Emotions</a>
                            </li> 
                            <li class="active">
                              <a href="<%=request.getContextPath()%>/user/profile/people">Friends</a>
                            </li>
                            <li>
                            	<a href="<%=request.getContextPath()%>/user/profile/recommendation/track">Recommendations</a>
                            </li>
                            <li>
                              <a href="<%=request.getContextPath()%>/user/profile/favourites/album">Favourites</a>
                            </li>
                               <li>
                              <a href="<%=request.getContextPath()%>/user/profile/documentation/">Documentation</a>
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

   
<div class="section secondary-section " id="portfolio">
  
    <div class="triangle"></div>
    <div class="container">
    
    <div class="row" style="border-top :1px solid black; border-left :1px solid black; border-right :1px solid black;">
    	
	  <div class="large-5 columns" style="border-right :1px solid black;"><h4>Add any of the following users</h4></div>
	  <div class="large-5 columns" style="border-right :1px solid black;"><h4>Your pending invitations</h4></div>
	  <div class="large-2 columns"><h4>Your friends</h4></div>
	 </div>
	
	<div class="row" style="border:1px solid black;">

	
	  <div class="large-5 columns" name="addFrns">
	  
	  	<div class="row" ng-controller="PeopleController">
	  	
	  	<br/>
	  	
	  		<div class="large-6 columns"><input type="text" ng-model="asyncSelected.userId" placeholder="Search Users" typeahead="address.label for address in getLocation($viewValue)" typeahead-loading="loadingLocations" class="form-control"></div>
	  		<div class="large-6 columns"><button ng-click="sendRequest(asyncSelected)" class="btn btn-primary">Send Friend Request</button></div>
	  		
	  	</div>
	  	<br/>
	  	<div class="row">
	  		<div class="large-12 columns">
	  			<h4>Add other registered users</h4>
	  		</div>
	  	</div>
	  	
	  	<div ng-controller="UsersListController">
	  	
		  	<div class="row" ng-repeat="user in users">
		  	
		  		<div style="margin-top: 30px" class="large-6 columns"><h4>{{user.username}}</h4></div>
		  		<div style="margin-top: 30px" class="large-6 columns"></div>
		  		
		  	</div>
	  
  		 </div>
	  	
	  </div>
	  
	  	  <div class="large-5 columns" name="addFrns">
	  
	  	<!-- <div class="row" ng-controller="PeopleController">
	  	
	  		<div class="large-6 columns"><input type="text" ng-model="asyncSelected.userId" placeholder="Locations loaded via $http" typeahead="address.label for address in getLocation($viewValue)" typeahead-loading="loadingLocations" class="form-control"></div>
	  		<div class="large-6 columns"><button ng-click="sendRequest(asyncSelected)" class="btn btn-success">Send Friend Request</button></div>
	  		
	  	</div> -->
	  	
	  	<div ng-controller="PendingRequestController">
	  	
		  	<div class="row" ng-repeat="friendModel in friendModels">
		  	
		  		<div style="margin-top: 30px" class="large-6 columns"><h4>{{friendModel.requestName}}</h4></div>
		  		<div style="margin-top: 30px" class="large-6 columns"><button ng-click="acceptRequest(friendModel)" id="accept" class="btn btn-md btn-primary">Accept</button></div>
		  		
		  	</div>
	  
  		 </div>
	  	
	  	<div class="row">
	  	
	  	</div>
	  	
	  </div>
	  
	  <div class="large-2 columns" name="frnReq">
	  
	  <div class="row container-fluid" ng-controller="PeopleController">
	  	
	  		<!-- <div class="large-6 columns"><input type="text" ng-model="asyncSelected.userId" placeholder="Locations loaded via $http" typeahead="address.label for address in getLocation($viewValue)" typeahead-loading="loadingLocations" class="form-control"></div>
	  		<div class="large-6 columns"><button ng-click="sendRequest(asyncSelected)" class="btn btn-success">Send Friend Request</button></div> -->
	  		
	  	<div ng-controller="FriendController">
	  	
		  	<div class="row" ng-repeat="friendModel in friendModels">
		  	
		  		<div style="margin-top: 30px" class="large-6 columns"><h4>{{friendModel.username}}</h4></div>
		  		
		 </div>
	  
  		 </div>
	  	
	  	</div>
	  	
	  	<div class="row">
	  	
	  	</div>
			

		</div>
	</div>
    
    

		<%-- <a href="<%=request.getContextPath()%>/user/profile/people/requestsGot">Requests Received</a> --%>


  			
  	</div>
  	</div>

        <!-- Footer section start -->
     <div id="footer">
            <p>&copy; 2015 Spring Web Development Project  |  by Manikandan</p>
        </div>
        <div class="scrollup">
            <a href="#">
                <i class="icon-up-open"></i>
            </a>
		</div> 
        
    </body>
    </html>