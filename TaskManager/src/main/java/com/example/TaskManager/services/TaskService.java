package com.example.TaskManager.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.entities.Task;
import com.example.TaskManager.entities.User;
import com.example.TaskManager.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public String retrieveTasks(User user){
			List<Task> userTasks = new ArrayList<Task>();
			Iterable<Task> allTasks = taskRepository.findAll();
			for( Task t : allTasks) {
				if(t.getUser().getEmail().equals(user.getEmail())){
					userTasks.add(t);
				}
			}
			return userTasks.toString().replace(",", "").replace("[", "").replace("]","").replace("00:00:00.0", "");
	}
	
	public void addTask(Task task) {
		taskRepository.save(task);
	}
	
	public void deleteTask(int id) {
		Task task = taskRepository.findById(id).get();
		taskRepository.delete(task);
	}
	
	public int verifyId(String id) {
		try {
			int intId = Integer.parseInt(id);
			taskRepository.findById(intId).get();
			return intId;
			} catch(java.lang.NumberFormatException e) {
				return -1;
			} catch (java.util.NoSuchElementException ex) {
				return -2;
			}
	}
	
	public void updateTask(int id, String taskName, Date startDate, Date endDate, String description, String severity) {

		Task task = taskRepository.findById(id).get();
		task.setTaskName(taskName);
		task.setStartDate(startDate);
		task.setEndDate(endDate);
		task.setDescription(description);
		task.setSeverity(severity);
		taskRepository.save(task);
	}
}
