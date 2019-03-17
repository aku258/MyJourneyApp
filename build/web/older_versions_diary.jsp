<%-- 
    Document   : older_versions_diary
    Created on : Mar 17, 2019, 9:32:48 AM
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
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    </head>
    <body>
        <a  class="waves-effect waves-light btn" href="displayBlog.do?blogn=${bloglist.get(bloglist.size()-1).getBlogname()}" >Back</a>
    <c:forEach items="${bloglist}" var="blog">
        <h4>${blog.getVersion_id()}</h4>
        <p>${content.get(blog)}</p>    
    </c:forEach>
    </body>
</html>
