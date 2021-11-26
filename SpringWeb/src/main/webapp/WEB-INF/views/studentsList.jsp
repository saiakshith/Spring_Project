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
  </head>
  <body>

  <h1> This is Students List Page</h1>

  <c:forEach var="student" items="${studentsList}" >
    <a href="student/${student.id}/"> <h1>Click Here To Get <c:out value="${student.username}"/> details</h1>
    <a href="api/student/${student.id}/"> <h1>Click Here To Get <c:out value="${student.username}"/> details JSON Format</h1>
  </c:forEach>

  <h1> Click Here To <a href="/SpringWeb/register">  go to Homepage </a> </h1> <br/>
  </body>
</html>