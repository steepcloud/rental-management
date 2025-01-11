<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <jsp:include page="../common/header.jsp" />
</head>
<body>
    <jsp:include page="../common/navbar.jsp" />

    <main class="register-container">
        <h1>Register</h1>
        <form action="<c:url value='/public/register' />" method="post">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        	
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
            
            <button type="submit">Register</button>
        </form>

        <p>Already have an account? <a href="<c:url value='/public/login' />">Login here</a></p>
    </main>

    <jsp:include page="../common/footer.jsp" />
</body>
</html>
