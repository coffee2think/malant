package member.model.vo;

import java.io.Serializable;

public class Admin implements Serializable {

	private static final long serialVersionUID = -6021644396652521410L;
	
	private String adminNo;
	private String adminId;
	private String adminPwd;
	private String name;
	private String adminType;
	private String createdDate;
	
	public Admin() {
	}

	public Admin(String adminNo, String adminId, String adminPwd, String name, String adminType, String createdDate) {
		this.adminNo = adminNo;
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.name = name;
		this.adminType = adminType;
		this.createdDate = createdDate;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Admin [adminNo=" + adminNo + ", adminId=" + adminId + ", adminPwd=" + adminPwd + ", name=" + name
				+ ", adminType=" + adminType + ", createdDate=" + createdDate + "]";
	}

}
