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
    background: url('./resources/windows-central-background.jpg') fixed;
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
					<div class="col-sm-12" >
							<div class="form-group">
								<label><font color="white">Name</font></label>
								<input type="text" placeholder="Enter Name Here..." pattern="[a-zA-Z]{1,15}" title="Special Characters not allowed"  name="Name" class="form-control"required>
							</div>					
						<div class="form-group">
							<label><font color="white">Address</font></label>
							<input type="text" placeholder="Enter Address Here.." name="Address" rows="3" class="form-control"required></textarea>
						</div>	
						<div class="form-group">
						<label><font color="white">Phone Number</font></label>
						<input type="text" placeholder="Enter Phone Number Here.." pattern="[789][0-9]{9}" name="Phone" class="form-control" maxlength="10"title="Indian phone no must start with 7,8 or 9" required>
						</div>	<div class="form-group">
						<label><font color="white">Email Address</font></label>
						<input type="text" placeholder="Enter Email Address Here.." pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="eg:amal@gmail.com" name="Email" class="form-control"required>
					</div>
						
						
							<div class="form-group">
								<label><font color="white">Country</font></label>
								<input type="text" placeholder="Enter Country Name Here.." name="Country" class="form-control"required>
							</div>			
							
						<div class="form-group">
						<label><font color="white">Password</font></label>
						<input type="password" placeholder="Enter password...." pattern=".{6,}" title="Six or more characters" name="Password" class="form-control"required>
						</div>			
						
						
					<center>
					<button type="submit" class="btn btn-lg btn-info">Submit</button>		
					<button type="cancel" class="btn btn-lg btn-info">Cancel</button>	
					
					</center>
							
					</div>
					
				</form> 
				<br>
	<br><br>
	<br>
				</div>
	</div>
	
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>