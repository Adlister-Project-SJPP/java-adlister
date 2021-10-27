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
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div id="ad-title" class="col-md-6">
            <a href="/viewAd.jsp"><h2 id="adTitle">${ad.title}</h2></a>
            <p>${ad.description}</p>
        </div>
    </c:forEach>

    <form action="index.jsp">
        <input type="text" name="adTitle">
        <input type="submit" value="View">
    </form>

    <% String name = request.getParameter("adTitle");
    out.print("Welcome", name);
    session.setAttribute("user", name);
    <a href=

</div>

<script>

</script>

</body>
</html>
