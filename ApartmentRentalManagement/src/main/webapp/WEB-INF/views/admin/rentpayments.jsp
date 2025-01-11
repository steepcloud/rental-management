<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Rent Payments</title>
</head>
<body>
    <h1>Manage Rent Payments</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tenant ID</th>
                <th>Tenant Name</th>
                <th>Amount</th>
                <th>Payment Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="rentPayment" items="${rentPayments}">
                <tr>
                    <td>${rentPayment.id}</td>
                    <td>${rentPayment.tenant.id}</td>
                    <c:if test="${not empty rentPayment.tenant}">
                        <td>${rentPayment.tenant.name}</td>
                    </c:if>
                    <td>${rentPayment.amount}</td>
                    <td>${rentPayment.paymentDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/rentpayment/edit/${rentPayment.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/rentpayment/delete/${rentPayment.id}" 
                           onclick="return confirm('Are you sure you want to delete this rent payment?');">Delete</a> 
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <h3>Manage Rent Payments:</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/rentpayment/create">Create New Rent Payment</a></li>
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
