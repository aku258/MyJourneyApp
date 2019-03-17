<%-- 
    Document   : display_diary
    Created on : Mar 14, 2019, 1:43:52 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${diary_name}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="colors.css" rel="stylesheet" type="text/css"/>
    <link href="footer.css" rel="stylesheet" type="text/css"/>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    </head>
    <body>
         <header>
            <%@include file="navbar.jsp" %>
        </header>
        <main>
            <nav>
              <div class="nav-wrapper grey darken-4">
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="#" id="diary" class='active-tab123'>Diary</a></li>
                  <li><a href="load_data.do?type=travel" id="travel">Travel</a></li>
                  <li><a href="load_data.do?type=food" id="food">Food</a></li>
                </ul>
              </div>
            </nav>
            <a class="btn" href="load_data.do?type=${type}">Back</a>
            <div>
                <h1>${diary_name}</h1>
            </div>
            <a  class="waves-effect waves-light btn" href="blogtype.do" >Add Blog</a>
            <div class="row">
                <c:forEach items="${bloglist}" var="blog">
                    <h4 class="imperial_red">${blog}</h4>
                    <a  class="waves-effect waves-light btn" href="displayBlog.do?blogn=${blog}" >View</a>
                </c:forEach>
            </div>
        </main>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
