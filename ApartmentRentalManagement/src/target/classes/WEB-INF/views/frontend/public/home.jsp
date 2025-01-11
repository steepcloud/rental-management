<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/header.jsp" />
<jsp:include page="../common/navbar.jsp" />

<div class="hero">
    <h1>Welcome to Our Platform!</h1>
    <p>Your go-to solution for modern and efficient technology.</p>
    <a href="<c:url value='/public/about' />" class="btn btn-light">Learn More</a>
</div>

<div class="container">
    <h2 class="section-title">Features</h2>
    <ul class="feature-list">
        <li>User-friendly interfaces and designs</li>
        <li>Reliable and secure systems</li>
        <li>24/7 customer support</li>
    </ul>

    <h2 class="section-title">Get Started</h2>
    <p class="get-started">
        Ready to explore? <a href="<c:url value='/user/dashboard' />" class="btn btn-primary">Log in</a> or 
        <a href="<c:url value='/public/register' />" class="btn btn-secondary">register</a> to access all features.
    </p>
</div>

<jsp:include page="../common/footer.jsp" />
