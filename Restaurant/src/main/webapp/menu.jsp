<%@ page import="com.agharibi.domain.MenuItem" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Menu</h2>
<ul>
    <%
        List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
        for (MenuItem item : menuItems) {
    %>
    <li><%=item%>
    </li>
    <%
        }
    %>
</ul>
<jsp:include page="/footer.jsp"/>
</body>
</html>
