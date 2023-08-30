<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<<<<<<< HEAD
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<style>

.slick-container {
	width: 100%;
	height: 300px;
	position: relative;
}

.slick-prev, .slick-next {
	font-size: 0;
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	z-index: 1;
	cursor: pointer;
	opacity: 0;
	transition: opacity 0.3s;
	background: none;
    border: none;
}

.slick-prev:hover,
.slick-next:hover {
    opacity: 0.5;
}

.slick-prev:before {
    content: "<"; 
    font-size: 20px; 
    line-height: 1; 
    color: black;
}

.slick-next:before {
content: ">"; 
    font-size: 20px; 
    line-height: 1; 
    color: black;

}

.slick-prev {
	left: 20px;
}

.slick-next {
	right: 20px;
}

.slick-dots {
	position: absolute;
	bottom: 5px;
	width: 100%;
	text-align: center;
	display : none;
}

.slick-dots li {
	display: inline-block;
	margin: 3px;
	font-size: 0;
}

.slick-dots li button {
	width: 10px;
	height: 10px;
	border-radius: 50%;
	background-color: #bbb;
	border: none;
	cursor: pointer;
	font-size: 0;
}

.slick-dots li.slick-active button {
	background-color: #333;
}
}
</style>
<script>
	$(document).ready(
			function() {
				function loadBanners() {
					$.ajax({
						url : "/malant/mbanner",
						method : "GET",
						dataType : "json",
						success : function(data) {
							var banners = data.list;
							banners.sort(function(a, b) {
								return a.bannerPrority - b.bannerPrority; // 우선순위대로 정렬
							});

							var bannercontainer = $("#bannerContainer");
							bannercontainer.empty();

							for (var i = 0; i < banners.length; i++) {
								var banner = banners[i];

								var bannerLink = $("<a>").attr("href",
										banner.blink);
								var bannerImage = $("<img>").addClass(
										"banner-image").attr("src",
										banner.bimage).attr("alt",
										"Banner Image");
								bannerLink.append(bannerImage);
								bannercontainer.append(bannerLink);
							}
							$('.slick-container').slick({
						        autoplay: true, // 자동 슬라이딩 활성화
						        autoplaySpeed: 3000, // 자동 슬라이딩 간격 (3초)
						        arrows: true, // 화살표 on/off
						        dots: true // 점 on/off
							 });
						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log("error : " + jqXHR + ", " + textStatus
									+ ", " + errorThrown);
						}
					});
				}
				loadBanners();
			});
	
</script>
<script>
$(document).ready(function() {
    $.ajax({
        url: '서버의_데이터를_받을_URL', // 실제 서버에서 데이터를 제공하는 URL로 변경해야 함
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            // 받아온 데이터를 이용하여 화면에 표시
            var productContainer = $('.product-list');
            data.list.forEach(function(product) {
                var productCard = $('<div>').addClass('product-card');
                $('<img>').attr('src', product.thumbnail).attr('alt', 'Product Thumbnail').appendTo(productCard);
                $('<h3>').text(product.productname).appendTo(productCard);
                $('<p>').text(product.simpleExp).appendTo(productCard);
                $('<p>').text(product.price + '원').appendTo(productCard);
                productCard.appendTo(productContainer);
            });
        },
        error: function(xhr, textStatus, errorThrown) {
            console.log('Error:', textStatus);
        }
    });
});
</script>

</head>
<body>
	<div id="bannerContainer" class="slick-container"></div>
	<br><br>
        <span class = "allproduct">전체상품</span>  
        <hr><br>
</body>
</html>
=======
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
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
