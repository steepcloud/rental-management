<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error - Application</title>
</head>
<body>

    <div style="text-align: center; margin-top: 50px;">
        <h1 style="color: red;">Oops! Something went wrong.</h1>
        <p>We are sorry, but an error occurred while processing your request.</p>

        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <h3>Error details: <%= error %></h3>
        <%
            }
        %>

        <p>Please try again later or <a href="/login">return to the login page</a>.</p>

        <p>If the problem persists, contact support for further assistance.</p>
    </div>

</body>
</html>
