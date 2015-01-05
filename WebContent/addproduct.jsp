<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add product</title>
</head>
<body>
	<form method="get" action="InventoryPlatform/controller/insert">
		Product id:
		<input type="text" name="product_id">
		<br>
		Product name:
		<input type="text" name="product_name">
		<br>
		Product price:
		<input type="text" name="product_price">
		<br>
		<input type="submit" value="Submit">
		<br>
	</form>
	<a href="InventoryPlatform/controller/menu"><h2>Go Back To Main Menu</h2></a>
</body>
</html>