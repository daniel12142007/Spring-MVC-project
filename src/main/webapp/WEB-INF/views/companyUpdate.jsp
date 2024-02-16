<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 15.02.2024
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company</title>
    <link rel="icon" href="https://i.pinimg.com/originals/4c/59/7c/4c597cf47850dbba17339cdc6b4e9fd4.jpg">
</head>
<body>
<div class="all">
    <form action="/update/${update.id}" method="post">
        <label for="name">Name</label><br>
        <input name="name" id="name" type="text" value="${update.companyName}"><br>
        <label for="located">Located</label><br>
        <input name="located" id="located" type="text" value="${update.locatedCountry}"><br><br>
        <button id="create">Finish</button>
    </form>
    <a href="/">
        <button>
            Back
        </button>
    </a>
</div>
</body>
<style>
    a {
        text-decoration: none;
    }

    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color: #f0f0f0;
    }

    .all {
        background-color: white;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
        margin-bottom: 150px;
    }

    table,
    th {
        border-bottom: 1px solid #000;
        margin-bottom: 20px;
    }

    button {
        display: inline-block;
        padding: 10px 18px;
        font-size: 16px;
        color: black;
        background-color: white;
        border: 1px solid black;
        border-radius: 5px;
        background-size: 56.57px 56.57px;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
    }

    button:hover {
        background: black;
        color: white;
    }

    #create:hover {
        background: rgb(6, 183, 6);
        color: white;
    }

    label {
        display: block;
        margin-bottom: 5px;
        color: #333;
    }

    input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 15px;
        transition: border-color 0.3s ease;
    }

    input:focus {
        border-color: #000000;
        outline: none;
    }
</style>
</html>