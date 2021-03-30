<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Menu</title>
</head>
<body>

<h1><font color="green">${message}</font></h1>
<h1><font color="red">${errorMessage}</font></h1>
<h2>Welcome to the login menu!</h2>
<p>Please enter your login credentials.</p>

<form action="getuser" method="post">
  <label for="label2">Email: </label><br>
  <input type="text" id="label2" name="email"><br>
  <label for="label3">Password: </label><br>
  <input type="text" id="label3" name="password"><br>
  <input type="submit" value="Submit">
</form><br>

<a href="register">Click here to register a new user</a>

</body>
</html>