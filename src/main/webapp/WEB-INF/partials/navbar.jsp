<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${isLogin}"><!--This is the equivalent to a (if()) in an (if() else). (test="S{isLogin}") determines if profile and logout will appear in the navbar this will only happened if isLogin is true -->
                    <li><a href="/profile">Profile</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:when>
                <c:otherwise><!-- This is the equivalent to a (else) in a (if() else). This only show up if isLogin is false-->
                    <li><a href="/login">Login</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
