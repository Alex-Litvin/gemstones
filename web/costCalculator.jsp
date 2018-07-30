<%@ page import="ua.training.model.Gemstone" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Calculator</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center-align">
    <h1>Your necklace consist of such gemstones:</h1>
</div>
<div class="w3-card-4">
    <%
        Map<Gemstone, BigDecimal> gemstonePriceMap = (Map<Gemstone, BigDecimal>) request.getAttribute("gemstonePriceMap");
        if (gemstonePriceMap != null && !gemstonePriceMap.isEmpty()) {
            for (Map.Entry<Gemstone, BigDecimal> entry : gemstonePriceMap.entrySet()) {
                out.println(
                        "<ul>\n" +
                            "<li> " + entry.getKey() + " price = " + entry.getValue() + " </li>\n" +
                        "</ul>");
            }
        }

        BigDecimal totalCost = (BigDecimal) request.getAttribute("totalCost");
        if (totalCost != null) {
            out.println("<p> Total price: " + totalCost +"</p>");
        }
    %>
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/necklace'">Back</button>
    </div>
</div>
</body>
</html>