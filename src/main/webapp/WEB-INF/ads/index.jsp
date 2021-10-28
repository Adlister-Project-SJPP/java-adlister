<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
<h3>Search ad by title</h3>
    <form action="POST" name="searchAd">
        <input type="text" name="searchTitle">
        <input type="submit">
    </form>
    <h1>Here Are all the ads!</h1>
    <c:choose>
        <c:when test="">
            <c:forEach var="ad" items="${ads}">
            </c:forEach>
        </c:when>
        <c:otherwise>
        <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
    </c:otherwise>
    <h3>Search ads by title</h3>
    <input type="text" id="search-input">

    </c:choose>
</div>

</body>
</html>