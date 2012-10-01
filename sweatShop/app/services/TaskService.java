package services;

import java.util.List;

import models.Task;

public class TaskService {

	public List<Task> getTasks() {
	  return Task.all();
	}
	
	public void anotherMethod() {
	  
	}
	
}
