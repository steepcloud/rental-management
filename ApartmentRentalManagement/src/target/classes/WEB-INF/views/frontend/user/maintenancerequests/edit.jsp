<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h2>Edit Maintenance Request</h2>
    
    <form action="<c:url value='/user/maintenancerequests/edit' />" method="post">
        <input type="hidden" name="id" value="${maintenanceRequest.id}" />
        
        <div class="form-group">
            <label for="apartmentId">Apartment</label>
            <select name="apartmentId" id="apartmentId" class="form-control" required>
                <c:forEach var="apartment" items="${apartments}">
                    <option value="${apartment.id}" <c:if test="${apartment.id == maintenanceRequest.apartmentId}">selected</c:if>>${apartment.name} - ${apartment.address}</option>
                </c:forEach>
            </select>
        </div>
        
        <div class="form-group">
            <label for="description">Description</label>
            <textarea name="description" id="description" class="form-control" rows="4" required>${maintenanceRequest.description}</textarea>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <select name="status" id="status" class="form-control">
                <option value="PENDING" <c:if test="${maintenanceRequest.status == 'PENDING'}">selected</c:if>>Pending</option>
                <option value="COMPLETED" <c:if test="${maintenanceRequest.status == 'COMPLETED'}">selected</c:if>>Completed</option>
            </select>
        </div>
        
        <button type="submit" class="btn btn-primary">Update Request</button>
    </form>
</div>

<jsp:include page="../../common/footer.jsp" />
