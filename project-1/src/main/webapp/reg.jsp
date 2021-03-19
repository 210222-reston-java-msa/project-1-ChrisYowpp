<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
    integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>

<body>
  
  <div class="container">
    <div class="row text-center" style="color: beige;">
    <h2>User Registry Page</h2>
    </div>
    <hr>
    <div class="row col-md-10 col-md-offset-3">
      <div class="card card-body">
        <h2>User Registration Form</h2>
        <div class="col-md-8 col-md-offset-3">
          <form action="<%=request.getContextPath()%>/register" method="POST">

            <div class="form-group">
              <label for="uname">User Name:</label>
              <input type="text" class="form-control" id="uname" placeholder="Username" name="username" required>
            </div>

            <div class="form-group">
              <label for="uname">First Name:</label>
              <input type="text" class="form-control" id="uname" placeholder="First Name" name="firstName" required>
            </div>

            <div class="form-group">
              <label for="uname">Last Name:</label>
              <input type="text" class="form-control" id="username" placeholder="Last Name" name="lastName" required>
            </div>

            <div class="form-group">
              <label for="uname">Password:</label>
              <input type="text" class="form-control" id="password" placeholder="Password" name="password" required>
            </div>
            
            <div class="form-group">
              <label for="uname">Email:</label>
              <input type="text" class="form-control" id="email" placeholder="Email" name="email" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>

          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>