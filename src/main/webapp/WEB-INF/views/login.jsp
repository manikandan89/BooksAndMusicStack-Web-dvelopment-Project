<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.css" rel="stylesheet"/>
<link href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/lib/css/login.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/lib/js/jquery-1.11.1.js"></script>
<script src="<%=request.getContextPath()%>/resources/lib/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/lib/js/angular.js"></script>
<script src="<%=request.getContextPath()%>/resources/lib/js/login.js"></script>
<title>Login Form</title>
</head>
<body>
 
 
 

  
  <div class="container">
  
  <br/>
  
  	<div class="row">
  		<div class="col-md-2">
  			
  		</div>
  		<div class="col-md-8">
  			<h1>Books and Music Stack</h1>
  		</div>
  		<div class="col-md-2">
  			
  		</div>
  	</div>
  
  	<div class="row" style="margin-top: 10%">
  		<div class="col-md-8" class="img" style="margin-top: 30px">

				<div id="slideshow">
					<div id="slideshowWindow">
						
						<div class="slide">
							<img src="<%=request.getContextPath()%>/resources/lib/images/rsz_booksandmusic.jpg" class="image" />
						</div>
						
						<div class="slide">
							<img src="<%=request.getContextPath()%>/resources/lib/images/rsz_1spotify.jpg" class="image" />
						</div>
						
						<div class="slide">
							<img src="<%=request.getContextPath()%>/resources/lib/images/rsz_goodreads.jpg" class="image" />
						</div>

					</div>
				</div>
  		</div>
  		<div class="col-md-4" name="login">
  		
  		<h1>Login</h1>
		<form action="j_spring_security_check" method="post">
			<div class="row">
			<div class="col-md-12">
			Username:
			<input type="text" name="username" class="form-control" placeholder="Username" style="width:200px;height:50px;"/>
			</div>
			</div>
			<br/>
			<div class="row">
			<div class="col-md-12">
			Password:
			<input name="password" type="password"  class="form-control" style="width:200px;height:50px;"/>
			</div>
			</div>
			<br/>
			<div class="row">
			<div class="col-md-12">
			<button class="btn btn-primary btn-block" style="width:200px;height:50px;">Login</button>
			</div>
			</div>
		</form>	
		<br/>
		<div class="row">
		<div class="col-md-12">
		 <a href="<%=request.getContextPath()%>/register">SignUp</a> 
  		</div>
		</div>
  		</div>
  	</div>
  	
  	</div>

	
	</div>
</body>
</html>
