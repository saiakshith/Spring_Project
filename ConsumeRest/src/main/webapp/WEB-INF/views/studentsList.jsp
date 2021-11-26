<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Students List</title>
    <style>
      .error{
        color: red;
        }
      .headings {
          height: 70px;
          font-size: 25px;
          text-align: center;
          }
      .data{
         text-align: center;
      }
    </style>
  </head>
  <body>

  <h1> This is Students List Page</h1>

  <h4 class="error"> ${exception} </h4>

  <table  border=1>
    <tr class="headings">
      <th>Student ID</th>
      <th>Username</th>
      <th>Get Details</th>
    </tr>
  <c:forEach var="student" items="${studentsList}" >
    <tr class="data">
      <th>${student.id}</th>
      <th>${student.username}</th>
      <th> <a href="student/${student.id}/"> <h4> <a href="student/${student.id}/"> Get <c:out value="${student.username}"/> details</h4></th>
    </tr>
  </c:forEach>
  <table>

  <h1> Click Here To <a href="register">  go to Homepage </a> </h1> <br/>
  </body>
</html>