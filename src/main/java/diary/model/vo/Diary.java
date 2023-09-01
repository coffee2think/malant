package diary.model.vo;

import java.sql.Date;

public class Diary implements java.io.Serializable {
	
	private static final long serialVersionUID = 389267166750680966L;
	
	private String memberNo;
	private int diaryNo;
	private String petPlantNo;
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

	
	public Diary(String memberNo, int diaryNo, String petPlantNo, Date diaryWritingDate, String diaryContent,
			String diaryImage1URL, String diaryImage2URL, String diaryImage3URL, String diaryImage4URL,
			String diaryManaging1, String diaryManaging2, String diaryManaging3, String diaryManaging4) {
		super();
		this.memberNo = memberNo;
		this.diaryNo = diaryNo;
		this.petPlantNo = petPlantNo;
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
		return "Diary [memberNo=" + memberNo + ", diaryNo=" + diaryNo + ", petPlantNo=" + petPlantNo
				+ ", diaryWritingDate=" + diaryWritingDate + ", diaryContent=" + diaryContent + ", diaryImage1URL="
				+ diaryImage1URL + ", diaryImage2URL=" + diaryImage2URL + ", diaryImage3URL=" + diaryImage3URL
				+ ", diaryImage4URL=" + diaryImage4URL + ", diaryManaging1=" + diaryManaging1 + ", diaryManaging2="
				+ diaryManaging2 + ", diaryManaging3=" + diaryManaging3 + ", diaryManaging4=" + diaryManaging4 + "]";
	}


	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public int getDiaryNo() {
		return diaryNo;
	}


	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}


	public String getPetPlantNo() {
		return petPlantNo;
	}


	public void setPetPlantNo(String petPlantNo) {
		this.petPlantNo = petPlantNo;
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
