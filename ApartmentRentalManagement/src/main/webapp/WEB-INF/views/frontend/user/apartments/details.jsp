<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../common/header.jsp" />
<jsp:include page="../../common/navbar.jsp" />

<div class="container">
    <h2>${apartment.name}</h2>
    <div class="apartment-details">
        <img src="${pageContext.request.contextPath}/assets/${apartment.imagePath}" 
             alt="${apartment.name}" 
             class="apartment-image" />
        
        <p><strong>Address:</strong> ${apartment.address}</p>
        <p><strong>Rooms:</strong> ${apartment.rooms}</p>
        <p><strong>Rent:</strong> $${apartment.rent}</p>
        <p><strong>Description:</strong> ${apartment.description}</p>
    </div>
</div>

<jsp:include page="../../common/footer.jsp" />