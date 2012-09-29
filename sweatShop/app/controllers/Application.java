package controllers;

import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;

import java.util.List;

import models.Task;

import org.codehaus.jackson.JsonNode;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

  static Form<Task> taskForm = form(Task.class);

  public static Result index() {
    // return ok("Foobar! Your new application is ready.");
    // return ok(index.render("Foobar! Your new application is ready."));
    return redirect(routes.Application.tasks());
  }

  public static Result tasks() {
    return ok(index.render(Task.all(), taskForm));
  }

  public static Result backbonetasks() {
    List<Task> tasks = Task.all();
    return ok(toJson(tasks));
  }

  public static Result deleteBackboneTask(Long id) {
    Task.delete(id);
    return ok();
  }

  public static Result newBackboneTask() {
    JsonNode json = request().body().asJson();
    Task task = fromJson(json, Task.class);
    Task.create(task);
    return ok();
  }

  public static Result newTask() {
    Form<Task> filledForm = taskForm.bindFromRequest();
    if (filledForm.hasErrors()) {
      return badRequest(views.html.index.render(Task.all(), filledForm));
    } else {
      Task.create(filledForm.get());
      return redirect(routes.Application.tasks());
    }
  }

  public static Result deleteTask(Long id) {
    Task.delete(id);
    return redirect(routes.Application.tasks());
  }
}