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
    background: url('./resources/background.jpg') fixed;
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
    form
{
   margin-left: 0%;
   margin-right:70%;
    width: 40em;
    border : 0px solid #000;
  padding : 5px;
  align:left;
  vertical-align: left
        
}
</style>

<body>
<jsp:include page="Header.jsp"></jsp:include>
  <div class="container">

<div class="row" style="margin-top:40px">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form action="j_spring_security_check" method="post">
			<fieldset>
				<center><h2><font color="white" >Login Here</font></h2></center>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" name="j_username" id="email" class="form-control input-lg" placeholder="Email Address"required>
				</div>
				<div class="form-group">
                    <input type="password" name="j_password" id="password" class="form-control input-lg" placeholder="Password"required>
				</div>
				<span class="button-checkbox">
					<button type="button" class="btn" data-color="info">Remember Me</button>
                    <input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden">
				</span>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12">
                        <input type="submit" class="btn btn-lg btn-secondary btn-block" value="Sign In">
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>

</div>


<br>
<br>

<jsp:include page="Footer.jsp"></jsp:include>
</body>

</html>