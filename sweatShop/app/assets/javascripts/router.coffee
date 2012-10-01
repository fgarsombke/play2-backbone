define (require) ->

  $ = require 'jquery'
  _ = require 'underscore'
  Backbone = require 'backbone'
  once = require 'once'  
  
  AppRouter = Backbone.Router.extend

    routes:
      '*actions': 'defaultAction'
    
    defaultAction: (actions) ->
      ##@aboutView = once.getAboutView()
      ##@aboutView.render()      

      taskView = once.getTaskView()
      taskView.init()      

  initialize: ->
    app_router = new AppRouter()
    Backbone.history.start()
    @