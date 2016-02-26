
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
        
        <!-- Dialog -->
        
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/dialog/demo.css" />
		<!-- common styles -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/dialog/dialog.css" />
		<!-- individual effect -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/dialog/dialog-val.css" />
        
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
        
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/pluton/js/app_book.js"></script>
         <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/angular.js"></script>
         <%-- <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/ui-bootstrap-tpls-0.12.1.js"></script> --%>
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/angular-route.min.js"></script>           
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/mood.js"></script>
		
		<!-- dialog -->
		<script src="<%=request.getContextPath()%>/resources/lib/js/dialog/modernizr.custom.js"></script>
      
    </head>
    
    <body ng-app="emotionApp">
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
   
	
	<div class="container">
			<div class="content">
				<header class="codrops-header">					
					<div class="button-wrap"><button data-dialog="somedialog" class="trigger">Open Dialog</button></div>
				</header>
				
				<div id="somedialog" class="dialog">
					<div class="dialog__overlay"></div>
					<div class="dialog__content">
						<select>
						  <option value="chill">Chill</option>
						  <option value="fun">Fun</option>
						  <option value="religious">Religious</option>
						  <option value="classical">Classical</option>
						</select>
						<h2><strong>Howdy</strong>, Choose your current emotion</h2><div><button class="action" data-dialog-close>Close</button></div>
					</div>
				</div>				
		</div><!-- /container -->
		<script src="<%=request.getContextPath()%>/resources/lib/js/dialog/classie.js"></script>
		<script src="<%=request.getContextPath()%>/resources/lib/js/dialog/dialogFx.js"></script>
		<script>
			(function() {

				var dlgtrigger = document.querySelector( '[data-dialog]' ),
					somedialog = document.getElementById( dlgtrigger.getAttribute( 'data-dialog' ) ),
					dlg = new DialogFx( somedialog );

				dlgtrigger.addEventListener( 'click', dlg.toggle.bind(dlg) );
				

			})();
		</script>
		
		
	
  	
 </div>
 
 <div class="section secondary-section " id="portfolio">
  
    <div class="triangle"></div>
    <div class="container" ng-controller="EmotionController">

   <p id="hiddenelement" value="${albumId}" hidden></p>
   <input type="hidden" id="styleidval" name="styleidval" value="${albumId}" />
   
   <br /> <br />
   
   
   
   <br />
   <br />
  
        <div class="container">
  			  <ul id="portfolio-grid" class="thumbnails row">
  			<li ng-repeat="trackEmotionModel in trackEmotionModels" class="span4 mix identity">
                        <div class="thumbnail">
                            <img src="{{ trackEmotionModel.image }}">
                            <a href="{{ trackEmotionModel.previewUrl }}" class="show_hide more">
                                <i class="icon-plus"></i>
                            </a>
                            <h3>{{ trackEmotionModel.name }}</h3>
                           
                   <div class="mask"></div> 
                            
                        </div>
   		
   			<button type="submit" ng-click="insertFavouriteTrack(track)" class="btn btn-primary">
   			<button type="submit" ng-click="recommendTrack(track)" class="btn btn-success">
                          
            </button>
             
                    </li>
              </ul> 
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