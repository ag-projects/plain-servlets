<%@ page import="com.agharibi.domain.MenuItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Order</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<h2>Order your food:</h2>
<form action="orderReceived.html" method="post">
    <ul>
        <%
            List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("menuItems");
            for (MenuItem menuItem : menuItems) {
                out.println("<li>" + menuItem + "<input type='text' name='item_" + menuItem.getId() + "' /></li>");
            }
        %>
    </ul>
    <input type="submit"/>
</form>
</form>
<jsp:include page="/footer.jsp"/>
</body>
</html>
