<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User information edit JSP</title>
</head>
<body>
<h1><font color="red">${errorMessage}</font></h1>
<h2>Hello: ${username} your current password is: ${password} and your id is: ${id}</h2>
<p>Please select a new username and password.</p>
<p>If you don't want to change some/all of your data then submit the current username and/or password.</p>
<form action="modify" method="post">
  <label for="label1">New Username: </label><br>
  <input type="text" id="label1" name="newUsername"><br>
  <label for="label2">New Password: </label><br>
  <input type="text" id="label2" name="newPassword"><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>