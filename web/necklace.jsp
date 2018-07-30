<%@ page import="ua.training.model.Gemstone" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Necklace</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-card-4">
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Select gemstone:
            <select name="stone" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                <optgroup label="Semiprecious">
                    <option value="Aquamarine">Aquamarine</option>
                    <option value="Garnet">Garnet</option>
                    <option value="Sardonyx">Sardonyx</option>
                    <option value="Topaz">Topaz</option>
                    <option value="Chrysolite">Chrysolite</option>
                </optgroup>
                <optgroup label="Precious">
                    <option value="Diamond">Diamond</option>
                    <option value="Emerald">Emerald</option>
                    <option value="Ruby">Ruby</option>
                    <option value="Tourmaline">Tourmaline</option>
                    <option value="Spinel">Spinel</option>
                </optgroup>
            </select>
        </label><br/>
        <label>Select size:
            <select name="carat" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                <option value="0.1">0.1</option>
                <option value="0.2">0.2</option>
                <option value="0.3">0.3</option>
                <option value="0.5">0.5</option>
                <option value="0.7">0.7</option>
                <option value="1">1</option>
                <option value="1.5">1.5</option>
                <option value="1.7">1.7</option>
                <option value="2">2</option>
                <option value="2.5">2.5</option>
                <option value="3">3</option>
                <option value="3.5">3.5</option>
            </select>
        </label><br/>
        <label>Select transparency:
            <select name="transparency" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
                <option value="Transparent">Transparent</option>
                <option value=Semitransparent>Semitransparent</option>
                <option value="Non_transparent">Non-transparent</option>
            </select>
        </label></br>
        <button type="submit" name="addGemstone" class="w3-btn w3-green w3-round-large w3-margin-bottom">Add</button>
        <button type="submit" name="createNecklace" class="w3-btn w3-green w3-round-large w3-margin-bottom">Create
            necklace
        </button>
    </form>

    <%
        List<Gemstone> gemstones = (List<Gemstone>) request.getAttribute("necklace");
        if (gemstones != null && !gemstones.isEmpty()) {
            out.println("<div class=\"w3-card-4\">" +
                    "<p>Your necklace consists of: </<p>" +
                    "</div>");
            for (Gemstone gemstone : gemstones) {
                out.println(
                        "<ul>\n" +
                            "<li> "+gemstone+" </li>\n" +
                        "</ul>");
            }
        }
    %>

    <form action="${pageContext.request.contextPath}/costCalculator" method="get" class="w3-selection w3-light-grey w3-padding">
        <button type="submit" name="calculatePrice" class="w3-btn w3-green w3-round-large w3-margin-bottom">Calculate
            total price
        </button>
    </form>

    <form action="${pageContext.request.contextPath}/weightCalculator" method="get" class="w3-selection w3-light-grey w3-padding">
        <button type="submit" name="calculateWeight" class="w3-btn w3-green w3-round-large w3-margin-bottom">Calculate
            total weight
        </button>
    </form>

    <form action="${pageContext.request.contextPath}/sorter" method="get" class="w3-selection w3-light-grey w3-padding">
        <button type="submit" name="sort" class="w3-btn w3-green w3-round-large w3-margin-bottom">Sort by cost</button>
    </form>

    <form action="${pageContext.request.contextPath}/searcher" method="get" class="w3-selection w3-light-grey w3-padding">
        <button type="submit" name="search" class="w3-btn w3-green w3-round-large w3-margin-bottom">Search</button>
    </form>
</div>
</body>
</html>