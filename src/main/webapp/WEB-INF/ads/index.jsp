<%@ page import="com.mysql.cj.x.protobuf.MysqlxDatatypes" %>
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
    <form action="/ads" name="searchAd">
        <input type="text" name="searchTitle">
        <input type="submit">
    </form>
    <h1>Here Are all the ads!</h1>

    <c:choose>
        <c:when test="hasSearched">
            <c:forEach var="ad" items="${ads}">
    <div id="ad-title" class="col-md-6">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
        <form action="/ads" method="POST">
            <input name="ad-ID" id="adID" type="hidden" value="${ad.id}">
            <input type="submit" class="btn btn-primary" value="View Ad">
        </form>
            </c:forEach>
        </c:when>
        <c:otherwise>
    <c:forEach var="ad" items="${ads}">
        <div id="ad-title" class="col-md-6">

            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <form action="/ads" method="POST">
                <input name="ad-ID" id="ad-ID" type="hidden" value="${ad.id}">
                <input type="submit" class="btn btn-primary" value="View Ad">
            </form>
        </div>
    </c:forEach>
    </c:otherwise>
    </c:choose>

</div>

<script>

</script>

</body>
</html>