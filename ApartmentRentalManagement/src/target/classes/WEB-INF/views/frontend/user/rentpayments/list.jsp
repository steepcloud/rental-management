<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h2>Your Rent Payments</h2>

    <c:if test="${not empty rentPayments}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Tenant</th>
                    <th>Amount</th>
                    <th>Payment Date</th>
                    <th>Details</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="payment" items="${rentPayments}">
                    <tr>
                        <td>${payment.tenant.name}</td>
                        <td>${payment.amount}</td>
                        <td>${payment.paymentDate}</td>
                        <td>
                            <a href="<c:url value='/rentpayments/details?id=${payment.id}' />" class="btn btn-info">View Details</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty rentPayments}">
        <p>No rent payments found.</p>
    </c:if>
</div>

<jsp:include page="../../common/footer.jsp" />
