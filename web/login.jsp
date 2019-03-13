<%-- 
    Document   : login
    Created on : Mar 9, 2019, 11:51:08 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Journey</title>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="colors.css" rel="stylesheet" type="text/css"/>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </head>
    <body class="black">
        
  <div class="row ">
      <div class="col s12 m3"></div>
    <div class="col s12 m6">
      <div class="card grey darken-4  center">
        <div class="card-content ">
            <span class="card-title center white-text">
                <img src="images/my_journey_logo.jpg" alt="" style="width: 20%"/></span>
          <span class="card-title center white-text">Login</span>
          <form method="post" action="login.do">
           
           <div class="input-field ">
          <input id="email" name="email" type="text" class="validate white-text">
          <label for="email">email</label>
        </div>
        <div class="input-field">
          <input id="password" name="password" type="password" class="validate white-text">
          <label for="password">Password</label>
        </div>
              <input id="submit" type="submit" value="Login" class="waves-effect waves-light btn" >
        </form>
      </div>
          

        <div class="card-action">
          <p class="white-text">Don't have an account?<p>
          <a href="./registration.jsp" class="waves-effect waves-light btn">Sign up</a>
        </div>
          </div>
      </div>
    </div>

  
    </body>
</html>
