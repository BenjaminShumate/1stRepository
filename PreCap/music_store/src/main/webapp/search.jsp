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

<form action="search" method="post">
	<p>Search by name</p>
	<label for="id">Album name: </label><br>
  	<input type="text" id="id" name="value" required><br>
  	<input type="submit" value="Search">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
  	<input type="hidden" name="column" value="name"/>	
</form><br>
<form action="search" method="post">
	<p>Search by artist</p>
	<label for="id">Artist: </label><br>
  	<input type="text" id="id" name="value" required><br>
  	<input type="submit" value="Search">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
  	<input type="hidden" name="column" value="artist"/>	
</form><br>
<form action="search" method="post">
	<p>Search by genre</p>
	<label for="id">Genre: </label><br>
  	<input type="text" id="id" name="value" required><br>
  	<input type="submit" value="Search">
  	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
  	<input type="hidden" name="column" value="genre"/> 	
</form><br>

<a href="index.jsp">Return to index</a>
</body>
</html>