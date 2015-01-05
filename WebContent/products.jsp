<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, il.ac.shenkar.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>products</title>
</head>
<body>
<%
Collection<Product> collection = (Collection<Product>)request.getAttribute("products");
out.println("<table border=1>");
out.println("<tr><th>id</th><th>price</th><th>name</th></tr>");
for (Product product : collection) {
	out.println("<tr><td>"+product.getId()+"</td><td>"+product.getPrice()+"</td><td>"+product.getName()+"</td></tr>");
}
out.println("</table>");
%>
<a href="InventoryPlatform/controller/menu"><h2>Go Back To Main Menu</h2></a>
</body>
</html>