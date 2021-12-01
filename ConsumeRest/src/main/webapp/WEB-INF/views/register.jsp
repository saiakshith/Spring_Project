<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Student Registration</title>
    <style>
      .error {
        color: red;
        }
    </style>
  </head>
  <body>

  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/ConsumeRest/register">Home | Refresh </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ConsumeRest/getAllStudents">Students-List</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ConsumeRest/about">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ConsumeRest/contact">Contact</a>
        </li>
      </ul>
      <span class="navbar-item text-light">
        <a class="nav-link" href="#">Log In</a>
      </span>
    </div>
  </nav>

  <h4 class="error"> ${exception} </h4>

    <h1> Register Student Here..... </h1> <br/>

  <form:form action="createStudent" method="post" modelAttribute="consumeStudent">

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

  <input type="submit" value="Create Student" />

  </form:form>
  <br/>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>

</html>