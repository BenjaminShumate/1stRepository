<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<table border="1">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Artist</th>
			<th>Price</th>
			<th>Release Date</th>
			<th>Genre</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var = "album" items="${albums}">
			<tr>
         	<td>${album.id}</td>
         	<td>${album.name}</td>
         	<td>${album.artist}</td>
         	<td>${album.price}</td>
         	<td>${album.release_date}</td>
         	<td>${album.genre_name}</td>
        	</tr>
      	</c:forEach>
     </tbody>
</table><br>

<form action="create" method="post">
    <label for="name">Album Name: </label><br>
  	<input type="text" id="name" name="name" required><br>
 	<label for="artist">Artist: </label><br>
  	<input type="text" id="artist" name="artist" required><br>
  	<label for="price">Price: </label><br>
  	<input type="text" id="price" name="price" required><br>
  	<label for="release_date">Release Date: </label><br>
  	<input type="date" id="release_date" name="release_date" required><br>
  	<label for="genre">Genre: </label><br>
  	<input type="text" id="genre" name="genre_name" required><br>
  	<input type="submit" value="Add Album">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
</form><br>

<form action="update" method="post">
	<label for="id">ID: </label><br>
  	<input type="number" id="id" name="id" required><br>
    <label for="name">Album Name: </label><br>
  	<input type="text" id="name" name="name" required><br>
 	<label for="artist">Artist: </label><br>
  	<input type="text" id="artist" name="artist" required><br>
  	<label for="price">Price: </label><br>
  	<input type="text" id="price" name="price" required><br>
  	<label for="release_date">Release Date: </label><br>
  	<input type="date" id="release_date" name="release_date" required><br>
  	<label for="genre">Genre: </label><br>
  	<input type="text" id="genre" name="genre_name" required><br>
  	<input type="submit" value="Edit Album">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 	
</form><br>
<form action="delete" method="post">
	<p>Which album do you want to delete?</p>
	<label for="id">ID: </label><br>
  	<input type="number" id="id" name="id" required><br>
  	<input type="submit" value="Delete">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  	
</form><br>
<a href="search.jsp">Click here to search table</a>
</body>
</html>