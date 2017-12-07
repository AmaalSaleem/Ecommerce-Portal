<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>



<style type="text/css">



.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}



</style>



<body>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<jsp:include page="Header.jsp"></jsp:include>

<div class="container">
<h3 style="color: red;">${status }</h3>
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<c:if test="${empty cartInfo }">
					<tr><td colspan="7" align="center">No cart Items</td></tr>
					</c:if>
					<c:forEach var="c" varStatus="st" items="${cartInfo }"	>			
						<tr>
						<td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${pageContext.request.contextPath}/resources/${c.product.productId}.jpg" style="width: 90px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${c.product.productName }</a></h4>
                                <h5 class="media-heading"> by <a href="#">${c.product.supplier.splrName }</a></h5>
                               
                            </div>
                        </div></td>
							<td data-th="Price">${c.product.price}</td>
							
				
							<td class="col-sm-1 col-md-1" style="text-align: center">
                           <form action="updateCart" method="post">
                           <input type="hidden" name="cid" value="${c.cartID}"/>
                           <input type="number" class="form-control text-center" id="exampleInputEmail1" name="qty" value="${c.cartQnty}" min="1"><br/>
                           <button type="submit" class="btn btn-info btn-sm">
         					<span class="fa fa-refresh"></span>Refresh
       				       </button>
       				    	</form>
                        </td>
							
							
							 <td class="col-sm-1 col-md-1 text-center"><strong>${c.cartQnty*c.product.price}</strong></td>
							<td data-th="Subtotal" class="text-center"></td>
							
                        <td><a href="deleteCart/${c.cartID}" class="btn btn-lg btn-danger"><span class="fa fa-trash-o">Delete</span></a>
                        
       				    </td>
							
						</tr>
						 <tr>
                        
                        <c:set var="gtot" value="${gtot+c.product.price*c.cartQnty}">
                        </c:set>
                       
                    </tr>
					</tbody>
					</c:forEach>
					
					<tfoot>
				
                   <!--  <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong></strong></h5></td>
                    </tr> -->
                   
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                       
                        <td class="text-right"><h3><strong> <c:out value="${gtot}"></c:out></span></td></strong></h3></td>
                    </tr>
                   
                    
						<tr>
						
							<td><a href="./" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"></td>
							<td> </td>
							
							<c:if test="${not empty cartInfo }">
							<td><a href="Checkout" class="btn btn-success btn-block"> Process to Checkout <i class="fa fa-angle-right"></i></a>
							</c:if>
							
							
							</td>
						</tr>
					</tfoot>
				</table>
</div>
<br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>