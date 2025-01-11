<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Rent Payment</title>
</head>
<body>
    <h1>Edit Rent Payment</h1>

    <form action="${pageContext.request.contextPath}/rentpayment/edit" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <input type="hidden" name="id" value="${rentPayment.id}" />
        <input type="hidden" name="tenantId" value="${rentPayment.tenant.id}"/>

        <div>
            <label for="tenant">Select Tenant:</label>
            <select id="tenant" name="tenantId" required>
                <option value="">Select a Tenant</option>
                <c:forEach var="tenant" items="${tenants}">
                    <option value="${tenant.id}" 
                            <c:if test="${tenant.id == rentPayment.tenant.id}">selected</c:if>>
                        ${tenant.name} (Apartment: ${tenant.apartment.name})
                    </option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" step="0.01" value="${rentPayment.amount}" required>
        </div>

        <div>
            <label for="paymentDate">Payment Date:</label>
            <input type="date" id="paymentDate" name="paymentDate" value="${rentPayment.paymentDate}" required>
        </div>

        <div>
            <button type="submit">Update Payment</button>
        </div>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/rentpayments">Back to Rent Payment List</a>
	
	<footer>
        <form action="${pageContext.request.contextPath}/logout" method="post">
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<button type="submit">Logout</button>
		</form>
    </footer>
</body>
</html>
