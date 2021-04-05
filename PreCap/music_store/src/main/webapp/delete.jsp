<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete an entry</title>
</head>
<body>
<form action="delete" method="Post">
	<p>Select the id and type of the object you want to delete.</p>
	<input type="radio" id="album" name="viewType" value="albums">
  	<label for="album">Albums</label><br>
  	<input type="radio" id="genre" name="viewType" value="genres">
  	<label for="genre">Genres</label><br>
  	<input type="radio" id="music" name="viewType" value="music">
  	<label for="music">Music</label>
 	<label for="id">ID: </label><br>
  	<input type="number" id="id" name="id"><br>
  	<input type="submit" value="Submit">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
</form>
</body>
</html>