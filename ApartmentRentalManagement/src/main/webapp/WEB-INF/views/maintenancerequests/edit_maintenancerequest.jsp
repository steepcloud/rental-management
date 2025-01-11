<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Maintenance Request</title>
</head>
<body>
    <h1>Edit Maintenance Request</h1>

    <form action="${pageContext.request.contextPath}/maintenancerequest/edit" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="id" value="${request.id}" />
        <div>
            <label for="apartment">Select Apartment:</label>
            <select id="apartment" name="apartmentId" required>
                <option value="">Select an Apartment</option>
                <c:forEach var="apartment" items="${apartments}">
                    <option value="${apartment.id}" 
                            <c:if test="${apartment.id == request.apartment.id}">selected</c:if>>
                        ${apartment.name} (${apartment.address})
                    </option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" cols="50" required>${request.description}</textarea>
        </div>

        <div>
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="PENDING" <c:if test="${request.status == 'PENDING'}">selected</c:if>>Pending</option>
                <option value="COMPLETED" <c:if test="${request.status == 'COMPLETED'}">selected</c:if>>Completed</option>
            </select>
        </div>

        <div>
            <button type="submit">Update Request</button>
        </div>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/maintenancerequests">Back to Maintenance Requests</a>
    
    <footer>
        <form action="${pageContext.request.contextPath}/logout" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<button type="submit">Logout</button>
		</form>
    </footer>
</body>
</html>
