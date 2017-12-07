<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date"%>
        
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
.invoice-title h2, .invoice-title h3 {
    display: inline-block;
}

.table > tbody > tr > .no-line {
    border-top: none;
}

.table > thead > tr > .no-line {
    border-bottom: none;
}

.table > tbody > tr > .thick-line {
    border-top: 2px solid;
}
</style>
<jsp:include page="Header.jsp"></jsp:include>
<body>
<form action="/orderProcess" class="form-horizontal">
<div class="container">
    <div class="row">
        <div class="col-xs-12">
    		<div class="invoice-title">
    			<h2>Invoice</h2><h3 class="pull-right">Order Number:</h3>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Shipped To:</strong><br>
    				${User.email}<br>
    				   ${User.name }<br>
                        ${User.address }<br>
                        ${User.phone }<br>
                        ${User.country }<br>
                        
    				</address>
    			</div>
    			
    		</div>
    		<div class="row">
    			<div class="col-xs-6 text-right">
    				<address>
    					<strong>Order Date:<%=new Date()%></strong><br>
    					 
    				</address>
    			</div>
    		</div>
    	</div>
    </div>
    
   <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><strong>Order summary</strong></h3>
                </div>

    <div class="row">

        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
             
                
                <c:forEach var="c" items="${Cart}">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"><img class="media-object" src="${pageContext.request.contextPath}/resources/${c.product.productId}.jpg" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${c.product.productName}</a></h4>
                                <h5 class="media-heading"> by <a href="#">${c.product.supplier.splrName }</a></h5>
                               
                            </div>
                        </div></td>
                     
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                          ${c.cartQnty}
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${c.product.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>${c.cartQnty*c.product.price}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        
                        
                           </td>
                    
                        </tr>
                    <tr>
                        
                        <c:set var="gtot" value="${gtot+c.product.price*c.cartQnty}">
                        </c:set>
                       
                    </tr>
                    
                   
                    </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td><span class="col-lg-7" align="right"><label>Grand Total</label>
                        <c:out value="${gtot}"></c:out></span></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <tr>
                      
                    </tr>
                    <tr>
                 <td><a href="Ackorder" class="btn btn-warning">Confirm Order</a></td>
                    </tr>
                </tbody>
            </table>
</div>
</form>
