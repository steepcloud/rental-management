<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h2>Your Tenant Information</h2>

    <c:if test="${not empty tenant}">
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
        <a href="<c:url value='/tenants/edit?id=${tenant.id}' />" class="btn btn-warning">Edit Information</a>
    </c:if>
    <c:if test="${empty tenant}">
        <p>No tenant information found.</p>
    </c:if>
</div>

<jsp:include page="../../common/footer.jsp" />
