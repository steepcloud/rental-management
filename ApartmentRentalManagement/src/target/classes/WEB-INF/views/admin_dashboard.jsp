<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Welcome to the Admin Dashboard</h1>

    <nav>
        <ul>
            <li><a href="<c:url value='/admin/tenants'/>">Manage Tenants</a></li>
            <li><a href="<c:url value='/admin/apartments'/>">Manage Apartments</a></li>
            <li><a href="<c:url value='/admin/rentpayments'/>">Manage Rent Payments</a></li>
            <li><a href="<c:url value='/admin/maintenancerequests'/>">Manage Maintenance Requests</a></li>
            <li><a href="<c:url value='/admin/users'/>">Manage Users</a></li>
        </ul>
    </nav>

    <footer>
        <p>Logged in as: <strong>${username}</strong></p>
        <form action="${pageContext.request.contextPath}/logout" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<button type="submit">Logout</button>
		</form>
    </footer>

</body>
</html>
