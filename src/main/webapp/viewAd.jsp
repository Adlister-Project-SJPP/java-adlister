<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing Individual Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">

        <div class="col-md-12">
            <h1>${singleAd.title}</h1>
        </div>

        <div class="col-md-6">
            <p>${singleAd.description}</p>
        </div>
    


</div>

</body>
</html>
