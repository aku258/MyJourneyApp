<%-- 
    Document   : navbar
    Created on : Mar 9, 2019, 2:34:50 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="colors.css" rel="stylesheet" type="text/css"/>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </head>
    <body >
          <nav>
            <div class="nav-wrapper bg-green">
              <a href="" class="brand-logo">
              <img src="images/my_journey_logo.jpg" alt="" style='height: 80%; width: 11.5%;'/></a>
              <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="load_data.do?type=diary" id="writingmenu">Writings</a></li>
                <li><a href="./About.jsp"  id="aboutmenu">About Us</a></li>
                <li><a href="./profile.jsp" id="profilemenu">Profile</a></li>
              </ul>
            </div>
          </nav>
           
    </body>
</html>
