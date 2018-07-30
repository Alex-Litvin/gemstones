<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Calculator</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center-align">
    <h1>Total weight of your necklace is:</h1>
</div>
<div class="w3-card-4">
    <%
        BigDecimal totalWeight = (BigDecimal) request.getAttribute("totalWeight");
        if (totalWeight!= null) {
            out.println("<h1>" + totalWeight + "</h1>");
        }
    %>
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/necklace'">Back</button>
    </div>
</div>
</body>
</html>