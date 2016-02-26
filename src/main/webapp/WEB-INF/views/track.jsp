
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
        
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/mani/js/app_book.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/angular.js"></script>
         <%-- <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/ui-bootstrap-tpls-0.12.1.js"></script> --%>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/angular-route.min.js"></script>           
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/track.js"></script>
      
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
    
    <body ng-app="trackApp">
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



<div class="section secondary-section " id="portfolio">
  
    <div class="triangle"></div>
    <div class="container" ng-controller="TrackController">

   <p id="hiddenelement" value="${albumId}" hidden></p>
   <input type="hidden" id="styleidval" name="styleidval" value="${albumId}" />
   
   <h3>Album</h3>
   
   <br />
   <br />
   <div id="slidingDiv1" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{tracks[0].album.image}}" alt="project 3">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>{{tracks[0].album.albumName}}</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Artist<b> :</b></span><font color="white">{{ tracks[0].album.artist }}</font></div>
                                    <!-- <div>
                                        <span>Publisher</span>{{ book.publisher }}</div>
                                    <div>
                                        <span>Year</span>{{ book.publishedYear }}</div>
                                    <div>
                                        <span>Isbn</span>{{ book.isbn }}</div> -->  
                                     <button type="submit" style="margin-left: 10px; margin-top: 50px;" ng-click="insertFavouriteAlbum()" class=" btn btn-primary ">Favourite</button>  <!-- Adding track to insertFavouriteAlbum.. the album for the track will be done in the backend -->
                                     <button type="submit" style="margin-left: 10px; margin-top: 50px;" ng-click="recommendAlbum()" class="btn btn-success">Recommend</button> 
                                </div>
                                
                                
                            </div>
                        </div>
                    </div> 
   
   <br />
    <br />

   
  			 <h3>Tracks</h3>
	        <div class="container">
  			  <ul id="portfolio-grid" class="thumbnails row">
  			<li ng-repeat="track in tracks" class="span4 mix identity">
                        <div class="thumbnail">
                            <img src="{{track.album.image}}">
                            <a href="{{track.previewUrl}}" class="show_hide more">
                                <i class="icon-plus"></i>
                            </a>
                            <h3>{{ track.name }}</h3>
                           
                   <div class="mask"></div> 
                            
                        </div>
                        
   		
   			<button style="margin-left: 75px; " type="submit" ng-click="insertFavouriteTrack(track)" class="btn btn-primary">Favourite</button>
   			<button style="margin-left: 10px; " type="submit" ng-click="recommendTrack(track)" class="btn btn-success">Recommend</button>
                          
            
             
                    </li>
              </ul> 
  			</div>
  			
  		</div>
  	
  	
 <div ng-view></div>
  	
 </div>
        <!-- Footer section start -->
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