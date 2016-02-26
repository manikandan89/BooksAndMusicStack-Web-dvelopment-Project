
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
    
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Documentation</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/bootstrap.css" />
        <%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.min.css" /> --%>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/mani/css/style_document.css" />
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
           <script type="text/javascript" src="<%=request.getContextPath()%>/resources/lib/js/favouriteTrack.js"></script>
           
           <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.1/css/foundation.css"/> -->
           
            <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
  <script>
  $(function() {
    $( "#accordion" ).accordion({heightStyle: "content"});
  });
  </script>
           
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

           </style>
           
      
    </head>
    
    <body ng-app="favouriteTrackApp">
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
                             <li class="active">
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
  
  
<div class="section secondary-section ">
  
    <div class="triangle"></div>
    <div class="container">
    	
    	 <br />
        <h2> Project demo </h2>
        <iframe width="420" height="315"
src="http://www.youtube.com/embed/FLFRQldqOH0?autoplay=0">
</iframe>
        <br />

        <h2>Documentation</h2>

        <br />

        <div id="accordion">
            <h3><b><i>Project Overview</i></b></h3>
            <div>
                <p>
                    <strong>BooksAndMusicStack</strong> is a system that helps users to play tarcks in any music album, read a book overview based on title or the user's current emotion. This is a recommendation system through which one user can make friends with other users and recommend their favourite albums and tracks to their friends.
                </p>
                <p>
                    &nbsp;
                </p>
            </div>
            <h3><b><i>Design Features</i></b></h3>
               <div>
                <p>
                    The standards and practices followed while working on this project:
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Fully Responsive - Can be viewed across mobile, tablet, and desktops.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Separate files for JavaScript and Style Sheets.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Proper error handling.
                </p>
                </div>

               
               <h3><b><i>Functional features</i></b></h3>
               <div>
                <p>
                    The main features are:
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; User can create a login and maintain a profile.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; BooksAndMusicStack helps users to search for music albums and play its corresponding tracks.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Users can search for a book and read its overview.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Fetches music tracks and books according to the current emotion of the user.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Users can add any music album or tracks to be in their favourite list.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; This is a social networking site in which one user can make friends with another user.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Friends can recommend music albums and tracks between them.&nbsp;
                </p>
            </div>
            <h3><b><i>Acknowledgement</i></b></h3>
            <div>
                <p>
                    CS5610 Web Development course - The very structure of the course motivates learning. The structure of doing experiments weekly gives freedom to explore unlearned areas and develop expertise in those areas. I would like to this opportunity to thank <strong>Prof. Jose Annunziato</strong> and <strong>Prof. Richard Rasala</strong> for designing the course in this fashion.
                </p>
                <p>
                    &nbsp;
                </p>
                <p>
                    I would also like to thank my TA, <strong>Rishi Katiyal</strong> for his constructive and valuable weekly feedback which helped me realize the mistakes and correct them.
                </p>
                <p>
                    &nbsp;
                </p>
                <p>
                    I would like to thank <strong>Spotify</strong> and <strong>Goodreads</strong> for providing APIs which helped me get useful data to develop the website.
                </p>
            </div>

             <h3><b><i>Login Page</i></b></h3>
            <div>
                <p>
                  Navigation Bar - I have used the Bootstrap navigation bar to navigate across the website. The Navigation Bar provides a good look and feel to the website.

                </p>

                 <p>
                 I have used Spring Security for secure access to the website.

                </p>
               
            </div>

             <h3><b><i>Register Page</i></b></h3>
            <div>
                <p>
                Guests can register for this website and become registered users to enjoy the privileges of the website.

                </p>

                
            </div>

                  <h3><b><i>User Home Page</i></b></h3>
            <div>
                <p>
                Carousel displaying the different features within the website.

                </p>

                
            </div>
            

            <h3><b><i>Music</i></b></h3>
            <div>
                <p>
             This page can be navigated to by clicking on the 'Music' button in the Navigation Bar.

                </p>

                 <p>
             The latest albums that are trending gets populated.
                </p>
                  <p>
             Also a search bar which has the autocomplete feature populates the list of albums as the user types.
