
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
    
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Recommend Album</title>
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
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/albumRecommendation.js"></script>
           
             <style>
           
           html{
           	position:relative;
           	min-height: 100%;
           }
		        #footer {
		   position:absolute;
		   bottom:0px;
		   width:100%;
		   height:30px;   
		   background:#000000;
		   text-align:center;
				}
		  .info_hide{
		  visibility:hidden;
		  }
           </style>
      
    </head>
    
    <body ng-app="ui.bootstrap.AlbumRecommendation">
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
                            <li>
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
   
 <p id="hiddenelement" value="${albumId}" hidden></p>
   <input type="hidden" id="albumidval" name="albumidval" value="${albumId}" />
 
<!--   <h1 id="info_box" class="info_hide">
  Recommendation Sent to Friend
 </h1>  -->  
 
<div class="section secondary-section " id="portfolio">
  
    <div class="triangle"></div>
    <div class="container">
    	<br />
    	<br />
    	
    	<br /> <br /> <br />
    	
    	<h1>
		Album Recommendations
		</h1>
		<br />
		<br />
    	
    	<div class='container-fluid' ng-controller="AlbumRecommendationController">
        
           <input type="text" ng-model="asyncSelected.userId" placeholder="Search friends" typeahead="address.label for address in getLocation($viewValue)" typeahead-loading="loadingLocations" class="form-control">
       
            <form>
           <button ng-click="recommendAlbum(asyncSelected)" class="btn btn-primary">Recommend album</button>
           </form>
           
       </div>
   
   
   <br />
   <br />
       
  			
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