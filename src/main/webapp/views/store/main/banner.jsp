<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Malant Banner</title>
    <link rel="stylesheet" href="/malant/resources/common/css/scrolling.css" />
    <link rel="stylesheet" href="/malant/resources/store/css/banner.css" />
    <script src="/first/resources/js/jquery-3.7.0.min.js"></script>
    
    <script>
        $(document).ready(function () {
            $.ajax({
                url: "/malant/mbanner",
                type: "get",
                dataType: "json",
                success: function (data) {
                    console.log("success : " + data);
                    var str = JSON.stringify(data);
                    var json = JSON.parse(str);

                    for (var i in json.list) {
                        var banner = json.list[i];
                        
                        var currentDate = new Date();
                        var bannerStart = new Date(banner.bstart);
                        var bannerEnd = new Date(banner.bend);
                        
                        if (currentDate >= bannerStart && currentDate <= bannerEnd) {
                            var bannerElement = $("<a>").attr("href", banner.blink)
                                                      .append($("<img>").attr("src", banner.bimage)
                                                                       .attr("alt", "Banner Image"));
                            $("#banner-container").append(bannerElement);
                        }
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
                }
            });
        });
    </script>
  </head>
  <body>
    <div id="banner-container" class="banner">
      <!-- 배너가 동적으로 추가될 영역입니다. -->
    </div>
  </body>
</html>
