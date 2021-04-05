<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Select the action you would like to perform.</h1>

<form action="readTables" method="post">
	<p>Select your desired view.</p>
	<input type="radio" id="album" name="viewType" value="albums">
  	<label for="album">Albums</label><br>
  	<input type="radio" id="genre" name="viewType" value="genres">
  	<label for="genre">Genres</label><br>
  	<input type="radio" id="music" name="viewType" value="music">
  	<label for="music">Music</label>
  	<input type="submit" value="Submit">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  	
</form><br>

<p>Alternatively you may: </p>
<a href="create.jsp">Create entry</a><br><br>
<a href="update.jsp">Update an Entry</a><br><br>
<a href="delete.jsp">Delete entry</a><br><br>

</body>
</html>