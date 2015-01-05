<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error</title>
</head>
<body>
	<%= "<br>exception: "+((Exception)request.getAttribute("exception")).getMessage() %>
	<%= "<br>cause: "+((Exception)request.getAttribute("exception")).getCause().getMessage() %>
	<a href="InventoryPlatform/controller/menu"><h2>Go Back To Main Menu</h2></a>
</body>
</html>