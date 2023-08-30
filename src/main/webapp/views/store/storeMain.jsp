<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- index.jsp -->
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Malant</title>
    <link rel="stylesheet" href="/malant/resources/common/css/scrolling.css" />
    <link rel="stylesheet" href="/malant/resources/store/css/storeMain.css" />

    <script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
    <script src="/malant/resources/common/js/scroll_behavior.js"></script>
    <script src="/malant/resources/common/js/scroll_loading.js"></script>
  </head>
  <body>
    <div class="container">
    	<!-- 사이드바 -->
        <%@include file = "./common/storeSidebar.html"%>
        <div class="main-content">
        <!--  배너 -->
        <%@include file = "./main/banner.jsp" %>
        </div>
    </div>
  </body>
</html>
