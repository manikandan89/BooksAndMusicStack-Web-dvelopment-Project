<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/bootstrap.css" />
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
          
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/user.js"></script>
           
             <style>
           	#footer {
					background:#000000;
					width:100%;
					height:30px;
					position:absolute;
					bottom:0;
					text-align:center;
				}
           </style>
      
    </head>
<body >

	<div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">
                    
                    </a>
                    <!-- Navigation button, visible on small resolution -->
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <i class="icon-menu"></i>
                    </button>
                  
                    
                        <div class="nav-collapse collapse pull-right">
                        <ul class="nav">
                        	<li class="active"><a href="<%=request.getContextPath()%>/user/">Home</a></li>
                         
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
        
	<div >
			 <!-- <h1>MUSIC AND BOOKS STACK</h1>
			  <h1>MUSIC AND BOOKS STACK</h1>
			   <h1>MUSIC AND BOOKS STACK</h1> -->
			  <!--  <div class="section secondary-section " > -->
  					 <div id="da-slider" class="da-slider">
            
                <div class="triangle"></div>
                <!-- mask elemet use for masking background image -->
                <div class="mask"></div>
                <!-- All slides centred in container element -->
                <div class="container">
                    <!-- Start first slide -->
                    <div class="da-slide">
                        <h2 class="fittext2"></h2>
                        <h2>Music</h2>
                        <!-- <p>Music is an art form whose medium is sound. Music is composed and performed for many purposes, ranging from aesthetic pleasure, religious or ceremonial purposes, or as an entertainment product for the marketplace.</p> -->
                       <p>
Music is not just an ordered sequence of sounds. Music is something that is beyond and within our minds. Music is one of the few things that has remained constant through the centuries this world has existed. </p>
                        <div class="da-img">
                            <img src="<%=request.getContextPath()%>/resources/lib/mani/images/bieber.jpg" alt="image01" width="320">
                        </div>
                    </div>
                    <!-- End first slide -->
                    <!-- Start second slide -->
                    <div class="da-slide">
                        <h2>Books</h2>
                       <!--  <h4>Easy to use</h4> -->
                        <p>Book is a set of written, printed, illustrated, or blank sheets, usually fastened together to hinge at one side. A set of text-filled or illustrated pages produced in electronic format is known as an electronic book, or e-book.</p>
                        
                        <div class="da-img">
                            <img src="<%=request.getContextPath()%>/resources/lib/mani/images/the-alchemist.jpg" width="320" alt="image02">
                        </div>
                    </div>
                    <!-- End second slide -->
                    <!-- Start third slide -->  <div class="da-slide">
                        <h2 class="fittext2"></h2>
                        <h2>Emotions</h2>
                        <!-- <p>Music is an art form whose medium is sound. Music is composed and performed for many purposes, ranging from aesthetic pleasure, religious or ceremonial purposes, or as an entertainment product for the marketplace.</p> -->
                       <p>
Emotions are easily affected by outside forces. Music can provoke emotions of sadness, grief, joy, and even ecstasy. There are several different aspects of music that change how a song is interpreted. From these interpretations come emotions.</p>
                        <div class="da-img">
                            <img src="<%=request.getContextPath()%>/resources/lib/mani/images/rsz_emotion_home.jpg" alt="image01" width="320">
                        </div>
                    </div>
                    
                    
                    
                    <div class="da-slide">
                       
                        <h2>Recommendation System</h2>
                        <p>Recommendation systems are an important part of the information and e-commerce ecosystem. They represent a powerful method for enabling users to filter through large information and product spaces.</p>
                        
                        <div class="da-img">
                            <img src="<%=request.getContextPath()%>/resources/lib/mani/images/rsz_recommend_2.jpg" width="320" alt="image03">
                        </div>
                    </div>
                    <!-- Start third slide -->
                    <!-- Start cSlide navigation arrows -->
                   
                    
                    <div class="da-arrows">
                        <span class="da-arrows-prev"></span>
                        <span class="da-arrows-next"></span>
                    </div>
                    <!-- End cSlide navigation arrows -->
                </div>
            <!-- </div> -->
        </div>
			   
       
        
        
            <!-- Footer section start -->
   <div id="footer">
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