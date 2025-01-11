<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Users</title>
</head>
<body>
    <h1>Manage Users</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Role</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.role}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/user/delete/${user.id}" 
                           onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <h3>Manage Users:</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/user/create">Create New User</a></li>
        </ul>
    </div>
	
	<footer>
        <form action="${pageContext.request.contextPath}/logout" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<button type="submit">Logout</button>
		</form>
    </footer>
</body>
</html>
