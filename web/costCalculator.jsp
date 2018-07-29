<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Calculator</title>
</head>
<body>
<%
    BigDecimal totalCost = (BigDecimal) request.getAttribute("totalCost");
    if (totalCost!= null) {
        out.println(totalCost);
    }
%>
</body>
</html>
