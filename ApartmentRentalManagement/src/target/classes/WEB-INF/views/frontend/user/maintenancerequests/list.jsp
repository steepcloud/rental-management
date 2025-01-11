<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h2>Your Maintenance Requests</h2>

    <c:if test="${not empty maintenanceRequests}">
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Apartment</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Created At</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="request" items="${maintenanceRequests}">
                    <tr>
                        <td>${request.apartment.name} - ${request.apartment.address}</td>
                        <td>${request.description}</td>
                        <td>${request.status}</td>
                        <td>${request.createdAt}</td>
                        <td>
                            <a href="<c:url value='/user/maintenancerequests/edit?id=${request.id}' />" class="btn btn-warning">Edit</a>
                            <a href="<c:url value='/user/maintenancerequests/details?id=${request.id}' />" class="btn btn-info">Details</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty maintenanceRequests}">
        <p>No maintenance requests found.</p>
    </c:if>
</div>

<jsp:include page="../../common/footer.jsp" />
