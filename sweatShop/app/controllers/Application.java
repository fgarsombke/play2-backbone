package controllers;

import static play.libs.Json.fromJson;
import static play.libs.Json.toJson;

import java.util.List;

import javax.inject.Inject;

import models.Task;

import org.codehaus.jackson.JsonNode;

import play.mvc.Controller;
import play.mvc.Result;
import services.TaskService;
import views.html.index;

public class Application extends Controller {

  @Inject public Application( TaskService taskService) {
    this.taskService = taskService;
  }
  
  private TaskService taskService; 
  
  public Result index() {
    return ok(index.render(Task.all()));
  }

  public Result backbonetasks() {
    List<Task> tasks = taskService.getTasks();
    return ok(toJson(tasks));
  }

  public Result deleteBackboneTask(Long id) {
    Task.delete(id);
    return ok();
  }

  public Result newBackboneTask() {
    JsonNode json = request().body().asJson();
    Task task = fromJson(json, Task.class);
    Task.create(task);
    return ok();
  }
}