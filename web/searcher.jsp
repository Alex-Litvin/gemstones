<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Searcher</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center-align">
    <h1>Select parameters for search gemstones:</h1>
</div>
<div class="w3-card-4">
    <div class="check-box-table-cell">
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <input type="checkbox" name="transparent" value="Transparent">Transparent<br>
            <input type="checkbox" name="semitransparent" value="Semitransparent">Semitransparent<br>
            <input type="checkbox" name="non_transparent" value="Non_transparent">Non-transparent<br><br>
            <button type="submit" name="bounds" class="w3-btn w3-green w3-round-large w3-margin-bottom">Search</button>
        </form>
    </div>
    <c:if test="${!empty foundGemstone}">
        <table class="w3-table w3-bordered w3-striped">
            <tr class="w3-teal">
                <th>Gemstone</th>
                <th>Type</th>
                <th>Carat</th>
                <th>Carat/Price</th>
                <th>Transparency</th>
                <th>Cost factor</th>
                <th>Cost</th>
            </tr>
            <c:forEach var="gemstone" items="${foundGemstone}">
                <jsp:useBean id="gemstone" class="ua.training.model.Gemstone"/>
                <tr>
                    <c:forEach var="map" items="${gemstone.nameTypeMap}">
                        <td><c:out value="${map.key.title}"/></td>
                        <td><c:out value="${map.value.name().toLowerCase()}"/></td>
                    </c:forEach>
                    <td><c:out value="${gemstone.carat}"/></td>
                    <td><c:out value="${gemstone.caratPrice}"/></td>
                    <td><c:out value="${gemstone.transparency.name().toLowerCase()}"/></td>
                    <td><c:out value="${gemstone.transparency.costFactor}"/></td>
                    <td><c:out value="${gemstone.totalCost}"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div class="w3-bar w3-padding-large w3-padding-24">
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/necklace'">Back</button>
    </div>
</div>
</body>
</html>