package controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import models.Task;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import play.mvc.Result;
import services.TaskService;

public class ApplicationTest {

  @Mock private TaskService taskServiceMock;
  
  private Application impl;
  
  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    impl = new Application(taskServiceMock);
  }
  
  @Test
  public void testBackbonetasks() {
    List<Task> tasks = new ArrayList<Task>();
    when(taskServiceMock.getTasks()).thenReturn(tasks);
    Result result = impl.backbonetasks();
    verify(taskServiceMock).getTasks();
    verifyNoMoreInteractions(taskServiceMock);
    // Assert the results are what you are expecting (status code, data, etc.)
  }
}