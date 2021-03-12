<!DOCTYPE jsp>
<html>
<head>
<meta charset="UTF-8">
<title>Register JSP</title>
</head>
<body>
<h1>Welcome to the registration page</h1>
<p>Please enter a new username, password, and your favorite color.</p>
<form action="RegisterServlet" method="post">
<label for="label1">Username: </label><br>
  <input type="text" id="label1" name="username"><br>
  <label for="label2">Password: </label><br>
  <input type="password" id="label2" name="password"><br>
<input type="submit" value="Register"/>
</form>
<br><a href=index.jsp>Click here to return to the login page.</a><br>
</body>
</html>
