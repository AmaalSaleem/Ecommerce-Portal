<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="Header.jsp"></jsp:include>
<body>
<form action="updateSupplier" method="post">
<table cellspacing="2" align="center">
<tr>
<center> <td colspan="2">Supplier Module</td></center>
   
</tr>
<tr>
     <td>Supplier ID</td>
     <td><input name="splrId"  value="${sup.splrId }" /></td>
</tr>
<tr>
     <td>Supplier Name</td>
     <td><input name="splrName" value="${sup.splrName }"/></td>
</tr>
<tr>
     <td>Supplier Address Description</td>
     <td><input name="splrAdd" value="${sup.splrAddress }"/></td>
</tr>
<tr>
	 <td colspan="2">
	 <center><input type="submit" value="Update"/></center>
	 </td>
</tr>
</table>
</form>
</body>
</html>