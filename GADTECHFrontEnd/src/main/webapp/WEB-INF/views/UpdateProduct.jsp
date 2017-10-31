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
<form action="updateProduct"  enctype="multipart/form-data" method="post">
<table align="center">


 <tr>
   <td colspan="2">Product Details</td>
 </tr>
 <tr>
     <td>Product ID</td>
     <td><input name="productId" value="${prod.productId }" readonly="readonly"/></td>
</tr>
 <tr>
   <td>Product Name</td>
   <td><input type="text" name="productName" value="${prod.productName }"/></td>
 </tr>  
 <tr>
   <td>Product Description</td>
   <td><input type="text" name="productDesc" value="${prod.productDesc }" /></td>
 </tr>  
 <tr>
   <td>Product Stock</td>
   <td><input type="number" name="stock" value="${prod.stock }"/></td>
 </tr>  
 <tr>
   <td>Product Price</td>
   <td><input type="number" name="price" value="${prod.price }"/></td>
 </tr>  
 <tr>
   <td>Category</td>
   <td>
   <select name="cat">
   
   <c:forEach items="${categoryList }" var="c">
       <option value="${c.catgId }">${c.catgName }</option>
   </c:forEach>
   
   
         
   </select>
   </td>
   
 </tr> 
 <tr>
   <td>Supplier</td>
   <td>
   <select name="sup">
   
   <c:forEach items="${supplierList }" var="s">
       <option value="${s.splrId }">${s.splrName }</option>
   </c:forEach>
   
   
         
   </select>
   </td>
 </tr> 
 <tr>
   <td>Product Image</td>
   <td><input type="file" name="pimage" value="${prod.pimage }"/></td>
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