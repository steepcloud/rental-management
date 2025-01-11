<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Tenants</title>
</head>
<body>
    <h1>Manage Tenants</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Apartment</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tenant" items="${tenants}">
                <tr>
                    <td>${tenant.id}</td>
                    <td>${tenant.name}</td>
                    <td>${tenant.phone}</td>
                    <td>${tenant.email}</td>
                    <c:if test="${not empty tenant.apartment}">
                        <td>${tenant.apartment.name}</td>
                    </c:if>
                    <td>
                        <a href="${pageContext.request.contextPath}/tenant/edit/${tenant.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/tenant/delete/${tenant.id}" 
                           onclick="return confirm('Are you sure you want to delete this tenant?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <h3>Manage Tenants:</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/tenant/create">Create New Tenant</a></li>
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
