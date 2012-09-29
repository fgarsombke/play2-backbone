define (require) ->

  $ = require 'jquery'
  _ = require 'underscore'
  Backbone = require 'backbone'
  taskModel = require 'models/taskModel'

  class taskCollection extends Backbone.Collection

    url: -> 'backbonetasks'
    model: taskModel

  return taskCollection