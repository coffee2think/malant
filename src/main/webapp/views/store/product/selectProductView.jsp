<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="store.product.model.vo.ProductDetail, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="/malant/resources/store/css/selectProduct.css" />
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.5.1/nouislider.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/15.5.1/nouislider.min.js"></script>
<script>
//1번 드롭다운 메뉴
function populateDropdown1() {
    console.log("Dropdown 1이 변경되었습니다.")
    var dropdown1 = document.getElementById("dropdown1");
    var selectedOption = dropdown1.options[dropdown1.selectedIndex].value;

    // 2번 드롭다운 메뉴 초기화
    var dropdown2 = document.getElementById("dropdown2");
    dropdown2.innerHTML = "";
    
    var dropdown3 = document.getElementById("dropdown3");
    dropdown3.innerHTML = "";

    // 2번 드롭다운 메뉴의 옵션을 설정
    var options2 = [];
    if (selectedOption === "식물") {
        options2 = ["일조량", "공기정화", "가습효과", "크기", "용도"];
    } else if (selectedOption === "화분") {
        options2 = ["재질", "크기"];
    } else if (selectedOption === "자갈/모래/흙") {
        options2 = ["재질", "크기"];
    }

    // 2번 드롭다운 메뉴에 옵션을 추가
    for (var i = 0; i < options2.length; i++) {
        var option = document.createElement("option");
        option.value = options2[i];
        option.text = options2[i];
        dropdown2.appendChild(option);
    }

    // 첫 번째 드롭다운 메뉴가 선택되었을 때만 두 번째 드롭다운 메뉴를 표시
    if (selectedOption !== "전체") {
        dropdown2.style.display = "inline"; // 나타나게 함
    } else {
        dropdown2.style.display = "none"; // 숨김 처리
    }

    // 2번 드롭다운 메뉴가 변경될 때 세 번째 드롭다운 메뉴를 나타나게 하고 해당 메뉴의 옵션 값을 설정
    dropdown2.addEventListener("change", function () {
        var selectedOption2 = dropdown2.options[dropdown2.selectedIndex].value;
        var dropdown3 = document.getElementById("dropdown3");
        dropdown3.innerHTML = "";

        // 3번 드롭다운 메뉴의 옵션을 설정
        var options3 = [];
        if (selectedOption2 === "난이도") {
            options3 = ["초보", "경험자", "전문가"];
        } else if (selectedOption2 === "일조량") {
            options3 = ["직사광선", "간접광선"];
        } else if (selectedOption2 === "습도") {
            options3 = ["습한환경", "보통", "건조한환경"];
        } else if (selectedOption2 === "크기") {
            options3 = ["소형", "중형", "대형"];
        } else if (selectedOption2 === "용도") {
            options3 = ["관상용", "식용", "조경용"];
        } else if (selectedOption2 === "재질") {
            options3 = ["세라믹", "도자기", "플라스틱", "대리석", "시멘트", "고무"];
        }

        // 3번 드롭다운 메뉴에 옵션을 추가
        for (var j = 0; j < options3.length; j++) {
            var option3 = document.createElement("option");
            option3.value = options3[j];
            option3.text = options3[j];
            dropdown3.appendChild(option3);
        }

        // 두 번째 드롭다운 메뉴가 선택되었을 때만 세 번째 드롭다운 메뉴를 표시
        if (selectedOption2 !== "필터2") {
            dropdown3.style.display = "inline";
        } else {
            dropdown3.style.display = "none";
        }
    });
}

// 초기화
populateDropdown1();

</script>

<style>
.dropdown {
	width: 200px;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.slider-container {
	width: 300px;
	margin-top: 10px;
}

.slider {
	width: 100%;
	height: 20px
}

#priceLabel {
	margin-top: 5px;
	text-align: center;
}
</style>


</head>
<body>
<body>
	<div class="container">
		<!-- 사이드바 -->
		<%@ include file="../common/storeSidebar.jsp"%>

		<div class="content">
			<div class="dropdownFilter">
				<select id="dropdown1" class="dropdown"
					onchange="populateDropdown1()">
					<option value="전체">전체</option>
					<option value="식물">식물</option>
					<option value="화분">화분</option>
					<option value="자갈/모래/흙">자갈/모래/흙</option>
					<option value="영양제/비료">영양제/비료</option>
					<option value="식물조명">식물조명</option>
					<option value="기타">기타</option>

				</select> <select id="dropdown2" class="dropdown">
					<option value="필터2"></option>
					
				</select> <select id="dropdown3" class="dropdown">
					<option value="필터3"></option>
				</select>


			</div>
			<div class="productcontainer">
				<%
				for (ProductDetail p : pdetail) {
				%>
				<div class="product-card"
					onclick="javascript:location.href='/malant/pdetail?productid=<%=p.getProductId()%>';">
					<img class="product-image" src="<%=p.getThumbnailImg()%>">
					<div class="product-name"><%=p.getProductName()%></div>
					<div class="product-price"><%=p.getPrice() + "원"%></div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>