<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="deptOut" class="com.java.demo.bo.ProductDO"
	scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">ShoeOutput</h1>
	<div align="center">
			<label>ShoeName:</label><jsp:getProperty property="shoeName" name="shoeOut" /><br> 
			<label>ShoeId:</label><jsp:getProperty property="shoeId" name="shoeOut" /><br> 
			<label>ShoeDescription:</label><jsp:getProperty property="shoeDescription" name="shoeOut" /><br> 
			<label>ShoePolish:</label><jsp:getProperty property="shoePolish" name="shoeOut" /><br> <a
			href="Edit.jsp">Edit Shoe  </a> 
			 <a href="Home.jsp">New Shoe</a>
	</div>

</body>
</html>