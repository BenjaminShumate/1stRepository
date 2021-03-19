<!DOCTYPE jsp>
<html>
<head>
<meta charset="UTF-8">
<title>Phase2HibernateProject</title>
</head>
<body>
<h2>Welcome to the add product JSP now using Hibernate!</h2>
<p>Please enter an unused integer product id, dollar integer cost, and provide a description for your product.<p>
<form action="MyServlet" method="post">
  <label for="label1">Product ID: </label><br>
  <input type="text" id="label1" name="id"><br>
  <label for="label2">Price: </label><br>
  <input type="text" id="label2" name="price"><br>
   <label for="label3">Description: </label><br>
  <input type="text" id="label3" name="description"><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>
