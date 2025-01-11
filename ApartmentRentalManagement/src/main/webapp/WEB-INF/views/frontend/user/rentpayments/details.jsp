<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h2>Rent Payment Details</h2>

    <c:if test="${not empty rentPayment}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Tenant</th>
                    <th>Amount</th>
                    <th>Payment Date</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${rentPayment.tenant.name}</td>
                    <td>${rentPayment.amount}</td>
                    <td>${rentPayment.paymentDate}</td>
                </tr>
            </tbody>
        </table>
        <a href="<c:url value='/rentpayments/list' />" class="btn btn-secondary">Back to Payments List</a>
    </c:if>
    <c:if test="${empty rentPayment}">
        <p>No payment details found for this request.</p>
    </c:if>
</div>

<jsp:include page="../../common/footer.jsp" />
