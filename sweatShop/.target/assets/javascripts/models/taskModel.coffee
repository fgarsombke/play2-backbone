define (require) ->

  $ = require 'jquery'
  _ = require 'underscore'
  Backbone = require 'backbone'

  class taskModel extends Backbone.Model

  return taskModel