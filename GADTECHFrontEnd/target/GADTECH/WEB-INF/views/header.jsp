<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">GADTECH</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
       <c:if test="${pageContext.request.userPrincipal.name  != 'amalslm533@gmail.com'}">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category List
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li></c:if>
      
                         <c:if test="${pageContext.request.userPrincipal.name  == 'amalslm533@gmail.com'}">
                        <li><a href="adding">Admin Task</a></li>
                        
                        </c:if>
                        </ul>
                        
                        
 <ul class="nav navbar-nav navbar-right">
 <li>  
 <c:if test="${pageContext.request.userPrincipal.name == null }">
 <a href="register">Register</a>  
 </c:if>
 </li>  
            <li>  
            <c:if test="${pageContext.request.userPrincipal.name == null }">
                <a href="login">Login</a>
            </c:if>    
            </li> 
 <li>  
 <c:if test="${pageContext.request.userPrincipal.name  != null}">
<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
<div class="nav navbar-nav navbar-right">
<li><a href='<c:url value="/j_spring_security_logout"/>'>Logout</a></li></div>
</c:if>
</li> 
  </ul>
     
    </ul>
  </div>
</nav>

</body>
</html>	
	
