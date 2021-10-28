<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Please Log In</h1>
        <form name="login" action="/login" method="POST" onsubmit="return validateLogin()">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
        <%--added this choose to be able to display our failed attempt functionality for the user when a form fails to submit--%>
        <c:choose>
            <c:when test="${failedAttempt}">
                <a href="/register"> <%--this anchor tag will redirect the user to the correct page, which in this case, is the register page because the input does not match a user--%>
                    User does not exist. Click to register.
                </a>
            </c:when>
        </c:choose>
    </div>
    <script src="/js/validation.js"></script>
</body>
</html>
