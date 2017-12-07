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
      <a class="navbar-brand" href="./">GADTECH</a>
    </div>
    <ul class="nav navbar-nav">
     
       <c:if test="${pageContext.request.userPrincipal.name  != 'amalslm533@gmail.com'}">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">All Category
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
         <c:forEach items="${categoryList}" var="category">
          <li><a href="productList?cid=${category.catgId}">${category.catgName}</a></li>
         </c:forEach>
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
  <c:if test="${pageContext.request.userPrincipal.name != null && pageContext.request.userPrincipal.name  != 'amalslm533@gmail.com'}">
            <li>       
              <a href="Cart?status=">Cart <i class="fa fa-shopping-cart" ></i></a> 
            </li> 
            </c:if>
</li> 
  </ul>
     
    </ul>
  </div>
</nav>

</body>
</html>	
	
