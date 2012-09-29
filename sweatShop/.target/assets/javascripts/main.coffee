# main.js using RequireJS 2.0.1
require.config paths:
  
  #Major libraries
  jquery: "jquery/1.7.1/jquery-min"
  underscore: "underscore/1.3.1-amdjs/underscore-min" # AMD support
  backbone: "backbone/0.9.1-amdjs/backbone-min" # AMD support
  # Require.js plugins
  text: "require/2.0.1/text"
  domReady: "require/2.0.1/domReady"
  
  # Just a short cut so we can put our html outside the js dir
  # When you have HTML/CSS designers this aids in keeping them out of the js directory        
  templates: "templates"

# optional, using RequireJS domReady plugin
require ["domReady", "app"], (domReady, app) ->
  domReady ->
    app.initialize()