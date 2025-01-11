<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Tenant</title>
</head>
<body>
    <h1>Edit Tenant</h1>

    <form action="${pageContext.request.contextPath}/tenant/edit" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <input type="hidden" name="id" value="${tenant.id}" />

        <div>
            <label for="name">Tenant Name:</label>
            <input type="text" id="name" name="name" value="${tenant.name}" required>
        </div>
        
        <div>
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="${tenant.phone}">
        </div>
        
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${tenant.email}">
        </div>

        <div>
            <label for="apartment">Select Apartment:</label>
            <select id="apartment" name="apartmentId">
                <option value="">Select an Apartment</option>
                <c:forEach var="apartment" items="${apartments}">
                    <option value="${apartment.id}" 
                            <c:if test="${apartment.id == tenant.apartment.id}">selected</c:if>>
                        ${apartment.name}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div>
            <button type="submit">Update Tenant</button>
        </div>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/tenants">Back to Tenant List</a>
	
	<footer>
        <form action="${pageContext.request.contextPath}/logout" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<button type="submit">Logout</button>
		</form>
    </footer>
</body>
</html>
