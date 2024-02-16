<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 15.02.2024
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course</title>
    <link rel="icon" href="https://i.pinimg.com/originals/4c/59/7c/4c597cf47850dbba17339cdc6b4e9fd4.jpg">
</head>
<body>
<div class="all">
    <table>
        <th>ID</th>
        <th>Course name</th>
        <th>Duration</th>
        <th>Groups</th>
        <th>Teacher</th>
        <th>DELETE</th>
        <th>UPDATE</th>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.id}</td>
                <td>${course.courseName}</td>
                <td>${course.duration}</td>
                <td>
                    <a href="">
                        <button>
                            GROUPS
                        </button>
                    </a>
                </td>
                <td>
                    <a href="">
                        <button>
                            TEACHER
                        </button>
                    </a>
                </td>
                <td>
                    <a href="/course/controller/delete/${course.id}/${id}">
                        <button id="delete">
                            DELETE
                        </button>
                    </a>
                </td>
                <td>
                    <a href="/course/controller/update/form/${course.id}/${id}">
                        <button id="update">
                            UPDATE
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/course/controller/form/${id}">
        <button id="create">
            Create
        </button>
    </a>
    <a href="/course/controller/clear/${id}">
        <button id="clear">
            Clear
        </button>
    </a>
    <a href="/">
        <button>
            Back company
        </button>
    </a>
</div>
</body>
<style>
    a {
        text-decoration: none;
    }

    .all {
        position: absolute;
        top: 100px;
        left: 28%;
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

    #clear:hover, #delete:hover {
        background: red;
        color: white;
    }

    #update:hover {
        background: #de750f;
        color: white;
    }

    #create:hover {
        background: rgb(6, 183, 6);
        color: white;
    }
</style>
</html>