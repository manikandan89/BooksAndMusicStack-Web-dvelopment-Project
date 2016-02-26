
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
    
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Books</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/bootstrap.css" />
        <%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.min.css" /> --%>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/style_book.css" />
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
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/ui-bootstrap-tpls-0.12.1.js"></script>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/bookSearchResults.js"></script>
      
    </head>
    
    <body ng-app="bookSearchResultsApp">
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
    	
    <div class="container" ng-controller="BookSearchResultsController">
   
	
     <!--    <div class="container" ng-controller="BookSearchResultsController">
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
  			
  			<input type="hidden" id="bookidval" name="bookidval" value="${bookId}" />
  			
  		 	<div id="slidingDiv1" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="{{ book.imageUrl }}" alt="project 3">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>{{ book.title }}</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Author<b> :</b></span><font color="white">{{ book.authors.authors[0].name }}</font></div>
                                    <div>
                                        <span>Publisher<b>:</b></span><font color="white">{{ book.publisher }}</font></div>
                                    <div>
                                        <span>Year<b> :</b></span><font color="white">{{ book.publishedYear }}</font></div>
                                    <div>
                                        <span>Isbn<b> :</b></span><font color="white">{{ book.isbn }}</font></div>
                                </div>
                                <font color="white">{{ book.description }}</font>
                            </div>
                        </div>
                    </div> 
                    
              <br />
  			 <h3>Similar books</h3>
                    
            <div class="container">
  			  <ul id="portfolio-grid" class="thumbnails row">
  			<li ng-repeat="similarBook in book.similarBooks.similarBooks" class="span4 mix identity">
                        <div class="thumbnail">
                            <img src="{{ similarBook.imageUrl }}" alt="project 9">
                            <a href="<%=request.getContextPath()%>/user/book/{{ similarBook.id }}" class="show_hide more">
                                <i class="icon-plus"></i>
                            </a>
                            <h3>{{ similarBook.title }}</h3>
                            <div class="mask"></div>
                        </div>
                    </li>
              </ul> 
  			</div> 
  			 
  			
  		</div>
  	</div>
 
        <!-- Footer section start -->
        <div class="footer">
            <p>&copy; 2015 Spring Web Development Project  |  by Manikandan</p>
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