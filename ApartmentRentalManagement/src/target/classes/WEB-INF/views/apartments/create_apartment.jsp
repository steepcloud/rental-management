<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Apartment</title>
</head>
<body>
    <h1>Create a New Apartment</h1>

    <form action="${pageContext.request.contextPath}/apartment/create" method="post" enctype="multipart/form-data" onsubmit="validateForm(event)">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <c:if test="${not empty error}">
            <div style="color: red;">
                <p>${error}</p>
            </div>
        </c:if>

        <div>
            <label for="name">Apartment Name:</label>
            <input type="text" id="name" name="name" value="${apartment.name}" required>
            <c:if test="${not empty apartment.name}">
                <div style="color: red;">
                    <p>${error.name}</p>
                </div>
            </c:if>
        </div>

        <div>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${apartment.address}" required>
            <c:if test="${not empty apartment.address}">
                <div style="color: red;">
                    <p>${error.address}</p>
                </div>
            </c:if>
        </div>

        <div>
            <label for="rooms">Number of Rooms:</label>
            <input type="number" id="rooms" name="rooms" value="${apartment.rooms}" required>
            <c:if test="${not empty apartment.rooms}">
                <div style="color: red;">
                    <p>${error.rooms}</p>
                </div>
            </c:if>
        </div>

        <div>
            <label for="rent">Rent Amount:</label>
            <input type="number" id="rent" name="rent" step="0.01" value="${apartment.rent}" required>
            <c:if test="${not empty apartment.rent}">
                <div style="color: red;">
                    <p>${error.rent}</p>
                </div>
            </c:if>
        </div>

        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" cols="50">${apartment.description}</textarea>
            <c:if test="${not empty apartment.description}">
                <div style="color: red;">
                    <p>${error.description}</p>
                </div>
            </c:if>
        </div>

        <div>
            <label for="image_path">Apartment Image Path:</label>
            <input type="text" id="image_path" name="imagePath" value="${apartment.imagePath}" required>
            <c:if test="${not empty apartment.imagePath}">
                <div style="color: red;">
                    <p>${error.imagePath}</p>
                </div>
            </c:if>
        </div>

        <div>
            <button type="submit">Create Apartment</button>
        </div>
    </form>

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
