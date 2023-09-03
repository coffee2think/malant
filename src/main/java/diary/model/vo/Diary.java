package diary.model.vo;

import java.sql.Date;

public class Diary implements java.io.Serializable {
	
	private static final long serialVersionUID = 389267166750680966L;
	
	private String userNo;
	private String diaryId;
	private String myplantId;
	private Date diaryWritingDate;
	private String diaryContent;
	private String diaryImage1URL;
	private String diaryImage2URL;
	private String diaryImage3URL;
	private String diaryImage4URL;
	private String diaryManaging1;
	private String diaryManaging2;
	private String diaryManaging3;
	private String diaryManaging4;
	
	
	public Diary() {
		super();
		
	}

	
	public Diary(String userNo, String diaryId, String myplantId, Date diaryWritingDate, String diaryContent,
			String diaryImage1URL, String diaryImage2URL, String diaryImage3URL, String diaryImage4URL,
			String diaryManaging1, String diaryManaging2, String diaryManaging3, String diaryManaging4) {
		super();
		this.userNo = userNo;
		this.diaryId = diaryId;
		this.myplantId = myplantId;
		this.diaryWritingDate = diaryWritingDate;
		this.diaryContent = diaryContent;
		this.diaryImage1URL = diaryImage1URL;
		this.diaryImage2URL = diaryImage2URL;
		this.diaryImage3URL = diaryImage3URL;
		this.diaryImage4URL = diaryImage4URL;
		this.diaryManaging1 = diaryManaging1;
		this.diaryManaging2 = diaryManaging2;
		this.diaryManaging3 = diaryManaging3;
		this.diaryManaging4 = diaryManaging4;
	}


	@Override
	public String toString() {
		return "Diary [userNo=" + userNo + ", diaryId=" + diaryId + ", myplantId=" + myplantId
				+ ", diaryWritingDate=" + diaryWritingDate + ", diaryContent=" + diaryContent + ", diaryImage1URL="
				+ diaryImage1URL + ", diaryImage2URL=" + diaryImage2URL + ", diaryImage3URL=" + diaryImage3URL
				+ ", diaryImage4URL=" + diaryImage4URL + ", diaryManaging1=" + diaryManaging1 + ", diaryManaging2="
				+ diaryManaging2 + ", diaryManaging3=" + diaryManaging3 + ", diaryManaging4=" + diaryManaging4 + "]";
	}


	public String getUserNo() {
		return userNo;
	}


	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	public String getDiaryId() {
		return diaryId;
	}


	public void setDiaryId(String diaryId) {
		this.diaryId = diaryId;
	}


	public String getMyplantId() {
		return myplantId;
	}


	public void setMyplantId(String myplantId) {
		this.myplantId = myplantId;
	}


	public Date getDiaryWritingDate() {
		return diaryWritingDate;
	}


	public void setDiaryWritingDate(Date diaryWritingDate) {
		this.diaryWritingDate = diaryWritingDate;
	}


	public String getDiaryContent() {
		return diaryContent;
	}


	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}


	public String getDiaryImage1URL() {
		return diaryImage1URL;
	}


	public void setDiaryImage1URL(String diaryImage1URL) {
		this.diaryImage1URL = diaryImage1URL;
	}


	public String getDiaryImage2URL() {
		return diaryImage2URL;
	}


	public void setDiaryImage2URL(String diaryImage2URL) {
		this.diaryImage2URL = diaryImage2URL;
	}


	public String getDiaryImage3URL() {
		return diaryImage3URL;
	}


	public void setDiaryImage3URL(String diaryImage3URL) {
		this.diaryImage3URL = diaryImage3URL;
	}


	public String getDiaryImage4URL() {
		return diaryImage4URL;
	}


	public void setDiaryImage4URL(String diaryImage4URL) {
		this.diaryImage4URL = diaryImage4URL;
	}


	public String getDiaryManaging1() {
		return diaryManaging1;
	}


	public void setDiaryManaging1(String diaryManaging1) {
		this.diaryManaging1 = diaryManaging1;
	}


	public String getDiaryManaging2() {
		return diaryManaging2;
	}


	public void setDiaryManaging2(String diaryManaging2) {
		this.diaryManaging2 = diaryManaging2;
	}


	public String getDiaryManaging3() {
		return diaryManaging3;
	}


	public void setDiaryManaging3(String diaryManaging3) {
		this.diaryManaging3 = diaryManaging3;
	}


	public String getDiaryManaging4() {
		return diaryManaging4;
	}


	public void setDiaryManaging4(String diaryManaging4) {
		this.diaryManaging4 = diaryManaging4;
	}

  

}
