<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Student Details</title>
  </head>
  <body>

  <h1> This is Student Details Page </h1>

            <h1>Student Id : <c:out value = "${student.id}"/><p> </h1> <br/>
            <h1>Student Id : <c:out value = "${student.username}"/><p> </h1> <br/>
            <h1>Student Id : <c:out value = "${student.email}"/><p> </h1> <br/>
            <h1>Student Id : <c:out value = "${student.password}"/><p> </h1> <br/>
            <h1>Student Id : <c:out value = "${student.gender}"/><p> </h1> <br/>
            <h1>Student Id : <c:out value = "${student.country}"/><p> </h1> <br/>
            <h1>Student Id : <c:out value = "${student.age}"/><p> </h1>

   Click Here To <h1> <a href="/SpringWeb/delete/${student.id}"> Delete ${student.username} </a> </h1>  <br/>
   Click Here To <h1>  <a href="/SpringWeb/update/${student.id}"> Update ${student.username} </a> </h1>  <br/>
        Click Here to go to    <a href="/SpringWeb/register"> Home Page </a>
  </body>
</html>