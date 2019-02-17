<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Menu</h2>
<ul>
    <c:forEach items="${menuItems}" var="menuItem">
        <li>${menuItem} - ${menuItem.getDescription()}</li>
    </c:forEach>
</ul>
<jsp:include page="/footer.jsp"/>
</body>
</html>
