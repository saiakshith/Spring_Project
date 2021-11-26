<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<h1> Student Created Successfully......... </h1> <br/>

<h1><c:out value="${student.username}"> </c:out> </h1>
<h1><c:out value="${student.email}"> </c:out> </h1>
<h1><c:out value="${student.password}"> </c:out> </h1>
<h1><c:out value="${student.country}"> </c:out> </h1>
<h1><c:out value="${student.gender}"> </c:out> </h1>
<h1><c:out value="${student.age}"> </c:out> </h1>
<h1><c:out value="${student}"> </c:out> </h1> <br/>

Click Here To <h1> <a href="/SpringWeb/register">  go to Homepage </a> </h1> <br/>

</body>
</html>