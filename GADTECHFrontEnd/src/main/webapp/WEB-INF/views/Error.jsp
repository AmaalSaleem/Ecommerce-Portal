<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
body {
	background-image: url("./resources/images/qq.jpg");
	background-size: cover;
	padding
	=0;
	margin
	=0;
}
</style>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<font color="white"><h3>
			<b><i>invalid Username or Password :(</i></b>
		</h3></font>
		
		           <a href="login"><button class="btn btn-success" type="button"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> LOGIN FIRST</button></a>
		
	<br />
	<br />
	<br />
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>