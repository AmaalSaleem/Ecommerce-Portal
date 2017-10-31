<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
body
{
    background: url('./resources/registration-background.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
} 
.fullscreen_bg
 {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-size: cover;
    background-position: 50% 50%;
    background-repeat:repeat;
  }


</style>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container">
	<div class="row">
				<form action="reg" method="post">
					<div class="col-sm-12">
							<div class="form-group">
								<label>Name</label>
								<input type="text" placeholder="Enter Name Here..." name="Name" class="form-control">
							</div>					
						<div class="form-group">
							<label>Address</label>
							<input type="text" placeholder="Enter Address Here.." name="Address" rows="3" class="form-control"></textarea>
						</div>	
						<div class="form-group">
						<label>Phone Number</label>
						<input type="text" placeholder="Enter Phone Number Here.." name="Phone" class="form-control">
						</div>	<div class="form-group">
						<label>Email Address</label>
						<input type="text" placeholder="Enter Email Address Here.." name="Email" class="form-control">
					</div>
						
						
							<div class="form-group">
								<label>Country</label>
								<input type="text" placeholder="Enter Country Name Here.." name="Country" class="form-control">
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
</body>
</html>