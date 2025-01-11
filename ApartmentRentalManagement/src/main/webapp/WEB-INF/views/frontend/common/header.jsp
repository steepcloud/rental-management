<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Rental Apartment Management System">
    <meta name="author" content="RentApartment">
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/user.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/public.css" />
</head>
<body>
<header>
    <h1>Rental Apartment Management System</h1>
    
    <c:if test="${not empty sessionScope.username}">
        <span>Logged in as: ${sessionScope.username}</span>
        <a href="<c:url value='/public/logout' />" class="logout-btn">Logout</a>
    </c:if>
</header>
