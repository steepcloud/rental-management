<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<div class="container">
    <h2>Welcome, ${user.username}!</h2>

    <div class="row">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Apartments Information</h5>
                    <p class="card-text">View or see apartment details.</p>
                    <a href="<c:url value='/apartments/list' />" class="btn btn-primary">View Apartments</a>
                    
                    <c:if test="${not empty apartment}">
                        <a href="<c:url value='/apartments/details?apartmentId=${apartment.id}' />" class="btn btn-success mt-2">View Details</a>
                    </c:if>
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Tenant Information</h5>
                    <p class="card-text">View or edit your tenant information.</p>
                    <a href="<c:url value='/tenants/info' />" class="btn btn-primary">View Info</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Maintenance Requests</h5>
                    <p class="card-text">Create or view your maintenance requests.</p>
                    <a href="<c:url value='/user/maintenancerequests/list' />" class="btn btn-primary">View Requests</a>
                    <a href="<c:url value='/user/maintenancerequests/create' />" class="btn btn-success mt-2">Create Request</a>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Rent Payments</h5>
                    <p class="card-text">View or see rent payments.</p>
                    <a href="<c:url value='/user/rentpayments/list' />" class="btn btn-primary">View Payments</a>
                    <a href="<c:url value='/user/rentpayments/details' />" class="btn btn-success mt-2">Payment details</a>
                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="../common/footer.jsp" />
