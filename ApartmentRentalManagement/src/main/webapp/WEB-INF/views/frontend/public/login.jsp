<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<main class="login-container">
    <h1>User Login</h1>
    
    <c:if test="${not empty errorMessage}">
	    <p class="error">${errorMessage}</p>
	</c:if>
    
    <form action="<c:url value='/login' />" method="post">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    	
        <label for="username">Username or Email:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <p>Don't have an account? <a href="<c:url value='/public/register' />">Register here</a></p>
</main>

<jsp:include page="../common/footer.jsp" />