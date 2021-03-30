<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Delete Tasks Menu</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>

<body>

<h1><font color="green">${message}</font></h1>
<h1><font color="red">${errorMessage}</font></h1>
<h2>Welcome to your task table!</h2>

<table style="width:100%">
<tr>
  <th>Task Id</th>
   <th>Task Name</th>
  <th>Start Date</th> 
  <th>End Date</th>
  <th>Task Severity</th>
  <th>Description</th>
</tr>
	${tasks}
</table>

<p>Your tasks have been displayed above.</p>
<p>Please enter the task id of the task you would like to delete below.</p>

<form action="deletetask" method="post">
  <label for="label1">Task Id: </label><br>
  <input type="text" id="label1" name="id"><br>
  <input type="submit" value="Submit">
</form><br>

<a href="gousermenu">Click me to return to the user menu</a>

</body>
</html>