<%@ page import="com.agharibi.data.MenuDao" %>
<%@ page import="com.agharibi.data.MenuDaoFactory" %>
<%@ page import="com.agharibi.domain.MenuItem" %>
<%@ page import="java.util.List" %>
<%
    MenuDao menuDao = MenuDaoFactory.getMenuDao();
    List<MenuItem> fullMenu = menuDao.getFullMenu();
%>
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
        for (MenuItem item : fullMenu) {
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
