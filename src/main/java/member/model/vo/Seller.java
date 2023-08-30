package member.model.vo;

import java.io.Serializable;

public class Seller implements Serializable {

	private static final long serialVersionUID = -951810464657238823L;
	
	private String sellerNo;
	private String businessNo;
	private String sellerId;
	private String sellerPwd;
	private String contact;
	private String email;
	private String storeName;
	private String displayedStoreName;
	private String address;
	private String approvalYn;
	private String approvalDate;
	private String createdDate;
	
	public Seller() {}

	public Seller(String sellerNo, String businessNo, String sellerId, String sellerPwd, String contact, String email,
			String storeName, String address, String approvalYn, String createdDate) {
		this.sellerNo = sellerNo;
		this.businessNo = businessNo;
		this.sellerId = sellerId;
		this.sellerPwd = sellerPwd;
		this.contact = contact;
		this.email = email;
		this.storeName = storeName;
		this.address = address;
		this.approvalYn = approvalYn;
		this.createdDate = createdDate;
	}

	public Seller(String sellerNo, String businessNo, String sellerId, String sellerPwd, String contact, String email,
			String storeName, String displayedStoreName, String address, String approvalYn, String approvalDate,
			String createdDate) {
		this.sellerNo = sellerNo;
		this.businessNo = businessNo;
		this.sellerId = sellerId;
		this.sellerPwd = sellerPwd;
		this.contact = contact;
		this.email = email;
		this.storeName = storeName;
		this.displayedStoreName = displayedStoreName;
		this.address = address;
		this.approvalYn = approvalYn;
		this.approvalDate = approvalDate;
		this.createdDate = createdDate;
	}

	public String getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(String sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerPwd() {
		return sellerPwd;
	}

	public void setSellerPwd(String sellerPwd) {
		this.sellerPwd = sellerPwd;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDisplayedStoreName() {
		return displayedStoreName;
	}

	public void setDisplayedStoreName(String displayedStoreName) {
		this.displayedStoreName = displayedStoreName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getApprovalYn() {
		return approvalYn;
	}

	public void setApprovalYn(String approvalYn) {
		this.approvalYn = approvalYn;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Seller [sellerNo=" + sellerNo + ", businessNo=" + businessNo + ", sellerId=" + sellerId + ", sellerPwd="
				+ sellerPwd + ", contact=" + contact + ", email=" + email + ", storeName=" + storeName
				+ ", displayedStoreName=" + displayedStoreName + ", address=" + address + ", approvalYn=" + approvalYn
				+ ", approvalDate=" + approvalDate + ", createdDate=" + createdDate + "]";
	}

}
