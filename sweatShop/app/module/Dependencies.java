package module;

import play.Play;
import services.TaskService;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.typesafe.plugin.inject.InjectPlugin;

public class Dependencies {
  
  public static InjectPlugin inject() {
    return Play.application().plugin(InjectPlugin.class);
  }  

  public static controllers.Application application() {
    return inject().getInstance(controllers.Application.class);
  }
  
  @Provides 
  @Singleton
  public TaskService makeTaskService() {
    return new TaskService();
  }  
}