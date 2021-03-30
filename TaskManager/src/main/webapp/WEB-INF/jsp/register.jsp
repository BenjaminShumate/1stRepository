<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Menu</title>
</head>
<body>

<h1><font color="red">${errorMessage}</font></h1>
<h2>Welcome to the register menu!</h2>
<p>Please create a user.</p>

<form action="registeruser" method="post">
  <label for="label1">Name: </label><br>
  <input type="text" id="label1" name="name"><br>
  <label for="label2">Email: </label><br>
  <input type="text" id="label2" name="email"><br>
  <label for="label3">Password: </label><br>
  <input type="text" id="label3" name="password"><br>
  <input type="submit" value="Submit">
</form>

<a href="login">Click here to return to the login menu</a>

</body>
</html>