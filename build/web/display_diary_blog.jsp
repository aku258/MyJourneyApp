<%-- 
    Document   : display_diary_blog
    Created on : Mar 14, 2019, 12:51:47 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${blog.getBlogname()}</title>
               <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="colors.css" rel="stylesheet" type="text/css"/>
    <link href="footer.css" rel="stylesheet" type="text/css"/>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </head>
    <body>
        <div>
        <a  class="waves-effect waves-light btn" href="displayDiary.do?dname=${blog.getDiaryname()}" >Back to ${blog.getDiaryname()}</a>
        </div>
        <p>
            ${contents}
        </p>
        <div class="row s12 ">
            <div class="col s3">
                <form method="post" action="edit_blog.do">
                    <input type="hidden" name="blogn" value=${blog.getBlogname()}>
                    <input type="submit"  class="waves-effect waves-light btn white-text" value="Edit blog">
                </form>
            </div>
            <div class="col s4">
                <form method="post" action="older_versions.do">
                    <input type="hidden" name="dt_id" value=${blog.getDiary_id()}>
                    <input type="submit"  class="waves-effect waves-light btn white-text" value="Older versions">
                </form>
            </div>
                    &nbsp &nbsp &nbsp &nbsp &nbsp
            <div class="col s3">                
                <form method="post" action="deleteBlog.do">
                    <input type="hidden" name="dt_id" value=${blog.getDiary_id()}>
                    <input type="hidden" name="version_id" value=${blog.getVersion_id()}>
                    <input type="submit"  class="waves-effect waves-light btn white-text" value="Delete blog">
                </form>
            </div>
        </div>
    </body>
</html>