The user selects an album to view the tracks.
                </p>

                <p>
                    <strong><em>How does the page work?</em></strong>
                </p>
                 <p>
            The user enters the album he/she wants to search for.
                </p>

                 <p>
               On click of 'Search', the AngularJS function is called
                </p>

                 <p>
            The API page is called, which in turns calls the Spotify API
                </p>

                 <p>
               The Spotify API returns JSON data
                </p>

                  <p>
              This data is passed back to the AngularJS function.
                </p>
               
                 <p>
              This JSON data is iterated by AngularJS.
                </p>
               
            </div>


            <h3><b><i>Tracks</i></b></h3>
            <div>
                <p>
             This page gets loaded when the user selects any album.

                </p>

                 <p>
              The user can click on any track to play it.
                </p>
                <p>
                    <strong><em>How does the page work?</em></strong>
                </p>
                 <p>
             The API page is called on load, which in turns calls the Spotify API
                </p>

                 <p>
               The Spotify API returns JSON data
                </p>

                 <p>
            This data is passed back to the AngularJS function
                </p>

                 <p>
               This JSON data is iterated by AngularJS
                </p>
               
            </div>


            <h3><b><i>Books</i></b></h3>
            <div>
                <p>
             This page can be navigated to by clicking on the 'Books' button in the Navigation Bar.
                </p>

                 <p>
                A search bar which has the autocomplete feature populates the list of book as the user types.
The user selects a book to view the overview.

                </p>
                <p>
                    <strong><em>How does the page work?</em></strong>
                </p>
                 <p>
             The user enters the title he/she wants to search for.
                </p>

                 <p>
               The API page is called, which in turns calls the Goodreads API
                </p>

                 <p>
             The Goodreads API returns XML data
                </p>

                 <p>
               The XML data is converted to JSON
                </p>

                 <p>
                This JSON data is iterated by AngularJS
                </p>
               
            </div>

              <h3><b><i>Emotions</i></b></h3>
            <div>
                <p>
              This page can be navigated to by clicking on the 'Emotion' button in the Navigation Bar.
                </p>

                 <p>
                A dialog box pops up to get the user's current emotion.

                </p>

                 <p>
              The user can choose his/her current emotion.
                </p>

                 <p>
                The books and music according to the user's current emotional state are populated.
                </p>

                 <p>
              The user selects the current emotional state
                </p>

                 <p>
                 The API page is called, which in turns calls the Goodreads API and Spotify API
                </p>

                 <p>
                The data is parsed and displayed
                </p>
               
            </div>

             <h3><b><i>Favourites</i></b></h3>
            <div>
                <p>
               Users can view their favourite albums and tracks.
                </p>

                 <p>
                 When the user clicks on the favorite album/track, the track is played.
                </p>
               
            </div>

            <h3><b><i>Friends</i></b></h3>
            <div>
                <p>
                  Users can make friends with one another.

                </p>

                 <p>
                 Friends can recommend albums and tracks to each other.

                </p>
               
            </div>

            <h3><b><i>Recommendations</i></b></h3>
            <div>
                <p>
                   The user can view the albums and tracks that have been recommended to them.
                    By clicking on it, th track gets played.

                </p>
               
            </div>

            <h3><b><i>Technologies / Browsers</i></b></h3>
            <div>
                <p>
                    In this project, I have used the following technologies:
                </p>
                <p>
                    &nbsp;
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Spring MVC and Spring Security
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; HTML5
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CSS3
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; AngularJS
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; JavaScript
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Jquery
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; AJAX
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SQL
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; XML
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; JSON
                </p>
                <p>
                    &nbsp;
                </p>
                <p>
                    <strong><em>Browser Compatibility:</em></strong>
                </p>
                <p>
                    The website renders perfectly on Google Chrome and Mozilla Firefox. But there might be some issues with the site rendered on Internet Explorer.
                </p>
            </div>

            <h3><b><i>Future Scope</i></b></h3>
            <div>
                <p>
                    During the course of working on this website, I have learnt many new technologies. I would like to add more to this project in the future. Some of the ideas that I have in my mind:
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The recommendation system can be extended to Books.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Users can purchase albums and books.
                </p>
                 <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Users can post feedback about albums and books.

                </p>
                 <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Each users can have a wall. Friends can post on each others wall and have private conversations.
                </p>

            </div>

            <h3><b><i>References / Images</i></b></h3>
            <div>
                <p>
                    <strong>Websites</strong>
                </p>
                <p>
                    http://www.w3schools.com/
                </p>
                <p>
                    https://angularjs.org/
                </p>
                <p>
                    http://getbootstrap.com/
                </p>
                <p>
                    http://stackoverflow.com/
                </p>
                <p>
                    http://projects.spring.io/spring-framework/
                </p>
                <p>
                    &nbsp;
                </p>
                <p>
                    <strong>Images</strong>
                </p>
                <p>
                    All the images obtained from Spotify and Goodreads through the API calls, belong to the respective corporations.
                </p>
            </div>
            <h3><b><i>Sample Use Case</i></b></h3>
            <div>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Create an account.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Login with the user credentials.&quot;
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Click on the emotions tab.

                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Select the current emotional state from the dialog box drop down.
                </p>
                <p>
                    &middot;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sit back and enjoy the musical track corresponding to your emotional state.

                </p>
                
            </div>
        </div>
    </div>
  			
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