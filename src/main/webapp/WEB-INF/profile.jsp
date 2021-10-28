<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <button class="edit btn btn-info" id="edit">Edit</button>

    <form class="hidden" action="/profile" id="editForm" method="post">
        <ul>
            <li>
                <label for="username">Username</label>
                <input name="username" type="text" id="username"/>
            </li>
            <li>
                <label for="email">Email</label>
                <input name="email" type="text" id="email"/>
            </li>
            <li>
                <label for="password">Password</label>
                <input name="password" type="password" id="password"/>
            </li>
            <li>
                <label for="confirm_password">confirm_password</label>
                <input name="confirm_password" type="password" id="confirm_password"/>
            </li>
            <button type="submit" id="form-btn">Submit</button>
        </ul>
    </form>

</div>
<script src="/js/JQuery.js"></script>
<script src="/js/user.js"></script>
</body>
</html>