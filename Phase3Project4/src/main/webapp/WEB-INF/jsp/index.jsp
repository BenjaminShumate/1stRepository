<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Startpoint JSP</title>
</head>
<body>
<h1><font color="red">${errorMessage}</font></h1>
<h2>Welcome to the User Id Retrieval Menu</h2>
<p>Please enter an id for the user to be retrieved. </p>
 <form action="getuser" method="post">
  <label for="label1">User ID: </label><br>
  <input type="text" id="label1" name="id"><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>