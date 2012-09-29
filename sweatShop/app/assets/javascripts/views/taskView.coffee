define (require) ->

  $ = require 'jquery'
  _ = require 'underscore'
  Backbone = require 'backbone'
  taskCollection = require 'collections/taskCollection'
  taskModel = require 'models/taskModel'
  taskListTemplate = require 'text!templates/taskListTemplate.html'  

  class taskListView extends Backbone.View
  
    el: $("#page")

    init: ->
      @taskCollection = new taskCollection()
      @taskCollection.bind 'reset', @render, @ 
      @taskCollection.bind 'remove', @render, @ 
      @refreshData()

    events:
      "click .removeTask": "removeTask" 
      "click .addTask": "addTask" 

    addTask: ->
      newTaskModel = new taskModel()
      newTaskModel.set "label", $("#inputLabel").val()
      @taskCollection.create newTaskModel, success: (model, response) =>
        @refreshData()
        error: (model, response) ->        
          console.log 'ERROR' + response
      return false

    removeTask: (event) ->
      taskId = $(event.currentTarget).attr 'id'    
      ## destroy the model
      modelToDestroy = @taskCollection.get taskId
      ## remove the model from the collection
      @taskCollection.remove(modelToDestroy);
      modelToDestroy.url = 'backbonetasks/' + taskId
      modelToDestroy.destroy()

    refreshData: ->
      @taskCollection.fetch()

    render: ->
      data =
        taskList : @taskCollection.models
        _: _

      compiledTemplate = _.template taskListTemplate, data
      @$el.html compiledTemplate

  return taskListView