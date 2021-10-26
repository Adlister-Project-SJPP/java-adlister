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
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-12">
            <h1>${ad.title}</h1>
        </div>
    </c:forEach>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
