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

<h1> Student Updated Successfully With the Given Details .... </h1> <br/>

  <h1>Student Id : <c:out value = "${student.id}"/><p> </h1> <br/>
  <h1>Student username : <c:out value = "${student.username}"/><p> </h1> <br/>
  <h1>Student Email : <c:out value = "${student.email}"/><p> </h1> <br/>
  <h1>Student Password : <c:out value = "${student.password}"/><p> </h1> <br/>
  <h1>Student Gender : <c:out value = "${student.gender}"/><p> </h1> <br/>
  <h1>Student Country : <c:out value = "${student.country}"/><p> </h1> <br/>
  <h1>Student Age : <c:out value = "${student.age}"/><p> </h1>

Click Here To <h1> <a href="/ConsumeRest/register">  go to Homepage </a> </h1> <br/>

</body>
</html>