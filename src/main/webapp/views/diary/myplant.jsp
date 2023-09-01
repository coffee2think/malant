<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, myplant.model.vo.Myplant, java.sql.Date" %>   
<%
	ArrayList<Myplant> list = (ArrayList<Myplant>)request.getAttribute("list");	

	int nowpage = 1;
	if(request.getAttribute("currentPage") != null){
		nowpage = ((Integer)request.getAttribute("currentPage")).intValue();
	}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>malant</title>
<link rel="stylesheet" href="/malant/resources/common/css/scrolling.css" >
<link rel="stylesheet" href="/malant/resources/common/css/font.css" >
<link rel="stylesheet" href="/malant/resources/diary/css/myplant.css">
<style type="text/css">

</style>
<script src="/malant/resources/common/js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<div id="container">
        <%@include file = "../../views/common/sidebar.jsp" %>
	<div id="main">

		<div class="menu"><a href="/malant/views/diary/diary.jsp">다이어리</a></div> 
		<div class="menu"><a href="/malant/views/diary/calendar.jsp">캘린더</a></div> 
		<div class="menu"><a href="/malant/views/diary/myplant.jsp">반려식물</a></div>	

	    
	<div id="contentbody">   
	
	<div class="pagingview">
	<%@ include file="../diary/myplantPagingView.jsp" %>
	</div>
	
	<% if (list.size() > 0 ) { %>
		
		<div id="addYourPlant" class="addYourPlant"> 반려식물을 등록해주세요! </div>
			<form action="/malant/mpnew" method="post" enctype="multipart/form-data">
			<div id="myplantAdd" class="myplantAdd"> 반려식물 등록화면 (팝업)
	<!-- 			<form action="/first/binsert" method="post" enctype="multipart/form-data"> -->
					
					<div>애칭 &nbsp; <input type="text" name="myplantName"></div>
					<div>품종 &nbsp; <input type="text" name="myplantVariety"></div>
					<div>사진 &nbsp; <input type="file" name="myplantImageURL"></div>
					<div>메모 &nbsp; <input type="text" name="myplantMemo"></div>
					<div>키우기 시작한 날 &nbsp; <input type="date" name="myplantStartDate"></div>
					<div>함께한 날 &nbsp; </div>
					<div>성장환경 : 
						<div class="position"> 어떤 장소에서 키우나요 <br>
							<input type="radio" name="posWindow">창가 
							<input type="radio" name="posVeranda">베란다 
							<input type="radio" name="posDesk">책상
							<input type="radio" name="posYard">마당 
							<input type="radio" name="posGarden">텃밭 
						</div>
						<div class="environment"> 어떤 환경에서 키우나요 <br>
							<input type="radio" name="envSunny">볕이 좋은
							<input type="radio" name="envShady">그늘진 
							<input type="radio" name="envWindy">바람 부는
							<input type="radio" name="envDry">건조한
							<input type="radio" name="envHumid">습한
						</div>
						<div class="with"> 누구와 함께 키우나요 <br>
							<input type="radio" name="withPet">애완동물과함께
							<input type="radio" name="withPlant">식물들과함께
							<input type="radio" name="withChild">아이들과함께
							<input type="radio" name="withFriend">친구와함께
							<input type="radio" name="withAlone">혼자 
						</div>
					</div>
					<div>
						<input type="reset" class="close-btn" value="취소">
						<input type="submit" id="save" class="save-close-btn" value="저장">
					</div>
	
					</div> <!-- myplantAdd -->
					</form>

		<% for (Myplant mp : list) { %>
		
			<div id="myplantListbody">
			
				<div id="myplantbox" class="myplantbox"> 
						<div class="nickname">애칭 <%= mp.getMyplantName() %></div>
						<div class="image"><img src="#"></div>
						<div class="information">
							<div class="ID">ID : <%= mp.getMyplantId() %></div>
							<div class="variety">품종 : <%= mp.getMyplantVariety() %></div>
							<div class="Dday">함께한 날 : <%= mp.getMyplantStartDate() %></div>
							<div class="memo">메모 : <%= mp.getMyplantMemo() %></div>
						</div>
					</div><!-- myplantbox -->
	
				<div id="myplantDetail" class="myplantDetail"> 디테일화면 (팝업)
	<!-- 			<form action="/first/binsert" method="post" enctype="multipart/form-data"> -->
					
					<div>애칭: <%= mp.getMyplantName() %></div>
					<div>품종: <%= mp.getMyplantVariety() %></div>
					<div><img src="<%= mp.getMyplantImageURL() %>"></div>0
					<div>키우기 시작한 날: </div>
					<div>함께한 날: </div>
					<div>메모: <%= mp.getMyplantMemo() %></div>
					<div>성장환경 : 
						<div class="position">
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">창가 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">베란다 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">책상
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">마당 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">텃밭 
						</div>
						<div class="environment">
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">볕이 좋은
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">그늘진 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">바람 부는
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">건조한
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">습한
						</div>
						<div class="with">
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">애완동물과함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">식물들과함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">아이들과함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">친구와함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">혼자 
						</div>
					</div>
					<div>
						<button id="modify" class="modify" >수정</button>
						<button onclick="requestDelete(); return false;">삭제</button>
						<button class="close-btn">확인</button>	
					</div>
	
					</div> <!-- myplantDetail -->
					
					
					<form action="/malant/mpupdate" method="post" enctype="multipart/form-data">
					<div id="myplantModify" class="myplantModify"> 디테일 편집화면 (팝업)
	<!-- 			<form action="/first/binsert" method="post" enctype="multipart/form-data"> -->
					
					<div>애칭: <%= mp.getMyplantName() %></div>
					<div>품종: <%= mp.getMyplantVariety() %></div>
					<div><img src="<%= mp.getMyplantImageURL() %>"></div>0
					<div>키우기 시작한 날: </div>
					<div>함께한 날: </div>
					<div>메모: <%= mp.getMyplantMemo() %></div>
					<div>성장환경 : 
						<div class="position">
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">창가 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">베란다 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">책상
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">마당 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">텃밭 
						</div>
						<div class="environment">
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">볕이 좋은
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">그늘진 
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">바람 부는
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">건조한
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">습한
						</div>
						<div class="with">
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">애완동물과함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">식물들과함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">아이들과함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">친구와함께
							<input type="radio" readonly checked="<%= mp.getPosWindow() %>">혼자 
						</div>
					</div>
					<div>
						<button class="close-btn">취소</button>
						<button onclick="requestDelete(); return false;">삭제</button>
						<button class="save-close-btn">저장</button>	
					</div>
	
					</div> <!-- myplantModify -->
					</form>
						<% } %> <!-- for문 -->
					<!-- <div id="ovelay" ></div> -->
			</div> <!-- myplantListbody -->
			
		<% }else if(list.size() == 0) { %>
		
			<div id="addYourPlant" class="addYourPlant"> 반려식물을 등록해주세요! </div>
			
			<form action="/malant/mpnew" method="post" enctype="multipart/form-data">
			<div id="myplantAdd" class="myplantAdd"> 반려식물 등록화면 (팝업)
	<!-- 			<form action="/first/binsert" method="post" enctype="multipart/form-data"> -->
					
					<div>애칭: </div>
					<div>품종: </div>
					<div><img src="#"></div>0
					<div>키우기 시작한 날: </div>
					<div>함께한 날: </div>
					<div>메모: </div>
					<div>성장환경 : 
						<div class="position">
							<input type="radio" readonly >창가 
							<input type="radio" readonly >베란다 
							<input type="radio" readonly >책상
							<input type="radio" readonly >마당 
							<input type="radio" readonly >텃밭 
						</div>
						<div class="environment">
							<input type="radio" readonly >볕이 좋은
							<input type="radio" readonly >그늘진 
							<input type="radio" readonly >바람 부는
							<input type="radio" readonly >건조한
							<input type="radio" readonly >습한
						</div>
						<div class="with">
							<input type="radio" readonly >애완동물과함께
							<input type="radio" readonly >식물들과함께
							<input type="radio" readonly >아이들과함께
							<input type="radio" readonly >친구와함께
							<input type="radio" readonly >혼자 
						</div>
					</div>
					<div>
						<button class="close-btn">취소</button>
						<button class="save-close-btn">저장</button>	
					</div>
	
					</div> <!-- myplantAdd -->
				</form>
		<% } %>
		
	</div> <!-- content body  -->
	</div> <!-- main -->	
</div> <!-- container -->

 <script type="text/javascript" src="/malant/resources/diary/js/myplant.js"></script> 

</body>
</html>