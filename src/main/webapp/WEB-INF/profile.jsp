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
        .hidden{
            display: none;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Welcome, ${user.username}!</h1>
<%--this is the username edit form--%>
    <button class="edit btn btn-info" id="edit">Edit</button>
<%--added name and onsubmit functionality to catch empties--%>
    <form name="edit" class="hidden" action="/profile" id="editForm" method="post" onsubmit="return validateEdit()">
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
<%--    loop through and appends each ad that the user has created--%>
    <c:forEach var="ad" items="${ads}">
        <div>
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
<%--            form and button creation on each ad to capture their info for editing--%>
            <button class="adEdit btn btn-info" id="adEdit" data-id="${ad.id}">Edit your ad</button>
            <form class="hidden" method="post" action="/editAd" id="form${ad.id}" onsubmit="return validateAdEdit()">
                <ul>
                    <li>
                        <input name="title" type="text" value="${ad.title}"/>
                    </li>
                    <li>
                        <input name="description" type="text" value="${ad.description}"/>
                    </li>
                    <li>
                        <input name="adId" type="hidden" value="${ad.id}"/>
                    </li>
                    <li>
                       <button type="submit"> submit</button>
                    </li>
                </ul>
            </form>
<%--            form attached to each ad to delete--%>
            <form method="post" action="/deleteAd">
                <ul>
                    <li>
                        <input name="adId" type="hidden" value="${ad.id}"/>
                    </li>
                    <li>
                        <button type="submit"> Delete</button>
                    </li>
                </ul>
            </form>

        </div>
    </c:forEach>

</div>
<script src="/js/JQuery.js"></script>
<script src="/js/user.js"></script>
</body>
</html>