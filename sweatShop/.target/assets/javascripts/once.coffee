define (require) ->

  $ = require 'jquery'
  _ = require 'underscore'
  aboutView = require 'views/aboutView'
  taskView = require 'views/taskView'

  createAboutView = ->
    return new aboutView()

  createTaskView = ->
    return new taskView()
    
  getAboutView : _.once(createAboutView)
  getTaskView : _.once(createTaskView)