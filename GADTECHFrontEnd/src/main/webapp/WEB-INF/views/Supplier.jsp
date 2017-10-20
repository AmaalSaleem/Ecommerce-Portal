<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddSupplier" method="post">
<table cellspacing="2" align="center">
<tr>
<center> <td colspan="2">Supplier Module</td></center>
   
</tr>
<tr>
     <td>Supplier ID</td>
     <td><input name="splrId"/></td>
</tr>
<tr>
     <td>Supplier Name</td>
     <td><input name="splrName"/></td>
</tr>
<tr>
     <td>Supplier Address Description</td>
     <td><input name="splrAdd"/></td>
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
	<td>Supplier ID</td>
	<td>Supplier Name</td>
	<td>Supplier Address</td>
	<td>Operation</td>
</tr>
<c:forEach items="${supplierList}" var="supplier">
	<tr bgcolor="cyan">
		<td>${supplier.splrId}</td>
		<td>${supplier.splrName}</td>
		<td>${supplier.splrAddress}</td>
		<td>
			<a href="<c:url value="deleteCategory/${supplier.splrId}"/>">DELETE</a>/
			<a href="<c:url value="updateCategory/${supplier.splrId}"/>">UPDATE</a>
		</td>
	</tr>
</c:forEach>

</table>
</body>
</html>