package com.example.TaskManager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Task {

	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Integer id;
	   private String userName;
	   private String taskName;
	   private Date startDate;
	   private Date endDate;
	   private String severity;
	   private String description;
	   private String email;
	   
	   @ManyToOne
	   private User user;
	  
	public Task() {
		super();
	}
	   
	public Task(String taskName, Date startDate, Date endDate, String description, String severity, User user) {
		super();
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.severity = severity;
		this.description = description;
		this.email = user.getEmail();
		this.userName = user.getName();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return  "<tr><td>"+id+"</td><td>"+taskName+"</td><td>"+startDate+"</td><td>"+endDate+"</td><td>"+severity+"</td><td>"+description+"</td></tr>";
	}

}