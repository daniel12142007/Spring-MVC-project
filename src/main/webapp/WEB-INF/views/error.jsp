<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 15.02.2024
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<div class="error-container">
    <h1 class="big-text">${title}</h1>
    <h1 class="small-text">${description}</h1>
</div>
</body>
<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f0f0f0;
        margin: 0;
    }

    .error-container {
        text-align: center;
        position: relative;
        top: -140px;
    }

    .big-text {
        font-size: 250px;
        color: rgb(255, 0, 0);
        margin: 0;
    }

    .small-text {
        font-size: 30px;
        color: rgb(255, 0, 0);
        margin: 0;
    }
</style>
</html>