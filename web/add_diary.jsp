<%-- 
    Document   : add_diary
    Created on : Mar 12, 2019, 4:28:14 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <title>New Diary</title>
        <script>  
            $(document).ready(function(){
            $('.modal').modal();
            });
        </script>
        <link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
        <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
        <script>
        function readURL(input) {
          if (input.files && input.files[0]) {
              var reader = new FileReader();

              reader.onload = function (e) {
                  $('#image')
                      .attr('src', e.target.result)
                      .width(150)
                      .height(200);
              };

              reader.readAsDataURL(input.files[0]);
          }
        }
        </script>
        <style>
          article, aside, figure, footer, header, hgroup, 
          menu, nav, section { display: block; }
        </style>
    </head>
    <body>
            <div class='row'>
               <div class="col s5 right-align"> 
                   <a  class="waves-effect waves-light btn modal-trigger" href="#modal_diary">Add Diary</a>        
               </div>
                <div class="col s3 right-align"> 
                   <a  class="waves-effect waves-light btn" href="blogtype.do" >Add Blog</a>
               </div>
            </div>

<!-- add diary modal-->
        <div id="modal_diary" class="modal">
          <div class="modal-content">
            <h4>New Diary</h4>
      <div class="card  center">
        <div class="card-content ">
          <span class="card-title center ">New Diary</span>
          <form method="post" enctype="multipart/form-data" action="AddTimeline.do">
           
           <div class="input-field ">
          <input id="d_name" name="d_name" type="text" class="validate">
          <label for="d_name">diary name</label>
        </div>
              <div>
           <img id="image"/>
           Cover Image for diary (optional):
           <input type='file' name="image_file" onchange="readURL(this);" />
           
              </div>
        
              <input id="submit" type="submit" value="Create diary" class="waves-effect waves-light btn" >
        </form>
          </div>
      </div>
          </div>
          <div class="modal-footer">
            <a href="#!" class="modal-close waves-effect waves-green btn-flat">Cancel</a>
          </div>
        </div>        

    </body>
</html>
