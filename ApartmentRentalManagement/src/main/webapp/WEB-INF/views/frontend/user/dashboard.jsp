<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<div class="container">
    <c:choose>
        <c:when test="${not empty tenant}">
            <h2>Welcome back, ${tenant.name}!</h2>
        </c:when>
        <c:otherwise>
            <h2>Welcome back, ${user.username}!</h2>
            <c:if test="${empty tenant}">
                <div class="tenant-info">
                    <h3>Your Tenant Information</h3>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Apartment</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${tenant.name}</td>
                                <td>${tenant.phone}</td>
                                <td>${tenant.email}</td>
                                <td>${tenant.apartment != null ? tenant.apartment.name : 'No Apartment Assigned'}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <c:if test="${empty tenant}">
                <p>No tenant information found. Please contact support or check your account settings.</p>
            </c:if>
        </c:otherwise>
    </c:choose>

    <div class="quick-links">
        <h3>Quick Links</h3>
        <ul>
            <li><a href="<c:url value='/user/profile' />">Profile</a></li>
            <c:if test="${not empty apartment}">
            <li><a href="<c:url value='/user/apartments/details' />">Apartment Details</a></li>
            </c:if>
            <li><a href="<c:url value='/user/maintenancerequests/list' />">Maintenance Requests</a></li>
            <li><a href="<c:url value='/user/rentpayments/list' />">Rent Payments</a></li>
        </ul>
    </div>

    <c:choose>
        <c:when test="${not empty tenant}">
            <div class="apartment-summary">
                <h3>Your Apartment</h3>
                <p><strong>Apartment Name:</strong> ${tenant.apartment.name}</p>
                <p><strong>Address:</strong> ${tenant.apartment.address}</p>
                <p><strong>Rent:</strong> $${tenant.apartment.rent}</p>
                <a href="<c:url value='/user/apartments/details' />" class="btn btn-primary">View Apartment Details</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="apartment-summary">
                <h3>Your Apartment</h3>
                <p>No apartment assigned yet.</p>
            </div>
        </c:otherwise>
    </c:choose>

    <div class="maintenance-summary">
        <h3>Maintenance Requests</h3>
        <p><strong>Total Requests:</strong> ${maintenanceRequests.size()}</p>
        <p><strong>Pending Requests:</strong> ${pendingRequestsCount}</p>
        <a href="<c:url value='/user/maintenancerequests/list' />" class="btn btn-primary">View All Requests</a>
    </div>

    <div class="rent-summary">
        <h3>Rent Payments</h3>
        <p><strong>Total Payments:</strong> ${rentPayments.size()}</p>
        <c:if test="${not empty rentPayments}">
            <p><strong>Last Payment Date:</strong> ${rentPayments.get(0).payment_date}</p>
        </c:if>
        <a href="<c:url value='/user/rentpayments/list' />" class="btn btn-primary">View Payment History</a>
    </div>

    <div class="alerts">
        <h3>Alerts</h3>
        <c:if test="${not empty alerts}">
            <ul>
                <c:forEach items="${alerts}" var="alert">
                    <li>${alert}</li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${empty alerts}">
            <p>No alerts at this time.</p>
        </c:if>
    </div>
</div>

<jsp:include page="../common/footer.jsp" />
