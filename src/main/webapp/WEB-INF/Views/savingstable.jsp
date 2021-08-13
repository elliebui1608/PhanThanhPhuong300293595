<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 13/08/2021
  Time: 7:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Savings Investment Page</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

        .btn {

            width: 100%;
        }


    </style>
</head>
<body>
<h1>Savings Investment Record</h1>

<div class="container2">
    <h2>The following are the saving records..</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Customer number</th>
            <th>Customer Name</th>
            <th>Customer Deposit</th>
            <th>Number of years</th>
            <th>Saving type</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.custno}</td>
                <td>${todo.custname}</td>
                <td>${todo.cdep}</td>
                <td>${todo.nyears}</td>
                <td>${todo.savtype}</td>

                <td>    <a type="button" class="btn btn-primary"
                           href="update-todo?id=${todo.custno}, ${todo.custname}, ${todo.cdep}
                                            ${todo.nyears}" >Edit</a> </td>
                <td>    <a type="button" class="btn btn-primary"
                           href="delete-todo?id=${todo.savtype}" >Delete</a> </td>

                <td> <a type="button" class ="btn btn-primary" onmouseout="myFunction()"
                        href="see-todo?id=${todo.custno}">Project Investment</a></td>


            </tr>

        </c:forEach>
        </tbody>
    </table>

    <a class="btn btn-success" href="add-todo">Add</a>
</div>

<div class="container">

    <form method="GET">
        <div class="form-group">
            <label for="cno">Savings Code:</label>
            <input type="text" name="custno" class="form-control" id="cno" value="${id}">
        </div>
        <div class="form-group">
            <label for="cname">Description:</label>
            <input type="text" name="custname" class="form-control" id="cname" value="${name}">
        </div>
        <div class="form-group">
            <label for="ccdep">Savings Code:</label>
            <input type="text" name="cdep" class="form-control" id="ccdep" value="${dep}">
        </div>
        <div class="form-group">
            <label for="cnyears">Savings Code:</label>
            <input type="text" name="nyears" class="form-control" id="cnyears" value="${year}">
        </div>
        <div class="form-group">
            <label for="csavtype">Savings Code:</label>
            <input type="text" name="savtype" class="form-control" id="csavtype" value="${type}">
        </div>

        <a class="btn btn-success" href="add-todo">Add</a>

    </form>

    <h1 id = "mes">${errorMessage}</h1>


</div>

<script>

    function  myFunction(){
        document.getElementById("mes").innerHTML="";
    }

</script>

</body>
</html>
