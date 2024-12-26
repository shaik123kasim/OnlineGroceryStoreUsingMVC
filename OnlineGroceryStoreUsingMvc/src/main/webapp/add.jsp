<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form action="save" modelAttribute="product">
<form:label path="name">NAME : </form:label>
<form:input path="name"/><br><br>
<form:label path="category">CATEGORY : </form:label>
<form:input path="category"/><br><br>
<form:label path="price">PRICE : </form:label>
<form:input path="price"/><br><br>
<form:label path="stock">STOCK : </form:label>
<form:input path="stock"/><br><br>
<input type="submit" value="SAVE PRODUCT">
</form:form>
</body>
</html>
