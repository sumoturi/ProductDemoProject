

<jsp:useBean id="shoeIn" class="com.java.demo.bo.ProductDO"
	scope="request"></jsp:useBean>
<jsp:setProperty property="shoeId" name="shoeIn" />
<jsp:setProperty property="shoeName" name="shoeIn" />
<jsp:setProperty property="shoeDescription" name="shoeIn" />
<jsp:setProperty property="shoePolish" name="shoeIn" />
<jsp:forward page="../ProductProcessor"></jsp:forward>