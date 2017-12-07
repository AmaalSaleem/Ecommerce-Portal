<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
<div class="container">
 <center><h2>Category List</h2></center>
 <h2 style="color: red;">${status}</h2>
 <table class="table table-bordered">
    <thead>
    <tr>
    <th>Category ID</th>
	<th>Category Name</th>
	<th>Category Description</th>
	<th>Operation</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${categoryList}" var="category">
	<tr>
		<td>${category.catgId}</td>
		<td>${category.catgName}</td>
		<td>${category.catgDescrip}</td>
		<td>
			<a href="<c:url value="deleteCategory/${category.catgId}"/>">DELETE</a>/
			<a href="<c:url value="updateC?catgId=${category.catgId}"/>">UPDATE</a>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>