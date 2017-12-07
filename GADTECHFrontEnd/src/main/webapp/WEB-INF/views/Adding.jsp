<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
body
{
    background: url('${pageContext.request.contextPath}/resources/windows-central-background.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
   
} 


</style>
<jsp:include page="Header.jsp"></jsp:include>
<body>
<div class="container">
<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#category">Category</a></li>
  <li><a data-toggle="tab" href="#supplier">Supplier</a></li>
  <li><a data-toggle="tab" href="#product">Product</a></li>
  <li><a data-toggle="tab" href="#update">Update</a></li>
</ul>

<div class="tab-content">



  <div id="category" class="tab-pane fade in active">
    <form method="post" action="AddCategory" >
    <h3 class="input-title"><font color="white">Category Name</font></h3>
    <input class="form-control" type="text" name="catgName" required/>
    <h3 class="input-title"><font color="white">Category Description</font></h3>
    <input class="form-control" type="text" name="catgDescrip" required/>
    <br>
    <br>
    <center>
    <button class="btn btn-lg btn-primary" type="submit">Save</button>
    <button class="btn btn-lg btn-primary" type="reset">Cancel</button>
    </center>
    </form>
  </div>
  
  
  
  <div id="supplier" class="tab-pane fade">
  <form method="post" action="AddSupplier">
  <h3 class="input-title"><font color="white">Supplier Name</font></h3>
  <input class="form-control" type="text" name="splrName" required/>
  <h3 class="input-title"><font color="white">Supplier Address</font></h3>
  <input class="form-control" type="text" name="splrAdd" required/>
  <br><br>
  <center>
    <button class="btn btn-lg btn-primary" type="submit">Save</button>
    <button class="btn btn-lg btn-primary" type="reset">Cancel</button>
    </center>
  </form>
  </div>
  
  
  
  
  <div id="product" class="tab-pane fade">
  <form method="post" action="InsertProduct" enctype="multipart/form-data" >
  <h3 class="input-title"><font color="white">Product Name</font></h3>
  <input class="form-control" type="text" name="productName" required/>
  <h3 class="input-title"><font color="white">Product Description</font></h3>
  <input class="form-control" type="text" name="productDesc" required/>
  <h3 class="input-title"><font color="white">Product Stock</font></h3>
  <input class="form-control" type="number" name="stock" required/>
  <h3 class="input-title"><font color="white">Product Price</font></h3>
  <input class="form-control" type="number" name="price" required/>
    
<div class="form-group">
    <h4><font color="white">Select Category</font></h4><br>
    <select class="form-control" name="cat" required>
    <option value="">------SELECT----------</option>
    <c:forEach items="${categoryList}" var="category">
    <option value="${category.catgId}">${category.catgName}</option>
    </c:forEach>
    </select>
</div>

<div class="form-group">
    <h4><font color="white">Select Supplier</font></h4><br>
    <select class="form-control" name="sup" required>
    <option value="">------SELECT-----------</option>
    <c:forEach items="${supplierList}" var="supplier">
    <option value="${supplier.splrId}">${supplier.splrName}</option></c:forEach>
    </select>
</div>
<br><br>

<div class="fileinput fileinput-new" data provides="fileinput">
    <tr>
    <td><font color="white">Image File</font></td>
    <td><input class="form-control" type="file" name="pimage" accept="image/*"></td>
    </tr>
</div>
<br>
<br>

   <center>
    <button class="btn btn-lg btn-primary" type="submit">Save</button>
    <button class="btn btn-lg btn-primary" type="reset">Cancel</button>
    </center>
</form>
  </div>
   <div id="update" class="tab-pane fade">
     <a href="category?status="><font color="black"><h4>Category List</h4></font></a><br/>
     <a href="supplier?status="><font color="black"><h4>Supplier List</h4></font></a><br/>
     <a href="product?status="><font color="black"><h4>Product List</h4></font></a><br/>
   
  </div>
  
</div>
</div>

<br><br><br>
<br><br><br><br>
<br>
<br><br><br>
<br><br><br><br><br><br>
<br><br>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>