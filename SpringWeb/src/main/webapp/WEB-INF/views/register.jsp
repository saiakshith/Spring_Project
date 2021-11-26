<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Student Registration</title>
    <style>
        .error {
            color: red;
            }
    </style>
  </head>
  <body>

    <c:set var="countryList" value="${countryList}" scope="session" />

    <form:form action="success" method="post" modelAttribute="student">

     <form:hidden path="id" />

     <label for="exampleInputEmail1" class="form-label">Username :</label>
     <form:input type="text" path="username" />  <br/> <br/>
     <form:errors path="username" cssClass="error" />  <br/> <br/>

      <label for="exampleInputEmail1" class="form-label">Email address :</label>
      <form:input type="email" path="email" /> <br/> <br/>
      <form:errors path="email" cssClass="error" /> <br/> <br/>

      <label for="exampleInputPassword1" class="form-label">Password :</label>
      <form:password path="password" />  <br/> <br/>
      <form:errors path="password" cssClass="error" />  <br/> <br/>

    <label class="form-label">Country :</label>
    <form:select path="country" items="${countryList}" />  <br/> <br/>
    <form:errors path="country" cssClass="error"/>  <br/> <br/>

    <label class="form-label">Gender :</label>
    <form:checkbox path="gender" value="Male" label="Male" />
    <form:checkbox path="gender" value="Female" label="Female" />   <br/>
    <form:errors path="gender" cssClass="error" /> <br/> <br/>

    <label class="form-label">Age :</label>
    <form:input type="number" path="age" />  <br/> <br/>
    <form:errors path="age" cssClass="error" />  <br/> <br/>

      <input type="submit" value="Submit" />

    </form:form>
     <br/>

    <a href="/SpringWeb/register"> Click Here to Refresh </a> <br/>

     <br/>

    <a href="/SpringWeb/getAllStudents"> Click Here To Get All Students List  </a>
    <a href="/SpringWeb/api/getAllStudents"> Click Here To Get All Students List JSON Format</a>

  </body>
</html>