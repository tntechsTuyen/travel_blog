<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Custom Swagger UI</title>
    <link rel="stylesheet" type="text/css" href="static/plugins/swagger/css/swagger-ui.css" >
    <link rel="stylesheet" type="text/css" href="static/plugins/swagger/css/swagger.css" >
    <link rel="stylesheet" type="text/css" href="webjars/springfox-swagger-ui/css/reset.css" >
    <link rel="stylesheet" type="text/css" href="webjars/springfox-swagger-ui/css/screen.css" >
    <link rel="stylesheet" type="text/css" href="webjars/springfox-swagger-ui/css/print.css" >
  </head>

  <body class="swagger-section">
    <div class="top-nav-bar">
      <a class="nav-bar-icon"><img src="swagger-favicon-32x32.png"></a>
      <a class="nav-bar-title"><b>X name</b></a>
      <select class="classic nav-bar-select" id="service-selector" onchange="changeSwaggerUI()">
        <option value="v2/api-docs?group=public-api">X service</option>
      </select>
    </div>
    <div style="margin-top: 100px" id="swagger-ui-container" class="swagger-ui-wrap"></div>

  <script src='webjars/springfox-swagger-ui/lib/jquery-1.8.0.min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/jquery.slideto.min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/jquery.wiggle.min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/jquery.ba-bbq.min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/handlebars-2.0.0.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/underscore-min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/backbone-min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/swagger-ui.min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/highlight.7.3.pack.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/jsoneditor.min.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/marked.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/lib/swagger-oauth.js' type='text/javascript'></script>
  <script src='webjars/springfox-swagger-ui/springfox.js' type='text/javascript'></script>
    <script>
      function changeSwaggerUI(){
        let selected_service_swaggerURL = document.getElementById("service-selector").value;
        loadUI(selected_service_swaggerURL);
      }

      function loadUI(swaggerJsonURL){
        // Begin Swagger UI call region
        const ui = SwaggerUi({
          url: swaggerJsonURL,
          validatorUrl: "",
          dom_id: '#swagger-ui-container',
          deepLinking: true,
          docExpansion: 'none',
          plugins: [
            CustomTopbarPlugin
          ],
          layout: "StandaloneLayout"
        });
        // End Swagger UI call region

        window.ui = ui
      }

      function CustomTopbarPlugin() {
        // this plugin overrides the Topbar component to return nothing
        return {
          components: {
            Topbar: () => null
          }
        }
      }

      window.onload = function() {
        loadUI("v2/api-docs?group=public-api");
      }
  </script>
  </body>
</html>