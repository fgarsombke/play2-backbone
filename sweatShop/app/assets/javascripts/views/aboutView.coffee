define (require) ->

  $ = require 'jquery'
  _ = require 'underscore'
  Backbone = require 'backbone'
  aboutTemplate = require 'text!templates/aboutTemplate.html'
  
  class aboutView extends Backbone.View
  
    el: $("#about")

    render: ->
      compiledTemplate = _.template aboutTemplate, $
      @$el.html compiledTemplate
  
  return aboutView