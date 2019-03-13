<%-- 
    Document   : writings
    Created on : Mar 9, 2019, 10:07:41 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                    <li><a href="load_data.do?type=diary" id="diary" >Diary</a></li>
                  <li><a href="#" id="travel" class='active-tab123'>Travel</a></li>
                  <li><a href="load_data.do?type=food" id="food">Food</a></li>
                </ul>
              </div>
            </nav>
            <%@include file="add_diary.jsp" %>
                        <div class="row">
                <c:forEach items="${diarynames}" var="diaryname">
                    <div class="col s3">                        
                        <div class="card">
                            <div class="card-image">
                                <c:if test="${empty diaryname.getImage()}">
                                    <img src="images/diary_image.jpg" width="300" height="300" alt=""/>
                                </c:if>
                                <c:if test="${not empty diaryname.getImage()}">
                                    <img src="data:image/jpeg;base64,${diaryname.getImage()}" width="300" height="300" />
                                </c:if>
                                
                                <span class="card-title"><c:out value="${diaryname.getDiaryname()}" /></span>
                            </div>
                        </div>
                    </div>                    
                </c:forEach>
            </div>
        </main>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
