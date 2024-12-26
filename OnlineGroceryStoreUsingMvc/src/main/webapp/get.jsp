<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form action="view" modelAttribute="product">
<form:label path="productId">ENTER THE PRODUCT ID TO SEARCH : </form:label>
<form:input path="productId"/><br><br>
<input type="submit" value="SEARCH">
</form:form>
</body>
</html>
