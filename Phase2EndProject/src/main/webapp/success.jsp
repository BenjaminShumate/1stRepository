<!DOCTYPE jsp>
<html>
<head>
<meta charset="UTF-8">
<title>Success JSP</title>
</head>
<body>
<h1>Success!</h1>
<p>Welcome to the user menu.</p>
	<% 
	String id = response.getHeader("id");
	out.println("Your unique id is: " + id);
	%>
<br><br>
<a href=index.jsp>Click here to logout.</a>
</body>
</html>
