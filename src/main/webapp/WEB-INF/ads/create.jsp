<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Create a new Ad</h1>
        <form name="create" action="/ads/create" method="post" onsubmit="return false">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <input type="submit" onclick="validateCreate2()" class="btn btn-block btn-primary">
        </form>
    </div>
    <script src="/js/validation2.js"></script>
</body>
</html>
