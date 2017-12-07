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
 <center><h2>Supplier List</h2></center>
 <h2 style="color: red;">${status}</h2>
 <div class="table-responsive">          
  <table class="table table-bordered">
    <thead>
    <tr>
    <th>Supplier ID</th>
	<th>Supplier Name</th>
	<th>Supplier Address</th>
	<th>Operation</th>
	</tr>
	</thead>
    <tbody>
    <c:forEach items="${supplierList}" var="supplier">
    <tr>
		<td>${supplier.splrId}</td>
		<td>${supplier.splrName}</td>
		<td>${supplier.splrAddress}</td>
		<td>
			<a href="<c:url value="deleteSupplier/${supplier.splrId}"/>">DELETE</a>/
			<a href="<c:url value="updateS?splrId=${supplier.splrId}"/>">UPDATE</a>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>