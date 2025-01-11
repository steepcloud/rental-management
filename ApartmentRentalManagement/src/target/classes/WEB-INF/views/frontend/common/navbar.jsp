<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="nav-container">
    <div class="nav-buttons">
        <a href="<c:url value='/public/home' />" class="nav-btn">Home</a>
        <a href="<c:url value='/public/about' />" class="nav-btn">About</a>

        <c:choose>
            <c:when test="${not empty sessionScope.loggedInUser}">
                <a href="<c:url value='/user/dashboard' />" class="nav-btn">Dashboard</a>
                <form action="<c:url value='/logout' />" method="post" class="nav-btn-form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button type="submit" class="nav-btn">Logout</button>
                </form>
            </c:when>
            <c:otherwise>
                <a href="<c:url value='/public/login' />" class="nav-btn">Login</a>
                <a href="<c:url value='/public/register' />" class="nav-btn">Register</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>