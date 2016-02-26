
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
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/style_emotion.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/mani.css" />
     
     
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/jquery.cslider.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/jquery.bxslider.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/animate.css" />
        
        <!-- Dialog -->
        
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/dialog/demo.css" />
		<!-- common styles -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/dialog/dialog.css" />
		<!-- individual effect -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/dialog/dialog-val.css" />
        
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
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/emotion.js"></script>
		
		<!-- dialog -->
		<script src="<%=request.getContextPath()%>/resources/lib/js/dialog/modernizr.custom.js"></script>
		<style>
				body {
    			background : url("<%=request.getContextPath()%>/resources/lib/images/emotion_page_bg.jpg");
		}
		</style>

      
    </head>
    
    <body ng-app="emotionApp">
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
                            <li class="active">
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

	<%-- <div class="container" ng-controller="EmotionController">
			<div class="content">
				<header class="codrops-header">					
					<div class="button-wrap"><button data-dialog="somedialog" class="trigger">Open Dialog</button></div>
				</header>
				
				<div id="somedialog" class="dialog">
					<div class="dialog__overlay"></div>
					<div class="dialog__content">
						<select ng-model="selectedColor" ng-options="color as color.name for color in colors" ng-init="selectedColor = check(selected,colors)" ng-change="setColor(selectedColor)">
                				<option value="">Select A Color</option>
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
  --%>
 
 <div class="section secondary-section " id="portfolio">
  
    <div class="triangle"></div>
    
   <!--  <div class="container" >
	</div> -->
	
	<br />
	<br />
	<br />
	<br />
	<br />

	
	
	<div class="container" ng-controller="EmotionController">
			<div class="content">
				<header class="codrops-header">					
					<div class="button-wrap"><button data-dialog="somedialog" class="trigger">GO  BY  YOUR  EMOTIONS</button></div>
				</header>
				
				<div id="somedialog" class="dialog">
					<div class="dialog__overlay"></div>
					<div class="dialog__content">
						<select ng-model="selectedEmotion" ng-options="emotion as emotion.name for emotion in emotions" ng-init="selectedEmotion = check(selected,emotions)" ng-change="setEmotion(selectedEmotion)">
                				<option value="">Select Your Emotion</option>
					     </select>
					     <br />
					     <br />
			           
						<h2><strong>Hey</strong>, Choose your current emotion</h2> <div><button class="action" data-dialog-close>Close</button></div> 
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
 
	
 </div>
 
        <!-- Footer section start -->
        <!--<div class="footer">
            <p>&copy; 2013 All Rights Reserved</p>
        </div>
        Footer section end
        ScrollUp button start
        <div class="scrollup">
            <a href="#">
                <i class="icon-up-open"></i>
            </a>
        </div> -->

        
    </body>
    </html>