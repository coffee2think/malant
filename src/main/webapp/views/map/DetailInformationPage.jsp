<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>수목원 정보</title>
  <style type="text/css">
    body {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .tree-title {
      width: 300px;
      padding: 10px;
      border: 1px solid #ccc;
      background-color: #f5f5f5;
      box-sizing: border-box;
      text-align: center;
      margin-bottom: 10px;
    }

    .info-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
    }

    .tree-card {
      width: calc(50% - 20px);
      max-width: 400px; /* 최대 너비 설정 */
      padding: 10px;
      border: 1px solid #ccc;
      background-color: #f5f5f5;
      box-sizing: border-box;
      text-align: center;
      margin: 10px;
    }
    
    .info-content {
   	  margin-top: 5px;
      text-align: left;
      max-width: 100%; /* 내용의 최대 너비 설정 */
    }
  </style>
</head>
<body>
  <div class="tree-title">
    <h2 id="name">국립백두대간수목원</h2>
  </div>
  <div class="info-container">
    <div class="tree-card">
      <h2 id="address">주소</h2>
    	<div class="content">봉화군 춘양면 춘양로 1501</div>
    </div>
    <div class="tree-card">
      <h2 id="website">홈페이지</h2>
      	<div class="content"><a href="http://www.sjna.or.kr">www.sjna.or.kr</a></div>
    </div>
    <div class="tree-card">
      <h2 id="phone">전화번호</h2>
      	<div class="content">044-251-0001</div>
    </div>
    <div class="tree-card">
      <h2 id="entranceFee">입장료</h2>
      	<div class="info-content">여/부 : Y 
	      <br>성인 : 5000
	      <br>청소년 : 4000
	      <br>어린이입장료 : 3000
	      <br>장애인 : 0
	      <br>기타 : 무료(만 6세 이하, 65세 이상, 장애인, 국가유공자, 기초수급자, 다자녀가족, 국군의날 입장하는 군인, 어린이날 입장하는 어린이 등), 세종시민(50%할인), 다문화가정(50%할인), 20인 이상 단체(20%할인)
      	</div>
    </div>
    <div class="tree-card">
      <h2 id="openClose">Open/Close</h2>
	      <div class="info-content">개관 : 화요일,수요일,목요일,금요일,토요일,일요일
	      	<br>휴관 : 월요일,기타,1월1일,설/추석 당일,월요일이 공휴일인 경우 그 다음날 휴관
	      </div>
    </div>
    <div class="tree-card">
      <h2 id="companion">동반 입장</h2>
      <div class="info-content">반려동물 동반 : N
      	<br>안내견 동반 : Y
      </div>
    </div>
    <div class="tree-card">
      <h2 id="education">교육프로그램</h2>
      <div class="info-content">교육프로그램 운영 여부 : Y
      	<br>교육프로그램명 : 사계절 전시 온실 오디오가이드, 수목원 해설 프로그램, 이야기가 있는 스탬프 투어 
      	<br>교육프로그램 예약 여/부 : Y
      </div>
    </div>
  </div>
</body>
</html>