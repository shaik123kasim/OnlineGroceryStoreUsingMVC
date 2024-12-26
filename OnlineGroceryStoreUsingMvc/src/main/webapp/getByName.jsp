<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form action="viewByName" modelAttribute="product">
<form:label path="name">ENTER THE PRODUCT NAME TO SEARCH : </form:label>
<form:input path="name"/><br><br>
<input type="submit" value="SEARCH">
</form:form>
</body>
</html>
