<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <style>
        li{
            list-style: none;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome, ${user.username}!</h1>

    <button class="edit btn btn-info" id="edit">Edit</button>

    <form class="hidden" action="/profile" id="editForm" method="post">
        <ul>
            <li>
                <label for="username">Username</label>
                <input name="username" type="text" value="${user.username}" id="username"/>
            </li>
            <li>
                <label for="email">Email</label>
                <input name="email" type="text" value="${user.email}" id="email"/>
                <input name="id" type="hidden" value="${user.id}"/>
            </li>
            <button type="submit" id="form-btn">Submit</button>
        </ul>
    </form>
    <c:forEach var="ad" items="${ads}">
        <div>
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>

</div>
<script src="/js/JQuery.js"></script>
<script src="/js/user.js"></script>
</body>
</html>