<%-- 
    Document   : registration
    Created on : Mar 10, 2019, 1:11:49 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="colors.css" rel="stylesheet" type="text/css"/>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
        var check = function() {
  if (document.getElementById('password').value ==
    document.getElementById('confirm_pass').value) {
    document.getElementById('message').style.color = 'green';
    document.getElementById('message').innerHTML = 'matching';
  } else {
    document.getElementById('message').style.color = 'red';
    document.getElementById('message').innerHTML = 'not matching';
  }
}
    </script>
    </head>
       <body class="black">
        
  <div class="row ">
      <div class="col s12 m3"></div>
    <div class="col s12 m6">
      <div class="card grey darken-4  center">
        <div class="card-content ">
            <span class="card-title center white-text">
                <img src="images/my_journey_logo.jpg" alt="" style="width: 20%"/></span>
          <span class="card-title center white-text">Registration</span>
          <form method="post" action="register.do">
           <div class="input-field ">
          <input name="name" type="text" class="validate white-text">
          <label for="name">Name</label>
        </div>
          <div class="input-field ">
          <input name="email" type="email" class="validate white-text">
          <label for="email">Email</label>
        </div>
            <div class="input-field ">
          <input name="phone" type="tel" class="validate white-text">
          <label for="phone">Mobile no.</label>
        </div>
        <div class="input-field">
          <input id="password" name="password" type="password" class="validate white-text">
          <label for="password">Password</label>
        </div>
          <div class="input-field">
          <input id="confirm_pass" type="password" class="validate white-text" onkeyup='check();'>
          <label for="confirm_pass">Confirm Password</label>
        </div>
          <div id="message"></div>
          <input id="submit" type="submit" value="Sign Up" class="waves-effect waves-light btn" >
          </form>
      </div>        
        <div class="card-action">
          <p class="white-text">Already have an account?<p>
          <a class="waves-effect waves-light btn">Login</a>
        </div>
          </div>
      </div>
    </div>
        
    </body>
</html>
