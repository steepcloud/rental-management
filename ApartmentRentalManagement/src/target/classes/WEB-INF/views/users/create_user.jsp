<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User</title>
</head>
<body>
    <h2>Create New User</h2>

    <c:if test="${not empty errors}">
        <div class="error-messages">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/user/create" method="post" modelAttribute="user">
        
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <table>
            <tr>
                <td><form:label path="username">Username:</form:label></td>
                <td><form:input path="username" /></td>
            </tr>
            <tr>
                <td><form:label path="password">Password:</form:label></td>
                <td><form:password path="password" /></td>
            </tr>
            <tr>
                <td><form:label path="role">Role:</form:label></td>
                <td><form:input path="role" /></td>
            </tr>
            <tr>
                <td><form:label path="email">Email:</form:label></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Create User" />
                </td>
            </tr>
        </table>
    </form:form>
    
    <a href="${pageContext.request.contextPath}/users">Back to User List</a>
	
	<footer>
        <form action="${pageContext.request.contextPath}/logout" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<button type="submit">Logout</button>
		</form>
    </footer>
</body>
</html>
