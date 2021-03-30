<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Update Tasks Menu</title>
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
<p>Please enter the task id of the task you would like to update below.</p>
<p>Note the Task Id of the task you want to change must match with the above table.</p>

<form action="updatetask" method="post">
 <label for="taskid">Task Id:</label><br>
 <input type="text" id="taskid" name="id"><br>
 <label for="taskname">Task name:</label><br>
  <input type="text" id="taskname" name="taskName" ><br>
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

<a href="gousermenu">Click me to return to the user menu</a>

</body>
</html>