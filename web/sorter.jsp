<%@ page import="ua.training.model.Gemstone" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cost Calculator</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center-align">
    <h1>Gemstones have been sorted by cost:</h1>
</div>
<div class="w3-card-4">
    <%
        List<Gemstone> sortedGemstone = (List<Gemstone>) request.getAttribute("sortedGemstone");
        if (sortedGemstone != null && !sortedGemstone.isEmpty()) {
            for (Gemstone gemstone : sortedGemstone) {
                out.println(
                        "<ul>\n" +
                            "<li> " + gemstone + " </li>\n" +
                        "</ul>");
            }
        }
    %>
</div>
</body>
</html>
