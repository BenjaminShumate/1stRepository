<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Task Menu</title>
</head>
<body>

<h1><font color="red">${errorMessage}</font></h1>
<h1><font color="green">${notification}</font></h1>
<h2>Welcome to the the task creation menu!</h2>
<p>Please fill in the form and click the submit button.</p>

<form action="createtask" method="post">
 <label for="taskname">Task name:</label><br>
  <input type="text" id="taskname" name="taskName"><br>
  <label for="sdate">Start Date:</label><br>
  <input type="date" id="sdate" name="startDate" value = "2021-01-01"><br>
  <label for="edate">End Date:</label><br>
  <input type="date" id="edate" name="endDate" value = "2021-01-01"><br>
  <label for="desc">Description:</label><br>
  <textarea id="desc" name="description" rows=10 cols=30></textarea><br>
  <label for="sev">Severity</label><br>
  <select id="sev" name="severity">
  	<option value="high">High</option>
  	<option value="medium">Medium</option>
  	<option value="low">Low</option>
  </select><br>
  <input type="submit" value="Submit">
</form><br>

<a href="gousermenu">Click here to return to user menu</a>
</body>
</html>