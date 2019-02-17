
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thank you page</title>
</head>
<body>
<jsp:include page="header.jsp" />
<%
    Double total = (Double) request.getAttribute("total");
    out.println("Thank you - your order has been received. Your total is: $" + total);
%>
<jsp:include page="footer.jsp" />
</body>
</html>
