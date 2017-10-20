<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
	<div class="col-lg-12 well">
	<div class="row">
				<form action="reg" method="post">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Name</label>
								<input type="text" placeholder="Enter Name Here.." name="Name" class="form-control">
							</div>
						</div>					
						<div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address Here.." name="Address" rows="3" class="form-control"></textarea>
						</div>	
						<div class="form-group">
						<label>Phone Number</label>
						<input type="text" placeholder="Enter Phone Number Here.." name="Phone" class="form-control">
						</div>	<div class="form-group">
						<label>Email Address</label>
						<input type="text" placeholder="Enter Email Address Here.." name="Email" class="form-control">
					</div>
						
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Country</label>
								<input type="text" placeholder="Enter Country Name Here.." name="Country" class="form-control">
							</div>			
						</div>		
						<div class="form-group">
						<label>Password</label>
						<input type="password" placeholder="Enter password...." name="Password" class="form-control">
						</div>			
						
						
					<center>
					<button type="submit" class="btn btn-lg btn-info">Submit</button>		
					<button type="cancel" class="btn btn-lg btn-info">Cancel</button>	
					
					</center>
							
					</div>
				</form> 
				</div>
	</div>
	</div>
</body>
</html>