
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
         <%-- <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/ui-bootstrap-tpls-0.12.1.js"></script> --%>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/angular-route.min.js"></script>           
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/track.js"></script>
      
    </head>
    
    <body ng-app="">
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">
                      <%--   <img src="<%=request.getContextPath()%>/resources/lib/pluton/images/logo.png" width="120" height="40" alt="Logo" />
                        <!-- This is website logo --> --%>
                    </a>
                    <!-- Navigation button, visible on small resolution -->
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <i class="icon-menu"></i>
                    </button>
                    <!-- Main navigation -->
                    <div class="nav-collapse collapse pull-right">
                        <ul class="nav" id="top-navigation">
                            <li class="active"><a href="#home">Home</a></li>
                            <li><a href="#service">Services</a></li>
                            <li><a href="#portfolio">Portfolio</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#clients">Clients</a></li>
                            <li><a href="#price">Price</a></li>
                            <li><a href="#contact">Contact</a></li>
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
    	
    <!-- 	<br />
    	<br />
    	
    	<div class='container-fluid' ng-controller="TypeaheadCtrl">
           <h4>Asynchronous results</h4>
           <pre>Model: {{asyncSelected | json}}</pre>
           <input type="text" ng-model="asyncSelected.id" placeholder="Locations loaded via $http" typeahead="address.value for address in getLocation($viewValue)" typeahead-loading="loadingLocations" class="form-control">
           <button ng-click="showtracks(asyncSelected)" class="btn btn-success">Get tracks</button>
       </div> -->
  
   <input type="hidden" id="trackidval" name="trackidval" value="${trackId}" />
   
   <br />
   <br />
   <div >
      <div class="toggleDiv row-fluid single-project">
          <div class="span6">
              <img src="<%=request.getContextPath()%>/resources/lib/pluton/images/Portfolio01.png" alt="project 1" />
          </div>
          <div class="span6">
              <div class="project-description">
                  <div class="project-title clearfix">
                      <h3>Webste for Some Client</h3>
                      <span class="show_hide close">
                          <i class="icon-cancel"></i>
                      </span>
                  </div>
                  <div class="project-info">
                      <div>
                          <span>Client</span>Some Client Name</div>
                      <div>
                          <span>Date</span>July 2013</div>
                      <div>
                          <span>Skills</span>HTML5, CSS3, JavaScript</div>
                      <div>
                          <span>Link</span>http://examplecomp.com</div>
                  </div>
                  <p>Believe in yourself! Have faith in your abilities! Without a humble but reasonable confidence in your own powers you cannot be successful or happy.</p>
              </div>
          </div>
      </div>
   
<!--         <div class="container" ng-controller="TrackController">
  			  <ul id="portfolio-grid" class="thumbnails row">
  			<li ng-repeat="track in tracks" class="span4 mix identity">
                        <div class="thumbnail">
                            <img src="{{ track.images[1].url }}">
                            <a href="#single-project" class="show_hide more" rel="#slidingDiv8">
                                <i class="icon-plus"></i>
                            </a>
                            <a href="http://localhost:8080/booksandmusicstack/user/track/{{ track.id }}" class="show_hide more">
                                <i class="icon-plus"></i>
                            </a>
                            <h3>{{ track.name }}</h3>
                            <div class="mask"></div>
                        </div>
                    </li>
              </ul> 
  			</div> -->
  			
  		</div>
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