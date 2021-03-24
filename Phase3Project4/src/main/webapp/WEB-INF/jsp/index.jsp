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
<p>Please enter your first name. </p>
 <form action="getuser" method="post">
  <label for="label1">First name: </label><br>
  <input type="text" id="label1" name="fname"><br>
  <input type="submit" value="Submit"><br>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>