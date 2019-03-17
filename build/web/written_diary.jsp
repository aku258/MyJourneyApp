<%-- 
    Document   : writings
    Created on : Mar 9, 2019, 10:07:41 PM
    Author     : hp
--%>

<%@page import="java.sql.Blob"%>
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
                    <li><a href="#" id="diary" class='active-tab123'>Diary</a></li>
                  <li><a href="load_data.do?type=travel" id="travel">Travel</a></li>
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
                                <c:choose>
                                    <c:when test="${diaryname.getIs_diary() == 0}">
                                        <img src="images/diary_image.jpg" width="300" height="300" alt=""/>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty diaryname.getImage()}">
                                                <img src="images/diary_image.jpg" width="300" height="300" alt=""/>
                                            </c:when>
                                            <c:otherwise>
                                                <img src="data:image/jpeg;base64,${diaryname.getImage()}" width="300" height="300" />
                                            </c:otherwise>
                                            </c:choose>    
                                    </c:otherwise>
                                </c:choose>                             
                                                <span class="card-title"><a href="displayDiary.do?dname=${diaryname.getDiaryname()}" class="white-text"><c:out value="${diaryname.getDiaryname()}" /></a></span>
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
