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
    <h1>Select bounds for search gemstones:</h1>
</div>
<div class="w3-card-4">
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <input type="checkbox" name="transparent" value="Transparent">Transparent<br>
        <input type="checkbox" name="semitransparent" value="Semitransparent">Semitransparent<br>
        <input type="checkbox" name="non_transparent" value="Non_transparent">Non-transparent<br>
        <button type="submit" name="bounds" class="w3-btn w3-green w3-round-large w3-margin-bottom">Search</button>
    </form>
    <%
        List<Gemstone> foundGemstone = (List<Gemstone>) request.getAttribute("foundGemstone");
        if (foundGemstone != null && !foundGemstone.isEmpty()) {
            for (Gemstone gemstone : foundGemstone) {
                out.println(
                                "<ul>\n" +
                                "<li> " + gemstone + " </li>\n" +
                                "</ul>");
            }
        } else out.println("<p>There are not matches!</p>");
    %>
</div>
</body>
</html>