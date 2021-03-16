<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><font color="red">${errorMessage}</font></h1>
<h2>Welcome to the menu</h2>
<p>Enter something for the form</p>
  <form action="login" method="post">
  <label for="label1">Username: </label><br>
  <input type="text" id="label1" name="username"><br>
  <label for="label2">Password: </label><br>
  <input type="password" id="label2" name="password"><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>