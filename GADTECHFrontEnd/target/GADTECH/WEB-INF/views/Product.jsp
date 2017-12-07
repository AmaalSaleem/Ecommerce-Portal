<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
<div class="container">
<center><h2>Product List</h2></center>
<h2 style="color: red;">${status}</h2>
<div class="table-responsive">          
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Stock</th>
        <th>Price</th>
        <th>Product Image</th>
        <th>Supplier Name</th>
        <th>Category Name</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${productList}" var="product">
	<tr>
		<td>${product.productId}</td>
		<td>${product.productName}</td>
		<td>${product.productDesc}</td>
		<td>${product.stock}</td>
		<td>${product.price}</td>
		<td>
		<center>
		<img src="<c:url value="/resources/${product.productId}.jpg"/>" width="70px" height="50px"/>
		</center>
		
		</td>
		<td>${product.supplier.splrName}</td>
		<td>${product.category.catgName}</td>
		<td>
			<a href="<c:url value="deleteProduct/${product.productId}"/>">DELETE</a>/
			<a href="<c:url value="updateP?productId=${product.productId}"/>">UPDATE</a>
		</td>
	</tr>
	 </c:forEach>
    </tbody>
  </table>
  </div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>