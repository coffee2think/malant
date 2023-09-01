

//반려식물 등록창 팝업
	document.querySelector("#addYourPlant").addEventListener("click",function(){
	   document.querySelector(".myplantAdd").classList.add("active");
	});
	//반려식물 등록창 닫음(취소)
	document.querySelector(".myplantAdd .close-btn").addEventListener("click",function(){
	   document.querySelector(".myplantAdd").classList.remove("active");
	});
	
	//반려식물 등록창 저장 후 닫음
	document.querySelector(".myplantAdd .save-close-btn").addEventListener("click",function(){
	   document.querySelector(".myplantAdd").classList.remove("active");
	});

//******************************************************************************************** */

//등록된 반려식물 클릭 시 상세페이지 팝업
	document.querySelector("#myplantbox").addEventListener("click",function(){
	   document.querySelector(".myplantDetail").classList.add("active");
	});
	
	//상세페이지 팝업 닫음
	document.querySelector(".myplantDetail .close-btn").addEventListener("click",function(){
	   document.querySelector(".myplantDetail").classList.remove("active");
	});

//******************************************************************************************** */

//상세 페이지에서 수정 버튼 클릭 시 수정페이지 팝업
	document.querySelector("#modify").addEventListener("click",function(){
	   document.querySelector(".myplantModify").classList.add("active");
	});
	
	//수정페이지 팝업 닫음(취소)
	document.querySelector(".myplantModify .close-btn").addEventListener("click",function(){
	   document.querySelector(".myplantModify").classList.remove("active");
	});
	
	//수정페이지 팝업 저장 후 닫음
	document.querySelector(".myplantModify .save-close-btn").addEventListener("click",function(){
	   document.querySelector(".myplantModify").classList.remove("active");
	});

//******************************************************************************************** */



