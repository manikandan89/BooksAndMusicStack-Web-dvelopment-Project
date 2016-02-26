<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Registration</title>
    
    </head>
    <body>
    
    <div class="container">
    	<div class="row">
    		<div class="col-md-4">
    		</div>
    		
    		<div class="col-md-4">
    				 <h3>Enter details to Register</h3>
    				 <br>
    	 <form:form method="POST" action="http://booksandmusicstack-mani89.rhcloud.com/register" modelAttribute="user">
    	 <table cellspacing=10 cellpadding=10>
                <tr class="row">
                    <td class="col-md-4"><form:label path="username">Username</form:label></td>
                    <td class="col-md-8"><form:input path="username"/></td>
                </tr>
                <tr class="row">
                    <td class="col-md-4"><form:label path="password">Password</form:label></td>
                    <td class="col-md-8"><form:password path="password"/></td>
                </tr>
                <tr class="row">
                    <td class="col-md-4"><form:label path="email">Email</form:label></td>
                    <td class="col-md-8"><form:input path="email"/></td>
                </tr>
                <tr class="row">
                    <td class="col-md-12"><input class="btn btn-primary btn-block" type="submit" value="Submit"/></td>
                </tr>
            </table>
           </form:form>
    		
    		</div>
    		
    		<div class="col-md-4">
    		</div>
    		
    	</div>
    	
    
    </div>
       
       <%--  <form:form method="POST" action="http://localhost:8080/booksandmusicstack/register" modelAttribute="user">
             <table>
                <tr>
                    <td><form:label path="username">Username</form:label></td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:password path="password"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form> --%>
    </body>
</html>
