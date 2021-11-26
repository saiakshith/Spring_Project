<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Student Update</title>
  </head>
  <style>
      .error {
          color: red;
          }
  </style>
  <body>

  <h4 class="error"> ${exception} </h4>

  <h1> This is Student Update Page </h1>

      <form:form action="/ConsumeRest/updateSuccess" method="post" modelAttribute="consumeStudent">

      <form:hidden path="id" />

       <label for="exampleInputEmail1" class="form-label">Username :</label>
       <form:input type="text" path="username" />  <br/>
       <form:errors path="username" cssClass="error" />  <br/> <br/>

      <label for="exampleInputEmail1" class="form-label">Email address :</label>
      <form:input type="email" path="email" /> <br/>
      <form:errors path="email" cssClass="error" /> <br/> <br/>

      <label for="exampleInputPassword1" class="form-label">Password :</label>
      <form:password path="password" />  <br/>
      <form:errors path="password" cssClass="error" />  <br/> <br/>

      <label class="form-label">Country :</label>
      <form:select path="country" items="${countryList}" />  <br/>
      <form:errors path="country" cssClass="error"/>  <br/> <br/>

      <label class="form-label">Gender :</label>
      <form:radiobutton path="gender" value="Male" label="Male" />
      <form:radiobutton path="gender" value="Female" label="Female" />   <br/>
      <form:errors path="gender" cssClass="error" /> <br/> <br/>

      <label class="form-label">Age :</label>
      <form:input type="number" path="age" />  <br/>
      <form:errors path="age" cssClass="error" />  <br/> <br/>

      <input type="submit" value="Update Student" />

      </form:form>
       <br/>

      <h1> <a href="/ConsumeRest/update/${consumeStudent.id}"> Click Here to Refresh </a> </h1> <br/>

      <h1> <a href="/ConsumeRest/register"> Click Here to go to Homepage </a> </h1> <br/>

  </body>
</html>