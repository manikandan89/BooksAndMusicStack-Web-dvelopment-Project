<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Profile</title>
	<link href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.css" rel="stylesheet"/>
<link href="<%=request.getContextPath()%>/resources/lib/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/lib/js/jquery-1.11.1.js"></script>
<script src="<%=request.getContextPath()%>/resources/lib/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/lib/js/angular.js"></script>
</head>
<body>
<h1>
	Register here 
</h1>
<br />

<a href="<%=request.getContextPath()%>/user/profile/register/">SignUp</a>

<h1>
	Favorites
</h1>
<br />

<a href="<%=request.getContextPath()%>/user/profile/favourites/album">Favourites</a>

<br />

<h1>
People
</h1>
<br />

<a href="<%=request.getContextPath()%>/user/profile/people">People</a>

<br />

<h1>
Recommendations
</h1>
<br />

<a href="<%=request.getContextPath()%>/user/profile/recommendation/track">Recommendations</a>

</body>
</html>