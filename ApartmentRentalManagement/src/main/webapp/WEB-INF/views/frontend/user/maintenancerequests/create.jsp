<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h2>Create a New Maintenance Request</h2>
    
    <form action="<c:url value='/user/maintenancerequests/create' />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="form-group">
            <label for="apartmentId">Apartment</label>
            <select name="apartmentId" id="apartmentId" class="form-control" required>
                <c:forEach var="apartment" items="${apartments}">
                    <option value="${apartment.id}">${apartment.name} - ${apartment.address}</option>
                </c:forEach>
            </select>
        </div>
        
        <div class="form-group">
            <label for="description">Description</label>
            <textarea name="description" id="description" class="form-control" rows="4" required></textarea>
        </div>
        
        <button type="submit" class="btn btn-primary">Submit Request</button>
    </form>
</div>

<jsp:include page="../../common/footer.jsp" />
