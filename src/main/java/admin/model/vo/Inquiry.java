package admin.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Inquiry implements Serializable {

	private static final long serialVersionUID = 6886596233930319832L;
	
	private int inquiryNo;
	private String inquirerNo;
	private String inquirerId;
	private String inquirerEmail;
	private Date inquiryDate;
	private String inquiryType;
	private String inquiryTitle;
	private String inquiryContent;
	private String inquiryPath;
	private String replierNo;
	private String replierName;
	private String replierContent;
	private String status;
	private Date completionDate;
	
	public Inquiry() {
	}

	public Inquiry(int inquiryNo, String inquirerNo, String inquirerId, String inquirerEmail, Date inquiryDate,
			String inquiryType, String inquiryTitle, String inquiryContent, String inquiryPath, String status) {
		this.inquiryNo = inquiryNo;
		this.inquirerNo = inquirerNo;
		this.inquirerId = inquirerId;
		this.inquirerEmail = inquirerEmail;
		this.inquiryDate = inquiryDate;
		this.inquiryType = inquiryType;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
		this.inquiryPath = inquiryPath;
		this.status = status;
	}

	public Inquiry(int inquiryNo, String inquirerNo, String inquirerId, String inquirerEmail, Date inquiryDate,
			String inquiryType, String inquiryTitle, String inquiryContent, String inquiryPath, String replierNo,
			String replierName, String replierContent, String status, Date completionDate) {
		this.inquiryNo = inquiryNo;
		this.inquirerNo = inquirerNo;
		this.inquirerId = inquirerId;
		this.inquirerEmail = inquirerEmail;
		this.inquiryDate = inquiryDate;
		this.inquiryType = inquiryType;
		this.inquiryTitle = inquiryTitle;
		this.inquiryContent = inquiryContent;
		this.inquiryPath = inquiryPath;
		this.replierNo = replierNo;
		this.replierName = replierName;
		this.replierContent = replierContent;
		this.status = status;
		this.completionDate = completionDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getInquiryNo() {
		return inquiryNo;
	}

	public String getInquirerNo() {
		return inquirerNo;
	}

	public String getInquirerId() {
		return inquirerId;
	}

	public String getInquirerEmail() {
		return inquirerEmail;
	}

	public Date getInquiryDate() {
		return inquiryDate;
	}

	public String getInquiryType() {
		return inquiryType;
	}

	public String getInquiryTitle() {
		return inquiryTitle;
	}

	public String getInquiryContent() {
		return inquiryContent;
	}

	public String getInquiryPath() {
		return inquiryPath;
	}

	public String getReplierNo() {
		return replierNo;
	}

	public String getReplierName() {
		return replierName;
	}

	public String getReplierContent() {
		return replierContent;
	}

	public String getStatus() {
		return status;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public void setInquirerNo(String inquirerNo) {
		this.inquirerNo = inquirerNo;
	}

	public void setInquirerId(String inquirerId) {
		this.inquirerId = inquirerId;
	}

	public void setInquirerEmail(String inquirerEmail) {
		this.inquirerEmail = inquirerEmail;
	}

	public void setInquiryDate(Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public void setInquiryType(String inquiryType) {
		this.inquiryType = inquiryType;
	}

	public void setInquiryTitle(String inquiryTitle) {
		this.inquiryTitle = inquiryTitle;
	}

	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}

	public void setInquiryPath(String inquiryPath) {
		this.inquiryPath = inquiryPath;
	}

	public void setReplierNo(String replierNo) {
		this.replierNo = replierNo;
	}

	public void setReplierName(String replierName) {
		this.replierName = replierName;
	}

	public void setReplierContent(String replierContent) {
		this.replierContent = replierContent;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	@Override
	public String toString() {
		return "Inquiry [inquiryNo=" + inquiryNo + ", inquirerNo=" + inquirerNo + ", inquirerId=" + inquirerId
				+ ", inquirerEmail=" + inquirerEmail + ", inquiryDate=" + inquiryDate + ", inquiryType=" + inquiryType
				+ ", inquiryTitle=" + inquiryTitle + ", inquiryContent=" + inquiryContent + ", inquiryPath="
				+ inquiryPath + ", replierNo=" + replierNo + ", replierName=" + replierName + ", replierContent="
				+ replierContent + ", status=" + status + ", completionDate=" + completionDate + "]";
	}
	
}
