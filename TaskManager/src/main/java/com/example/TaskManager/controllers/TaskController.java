package com.example.TaskManager.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.TaskManager.entities.*;
import com.example.TaskManager.services.TaskService;

@Controller
public class TaskController {
	static User user;
	static List<Task> staticTasks;
	
	@Autowired 
	private TaskService taskService;
	
	@GetMapping(value="/goviewtasks")
	public String viewTasks(ModelMap model) {
	model.put("tasks", taskService.retrieveTasks(user));
		return "viewtasks";
	}
	
	@GetMapping(value="/gocreatetasks")
	public String goCreateTaskView(ModelMap model) {
		return "createtasks";
	}
	
	@PostMapping(value="/createtask")
	public String createNewTask(ModelMap model, @RequestParam String taskName, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String description, @RequestParam String severity) throws ParseException {
		
		if(taskName.equals("") || description.equals("") || severity.equals("")) {
			model.put("errorMessage", "Every field must have a value");
			return "createtasks";
		} 
		
		Task task = new Task(taskName, startDate, endDate, description, severity, user);
		taskService.addTask(task);
		model.put("notification", "Your task has been added");
		return "createtasks";
	}
	
	@GetMapping(value="/goupdatetasks")
	public String goUpdateTasks(ModelMap model) {
		
		model.put("tasks", taskService.retrieveTasks(user));
		return "updatetasks";
	}
	
	@PostMapping(value="/updatetask")
	public String taskUpdate(ModelMap model, @RequestParam String id, @RequestParam String taskName, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String description, @RequestParam String severity) {
		
		model.put("tasks", taskService.retrieveTasks(user));
		
		if(id.equals("") || taskName.equals("") || description.equals("") || severity.equals("")) {
			model.put("errorMessage", "Every field must have a value");
			return "updatetasks";
		} 
		
		int intId = taskService.verifyId(id);
		
		if(intId == -1) {
			model.put("errorMessage", "You did not enter an integer in the task id field");
		} else if(intId == -2) {
			model.put("errorMessage", "You entered a task id that doesn't exist");
		} else {
			taskService.updateTask(intId, taskName, startDate, endDate, description, severity);
			model.put("message", "your task has been updated");
		}
		model.put("tasks", taskService.retrieveTasks(user));
		return "updatetasks";
	}
	
	@GetMapping(value="/godeletetasks")
	public String goDeleteTasks(ModelMap model) {
		
		model.put("tasks", taskService.retrieveTasks(user));
		return "deletetasks";
	}
	
	@PostMapping(value="/deletetask")
	public String deleteTask(ModelMap model, @RequestParam String id) {
		
		model.put("tasks", taskService.retrieveTasks(user));
		
		if(id.equals("")) {
			model.put("errorMessage", "You have to enter a task id");
			return "deletetasks";
		}
		
		int intId = taskService.verifyId(id);
		if(intId == -1) {
			model.put("errorMessage", "You did not enter an integer");
		} else if(intId == -2) {
			model.put("errorMessage", "You entered a task id that doesn't exist");
		} else {
			taskService.deleteTask(intId);
			model.put("message", "Your task has been deleted");
		}
		model.put("tasks", taskService.retrieveTasks(user));
		return "deletetasks";
	}	
}
