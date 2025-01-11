<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h1 class="section-title">Available Apartments</h1>
    
    <div class="apartment-list">
        <c:forEach var="apartment" items="${apartments}">
            <div class="apartment-item">
                <div class="apartment-image">
                    <img src="${pageContext.request.contextPath}/assets/${apartment.imagePath}" 
                         alt="${apartment.name}" 
                         class="img-fluid" />
                </div>
                
                <h3>${apartment.name}</h3>
                <p><strong>Address:</strong> ${apartment.address}</p>
                <p><strong>Rooms:</strong> ${apartment.rooms}</p>
                <p><strong>Rent:</strong> $${apartment.rent}</p>
                
                <a href="<c:url value='/apartments/details?apartmentId=${apartment.id}' />" 
                   class="btn btn-primary">
                   View Details
                </a>
                <form action="${pageContext.request.contextPath}/apartments/rent" method="post">
                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input type="hidden" name="apartmentId" value="${apartment.id}">
                    <input type="text" name="name" placeholder="Your Name" required>
                    <input type="text" name="phone" placeholder="Your Phone" required>
                    <button type="submit" class="btn btn-success">Rent</button>
                </form>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="../../common/footer.jsp" />