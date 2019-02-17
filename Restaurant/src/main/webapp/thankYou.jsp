<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Thank you page</title>
</head>
<body>
<jsp:include page="header.jsp"/>

    Thank you - your order has been received. Your total is: <fmt:formatNumber value="${total}" type="currency" currencyCode="${currency}" />

<jsp:include page="footer.jsp"/>
</body>
</html>
