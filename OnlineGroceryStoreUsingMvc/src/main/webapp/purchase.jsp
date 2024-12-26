<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form action="bill" modelAttribute="product">
<form:label path="productId">ENTER THE PRODUCT ID TO PURCHASE : </form:label>
<form:input path="productId"/><br><br>
<form:label path="quantity">QUANTITY : </form:label>
<form:input path="quantity"/><br><br>
<input type="submit" value="BUY">
</form:form>
</body>
</html>
