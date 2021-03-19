<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Display Users Page</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
  integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
  
    <table class="table table-dark">
    <thead>
    <tr><th scope="col">Username</th><th>First Name</th><th>Last Name</th><th>Email</th></tr>
    </thead>
    <c:forEach items="${ulist}" var="User">
    <tr>
      <td><c:out value="${User.uUsername}"/></td>
      <td><c:out value="${User.uFirstName}"/></td>
      <td><c:out value="${User.uLastName}"/></td>
      <td><c:out value="${User.uEmail}"/></td>
    </tr>
    </c:forEach>
    </table>
        
<div>
    <a class = "btn btn success" onclick = "logout()">Logout </a>
</div>

<script>
    function logout() {
      let xhr = new XMLHttpRequest();

      xhr.open("POST", "http://localhost:8080/project-1/logout");

      xhr.send();

      sessionStorage.removeItem('currentUser');
      window.location = "http://localhost:8080/project-1/logout";
    }
</script>

</body>
</html>

