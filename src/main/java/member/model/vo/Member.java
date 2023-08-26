package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = -4952932019676617041L;
	
	private String memberNo;
	private String userId;
	private String userPwd;
	private Date pwdUpdateDate;
	private String email;
	private String nickname;
	private String profileImg;
	private String signType;
	private String userName;
	private String phone;
	private String address;
	private String receptionNotification;
	private String receptionAd;
	private String blockedYn;
	private Date createdDate;
	private Date lastLoginDate;
	private String dormantYn;
	private String withdrawalYn;
	
	public Member() {}

	public Member(String memberNo, String userId, String email, String nickname, String signType,
			String receptionNotification, String receptionAd, String blockedYn, Date createdDate,
			Date lastLoginDate, String dormantYn, String withdrawalYn) {
		this.memberNo = memberNo;
		this.userId = userId;
		this.email = email;
		this.nickname = nickname;
		this.signType = signType;
		this.receptionNotification = receptionNotification;
		this.receptionAd = receptionAd;
		this.blockedYn = blockedYn;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
		this.dormantYn = dormantYn;
		this.withdrawalYn = withdrawalYn;
	}

	public Member(String memberNo, String userId, String userPwd, Date pwdUpdateDate, String email, String nickname,
			String profileImg, String signType, String userName, String phone, String address,
			String receptionNotification, String receptionAd, String blockedYn, Date createdDate,
			Date lastLoginDate, String dormantYn, String withdrawalYn) {
		this.memberNo = memberNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.pwdUpdateDate = pwdUpdateDate;
		this.email = email;
		this.nickname = nickname;
		this.profileImg = profileImg;
		this.signType = signType;
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.receptionNotification = receptionNotification;
		this.receptionAd = receptionAd;
		this.blockedYn = blockedYn;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
		this.dormantYn = dormantYn;
		this.withdrawalYn = withdrawalYn;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getPwdUpdateDate() {
		return pwdUpdateDate;
	}

	public void setPwdUpdateDate(Date pwdUpdateDate) {
		this.pwdUpdateDate = pwdUpdateDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReceptionNotification() {
		return receptionNotification;
	}

	public void setReceptionNotification(String receptionNotification) {
		this.receptionNotification = receptionNotification;
	}

	public String getReceptionAd() {
		return receptionAd;
	}

	public void setReceptionAd(String receptionAd) {
		this.receptionAd = receptionAd;
	}

	public String getBlockedYn() {
		return blockedYn;
	}

	public void setBlockedYn(String blockedYn) {
		this.blockedYn = blockedYn;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getDormantYn() {
		return dormantYn;
	}

	public void setDormantYn(String dormantYn) {
		this.dormantYn = dormantYn;
	}

	public String getWithdrawalYn() {
		return withdrawalYn;
	}

	public void setWithdrawalYn(String withdrawalYn) {
		this.withdrawalYn = withdrawalYn;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", userId=" + userId + ", userPwd=" + userPwd + ", pwdUpdateDate="
				+ pwdUpdateDate + ", email=" + email + ", nickname=" + nickname + ", profileImg=" + profileImg
				+ ", signType=" + signType + ", userName=" + userName + ", phone=" + phone + ", address=" + address
				+ ", receptionNotification=" + receptionNotification + ", receptionAd=" + receptionAd
				+ ", blockedYn=" + blockedYn + ", createdDate=" + createdDate + ", lastLoginDate="
				+ lastLoginDate + ", dormantYn=" + dormantYn + ", withdrawalYn=" + withdrawalYn + "]";
	}
	
}
