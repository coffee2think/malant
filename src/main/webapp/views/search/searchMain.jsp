<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.search-main {
		width: 800px;
		height: 500px;
		border:1px solid green;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		margin: auto;
	}
	
	.search-area {
		width: 800px;
		height: 130px;
		border: 1px solid green;
		margin-top: 10px;
		margin-bottom: 10px;
		display: flex;
		flex-direction: column;
		align-content: center;
		justify-content: center;
	}
	
	.searchbar {
		width: 800px;
		height: 50px;
		border: 1px solid blue;
		padding-top: 10px;
		padding-bottom: 10px;
		display: flex;
		align-content: center;
		justify-content: center;
	}

	.searchbox {
		width: 700px;
		height: 50px;
		text-align: center;
	}

	.searchbtn {
		width: 50px;
		height: 50px;
	}
	
	.filters {
		width: 800px;
		height: 50px;
		border: 1px solid blue;
		display: flex;
		justify-content: center;
		align-content: center;
	}
	
	.filter {
		width: 100px;
		height: 40px;
		position: relative;
		margin: 5px;
		display: flex;
		text-align: center;
		justify-items: center;
		align-items: center;
		flex-wrap: wrap;
	}
	
	.bestboards {
		width:800px;
		height:300px;
		border:1px solid red;
		margin: auto;
	}
</style>
</head>
<body>
	<div class="search-main">
		<%@ include file="searchbar.jsp" %>
		
		<!-- 커뮤니티 인기글 목록 배너 -->
		<div class="bestboards">
			<center><img src="/malant/resources/common/images/mandragora_character.jpg"></center>
			<!-- 
			<P style="FONT-SIZE: 10pt"><IMG alt="" src="http://www.agrion.kr/upload/editor_img/result_2011_11_3_17_14_48_558_1.jpg"></P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt"><SPAN style="FONT-SIZE: 14pt"><STRONG>●특성</STRONG></SPAN></P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">-야자과(Palmae) | 학명 Chrysalidocarpus lutescens | 영명 Yellow Palm, Areca Palm, butterfly palm | 원산지 마다가스카르, 열대·아열대 지역</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">줄기가 노란색을 띠어 황야자라고도 부르며, 가장 인기있는 야자다. 학명의 chrysalidocarpus는‘황금색 열매’라는 뜻이며, lutescens는‘노랗게 되는’이라는 의미다. 외관이 이국적이고 아름다울 뿐만 아니라 생육속도가 빨라 양분만 충분히 주면 계속 새 잎이 생겨나 아름다운 수형을 유지할 수 있다. 멋진 수형 때문에 조금 넓은 장소이면 어디에서나 키울 수 있다. 빛을 좋아하나 강한 빛은 싫어하므로 여름의 직사광선은 피하되, 실내 밝은 곳에 두는 것이 좋다. 물 속에 들어있는 고농도 염에 민감하며, 특히 불소가 들어간 물은 싫어한다.</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt" align=center><IMG alt="" src="http://agrion.kr/upload/editor_img/result_2011_11_3_17_15_9_910_1.jpg">&nbsp;<IMG alt="" src="http://www.agrion.kr/upload/editor_img/result_2011_11_3_17_15_9_957_2.jpg"></P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt"><SPAN style="FONT-SIZE: 14pt"><STRONG>●실내 디자인</STRONG></SPAN></P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">생장이 빨라 구입시 적당한 크기라 할지라도 얼마 후엔 방을 가득히 채워버리게 된다. 기본적으로 거실에 두는 식물의 키는 천장 높이의 80% 이내인 것이 바람직하다. 그 이상이 되면 공간에 압박감을 주기 때문이다. 잎이 옆으로 벌어지기 때문에 통로에 배치하기보다는 넓은 장소에 배치하여 이국적인 느낌이 들도록 한다. 만약 넓은 욕실에 창이 있다면 그곳에 두어도 좋다. 욕실에 황야자를 두면 편안한 분위기를 만들어주고 열대 해변을 경험할 수도 있다. 거실이 넓다면 창가 쪽이 이 식물을 두기에 최적 장소이다. 키가 크면 아래 부분에 스킨답서스나 아이비를 함께 심으면 훨씬 아름답게 보인다.</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt"><SPAN style="FONT-SIZE: 14pt"><STRONG>●기능성</STRONG></SPAN></P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">황야자는 증산량이 많아 실내습도를 조절하는 최적의 식물이다. 약 1.8m 정도의 황야자는 증산작용으로 하루 동안에 1리터 정도의 수분을 방출한다. 또한 다양한 휘발성 유기물질을 제거하는 데 뛰어난 식물이다. 체내에 염이 축적되면 잎으로 이동시키고, 일정량 이상의 염이 축적되면 잎이 죽는다. 최근 들어 황야자는 최고의 환경친화적 식물(eco-friendly houseplant)로 자리매김하고 있다.</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt"><STRONG><SPAN style="FONT-SIZE: 14pt">●궁금해요</SPAN></STRONG></P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt"><STRONG>질문</STRONG> _ 잎 여러 곳에 갈색반점이 붙어 있어요.<BR><STRONG>대답</STRONG> _ 깍지벌레 때문이다. 지나치게 건조하거나 약해지면 이러한 해충이 붙는다. 이 해충은 식물의 수액을 빨면서 번식하므로 식물체가 빨리 쇠약해진다. 발견 즉시 안쓰는 칫솔이나 손으로 문질러 깍지벌레를 제거한다.</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt">&nbsp;</P><P style="FONT-SIZE: 10pt"></P>
			 -->
		</div>
	</div>
</body>
</html>