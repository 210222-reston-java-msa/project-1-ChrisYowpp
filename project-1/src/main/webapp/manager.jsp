<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home Page</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
    integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>

<body>
  <div class="jumbotron">
    <h1 id = "welcome">You are Logged in!</h1>
    <a class = "btn btn success" onclick = "logout()">Logout</a>
    <a class = "btn btn success" onclick = "employee()">Employee</a>
    <a class = "btn btn success" onclick = "manager()">Manager</a>

  </div>

  <script>
    let welcome = document.getElementById('welcome');
    let userString = session.getItem('currentUser');

    if (userString === null) {
      window.location = "http://localhost:8080/project-1/";
    } else {
      let currentUser = JSON.parse(userString);
      console.log(currentUser);

      if (currentUser != null) {
        welcome.innerHTML = "Welcome " + currentUser.firstName + " " + currentUser.lastName;
      }
    }

    function logout() {
      let xhr = new XMLHttpRequest();

      xhr.open("POST", "http://localhost:8080/project-1/logout");

      xhr.send();

      sessionStorage.removeItem('currentUser');
      window.location = "http://localhost:8080/project-1/logout";
    }

    function employee() {
      window.location = "http://localhost:8080/project-1/employee.html";
    }

    function manager() {

      window.location = "http://localhost:8080/project-1/manager.html";
    }
  </script>
</body>
</html>