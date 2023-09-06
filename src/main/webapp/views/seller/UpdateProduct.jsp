<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	//1번 옵션
	function populateDropdown1() {
		console.log("Dropdown 1이 변경되었습니다.")
		var dropdown1 = document.getElementById("dropdown1");
		var selectedOption = dropdown1.options[dropdown1.selectedIndex].value;

		// 드롭다운 메뉴 초기화
		var dropdown2 = document.getElementById("dropdown2");
		dropdown2.innerHTML = "";

		var dropdown3 = document.getElementById("dropdown3");
		dropdown3.innerHTML = "";

		var dropdown4 = document.getElementById("dropdown4");
		dropdown4.innerHTML = "";

		var dropdown5 = document.getElementById("dropdown5");
		dropdown5.innerHTML = "";

		var dropdown6 = document.getElementById("dropdown6");
		dropdown6.innerHTML = "";

		var dropdown7 = document.getElementById("dropdown7");
		dropdown7.innerHTML = "";

		var dropdown8 = document.getElementById("dropdown8");
		dropdown8.innerHTML = "";

		// 2~8번 드롭다운 메뉴의 옵션을 설정
		var options2 = [];
		var options3 = [];
		var options4 = [];
		var options5 = [];
		var options6 = [];
		var options7 = [];
		var options8 = [];
		if (selectedOption === "식물") {
			options2 = [ "난이도", "초보자", "경험자", "전문가" ];
			options3 = [ "일조량", "직사광선", "간접광선" ];
			options4 = [ "습도", "습한환경", "보통", "건조한환경" ];
			options5 = [ "정화능력", "유", "무" ]
			options6 = [ "가습효과", "유", "무" ]
			options7 = [ "크기", "소형", "중형", "대형" ]
			options8 = [ "용도", "관상용", "식용", "조경용" ]
		} else if (selectedOption === "화분") {
			options2 = [ "재질", "세라믹", "도자기", "플라스틱", "대리석", "시멘트", "고무" ];
			options3 = [ "크기", "소형", "중형", "대형", "특대" ];
		} else if (selectedOption === "자갈/모래/흙") {
			options2 = [ "종류", "자연토양", "인공토양" ];
		}

		// 옵션에 추가
		for (var i = 0; i < options2.length; i++) {
			var option = document.createElement("option");
			option.value = options2[i];
			option.text = options2[i];
			dropdown2.appendChild(option);
		}
		for (var i = 0; i < options3.length; i++) {
			var option = document.createElement("option");
			option.value = options3[i];
			option.text = options3[i];
			dropdown3.appendChild(option);
		}
		for (var i = 0; i < options4.length; i++) {
			var option = document.createElement("option");
			option.value = options4[i];
			option.text = options4[i];
			dropdown4.appendChild(option);
		}
		for (var i = 0; i < options5.length; i++) {
			var option = document.createElement("option");
			option.value = options5[i];
			option.text = options5[i];
			dropdown5.appendChild(option);
		}
		for (var i = 0; i < options6.length; i++) {
			var option = document.createElement("option");
			option.value = options6[i];
			option.text = options6[i];
			dropdown6.appendChild(option);
		}
		for (var i = 0; i < options7.length; i++) {
			var option = document.createElement("option");
			option.value = options7[i];
			option.text = options7[i];
			dropdown7.appendChild(option);
		}
		for (var i = 0; i < options8.length; i++) {
			var option = document.createElement("option");
			option.value = options8[i];
			option.text = options8[i];
			dropdown8.appendChild(option);
		}

		// 첫 번째 옵션이 선택되었을 때만 옵션들 표시
		if (selectedOption !== "전체") {
			dropdown2.style.display = "inline";
			dropdown3.style.display = "inline";
			dropdown4.style.display = "inline";
			dropdown5.style.display = "inline";
			dropdown6.style.display = "inline";
			dropdown7.style.display = "inline";
			dropdown8.style.display = "inline";
		} else {
			dropdown2.style.display = "none";
			dropdown3.style.display = "none";
			dropdown4.style.display = "none";
			dropdown5.style.display = "none";
			dropdown6.style.display = "none";
			dropdown7.style.display = "none";
			dropdown8.style.display = "none";
		}
	}

	document.getElementById("dropdown1").addEventListener("change", function() {
		populateDropdown1();
	});

	// 초기화
	populateDropdown1();
</script>
<style>
.dropdown {
	width: 100px;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
}
</style>
</head>
<body>
    <div class="content">
        <form action="/malant/sellpinsert" method="post" enctype="multipart/form-data">
            <div class="dropdownFilter">
                <select id="dropdown1" class="dropdown" onchange="populateDropdown1()" name="option1">
                    <option value="식물">식물</option>
                    <option value="화분">화분</option>
                    <option value="자갈/모래/흙">자갈/모래/흙</option>
                    <option value="영양제/비료">영양제/비료</option>
                    <option value="식물조명">식물조명</option>
                    <option value="기타">기타</option>
                </select>
                <select id="dropdown2" class="dropdown" name="option2"></select>
                <select id="dropdown3" class="dropdown" name="option3"></select>
                <select id="dropdown4" class="dropdown" name="option4"></select>
                <select id="dropdown5" class="dropdown" name="option5"></select>
                <select id="dropdown6" class="dropdown" name="option6"></select>
                <select id="dropdown7" class="dropdown" name="option7"></select>
                <select id="dropdown8" class="dropdown" name="option8"></select>
            </div>
            <br>
            <label for="product_name">상품명:</label>
            <input type="text" id="product_name" name="product_name"><br>
            <br>
            <label for="store_name">상점명:</label>
            <input type="text" id="store_name" name="store_name"><br>
            <br>
            <label for="price">가격:</label>
            <input type="text" id="price" name="price"><br>
            <br>
            <label for="shipping_cost">배송비:</label>
            <input type="text" id="shipping_cost" name="shipping_cost"><br>
            <br>
            <label for="thumbnail_image">대표이미지 (썸네일):</label>
            <input type="file" id="thumbnail_image" name="thumbnail_image"><br>
            <br>
            <label for="detail_images">세부이미지 (세부설명이 들어있는 이미지):</label>
            <input type="file" id="detail_images" name="detail_images"><br>
            <br>
            <label for="detail_description">세부내용 (텍스트내용):</label><br>
            <textarea id="detail_description" name="detail_description" rows="4" cols="50"></textarea>
            <br>
            <br>
            <input type="submit" value="등록">
        </form>
    </div>
</body>
</html>