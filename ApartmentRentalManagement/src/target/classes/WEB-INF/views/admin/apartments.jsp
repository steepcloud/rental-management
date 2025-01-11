<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Apartments</title>
</head>
<body>
    <h1>Manage Apartments</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>Rooms</th>
                <th>Rent</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="apartment" items="${apartments}">
                <tr>
                    <td>${apartment.id}</td>
                    <td>${apartment.name}</td>
                    <td>${apartment.address}</td>
                    <td>${apartment.rooms}</td>
                    <td>${apartment.rent}</td>
                    <td>${apartment.description}</td>
                    <td>
                		<a href="${pageContext.request.contextPath}/apartment/edit/${apartment.id}">Edit</a> | 
                        <a href="${pageContext.request.contextPath}/apartment/delete/${apartment.id}" 
                           onclick="return confirm('Are you sure you want to delete this apartment?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <h3>Manage Apartments:</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/apartment/create">Create New Apartment</a></li>
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
