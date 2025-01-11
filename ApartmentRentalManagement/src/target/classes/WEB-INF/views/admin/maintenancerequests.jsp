<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Maintenance Requests</title>
</head>
<body>
    <h1>Manage Maintenance Requests</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Apartment ID</th>
                <th>Description</th>
                <th>Status</th>
                <th>Created At</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="request" items="${maintenanceRequests}">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.apartment.id}</td>
                    <td>${request.description}</td>
                    <td>${request.status}</td>
                    <td>${request.createdAt}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/maintenancerequest/edit/${request.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/maintenancerequest/delete/${request.id}" 
                           onclick="return confirm('Are you sure you want to delete this maintenance request?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <h3>Manage Maintenance Requests:</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/maintenancerequest/create">Create New Maintenance Request</a></li>
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
