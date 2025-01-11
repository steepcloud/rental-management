<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Apartment</title>
</head>
<body>
    <h1>Edit Apartment</h1>

    <form:form action="${pageContext.request.contextPath}/apartment/edit" method="post" modelAttribute="apartment">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        
        <form:hidden path="id" />
        
        <c:if test="${not empty error}">
            <div style="color: red;">
                <p>${error}</p>
            </div>
        </c:if>

        <div>
            <form:label path="name">Apartment Name:</form:label>
            <form:input path="name" required="true" />
            <c:if test="${not empty apartment.name}">
                <div style="color: red;">
                    <p>${error.name}</p>
                </div>
            </c:if>
        </div>

        <div>
            <form:label path="address">Address:</form:label>
            <form:input path="address" required="true" />
            <c:if test="${not empty apartment.address}">
                <div style="color: red;">
                    <p>${error.address}</p>
                </div>
            </c:if>
        </div>

        <div>
            <form:label path="rooms">Number of Rooms:</form:label>
            <form:input path="rooms" type="number" required="true" />
            <c:if test="${not empty apartment.rooms}">
                <div style="color: red;">
                    <p>${error.rooms}</p>
                </div>
            </c:if>
        </div>

        <div>
            <form:label path="rent">Rent Amount:</form:label>
            <form:input path="rent" type="number" step="0.01" required="true" />
            <c:if test="${not empty apartment.rent}">
                <div style="color: red;">
                    <p>${error.rent}</p>
                </div>
            </c:if>
        </div>

        <div>
            <form:label path="description">Description:</form:label>
            <form:textarea path="description" rows="4" cols="50" />
            <c:if test="${not empty apartment.description}">
                <div style="color: red;">
                    <p>${error.description}</p>
                </div>
            </c:if>
        </div>

        <div>
            <form:label path="imagePath">Apartment Image Path:</form:label>
            <form:input path="imagePath" required="true" />
            <c:if test="${not empty apartment.imagePath}">
                <div style="color: red;">
                    <p>${error.imagePath}</p>
                </div>
            </c:if>
        </div>

        <div>
            <button type="submit">Save Changes</button>
        </div>
    </form:form>

    <br>
    <a href="${pageContext.request.contextPath}/admin/apartments">Back to Apartment List</a>
    
    <footer>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Logout</button>
        </form>
    </footer>
</body>
</html>
