<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>View Tasks Menu</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>

<body>

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
</table><br>

<a href="gousermenu">Click me to return to the user menu</a>

</body>
</html>
