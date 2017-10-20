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
<form action="AddCategory" method="post">
<table cellspacing="2" align="center">
<tr>
     <td colspan="2">Category Module</td>
</tr>
<tr>
     <td>Category ID</td>
     <td><input name="catgId"/></td>
</tr>
<tr>
     <td>Category Name</td>
     <td><input name="catgName"/></td>
</tr>
<tr>
     <td>Category Description</td>
     <td><input name="catgDescrip"/></td>
</tr>
<tr>
	 <td colspan="2">
	 <center><input type="submit" value="Insert"/></center>
	 </td>
</tr>
</table>
</form>

<table cellspacing="2" align="center">
<tr bgcolor="gray">
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Category Description</td>
	<td>Operation</td>
</tr>
<c:forEach items="${categoryList}" var="category">
	<tr bgcolor="cyan">
		<td>${category.catgId}</td>
		<td>${category.catgName}</td>
		<td>${category.catgDescrip}</td>
		<td>
			<a href="<c:url value="deleteCategory/${category.catgId}"/>">DELETE</a>/
			<a href="<c:url value="updateCategory/${category.catgId}"/>">UPDATE</a>
		</td>
	</tr>
</c:forEach>

</table>
</body>
</html>