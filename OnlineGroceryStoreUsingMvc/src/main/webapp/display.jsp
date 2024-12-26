<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Welcome</h2><br><br>
<table border ="2">
<tr>
<th>PRODUCT_ID</th>
<th>NAME</th>
<th>CATEGORY</th>
<th>PRICE</th>
<th>STOCK</th>
</tr>
<tr>
<td>${product.productId}</td>
<td>${product.name}</td>
<td>${product.category}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
</tr>
</table>
</body>
</html>
