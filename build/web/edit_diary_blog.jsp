<%-- 
    Document   : edit_diary_blog
    Created on : Mar 17, 2019, 7:18:02 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="colors.css" rel="stylesheet" type="text/css"/>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
    function adjustHeight(el){
    el.style.height = (el.scrollHeight > el.clientHeight) ? (el.scrollHeight)+"px" : "60px";
    }   
    </script>
    </head>
    <body>
        <form id="new_blog" method="post" enctype="multipart/form-data" action="add_blog.do">  
            <div class="input-field ">
                <input id="blog_name" name="blog_name" type="text" class="validate" value="${blog.getBlogname()}">
                <label for="blog_name">${blog.getDiaryname()}</label>
            </div>
                <textarea name="contents" onkeyup="adjustHeight(this)" form="new_blog">${contents}</textarea>
          
              <input id="submit" type="submit" value="Save blog" class="waves-effect waves-light btn" >
        </form>
    </body>
</html>
