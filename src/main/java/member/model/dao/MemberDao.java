package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.model.vo.Member;

public class MemberDao {

	public Member selectLogin(Connection conn, String userId, String userPwd) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where user_id = ? and user_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				
				member.setMemberNo(rset.getString("user_no"));
				member.setUserId(rset.getString("user_id"));
				member.setUserPwd(rset.getString("user_pwd"));
				member.setUserPwd(rset.getString("user_pwd"));
				member.setPwdUpdateDate(rset.getDate("pwd_update_date"));
				member.setEmail(rset.getString("email"));
				member.setNickname(rset.getString("nickname"));
				member.setProfileImg(rset.getString("profile_img"));
				member.setSignType(rset.getString("sign_type"));
				member.setUserName(rset.getString("user_name"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setReceptionNotification(rset.getString("reception_notification"));
				member.setReceptionAd(rset.getString("reception_ad"));
				member.setBlockedYn(rset.getString("blocked_yn"));
				member.setCreatedDate(rset.getDate("created_date"));
				member.setLastLoginDate(rset.getDate("last_login_date"));
				member.setDormantYn(rset.getString("dormant_yn"));
				member.setWithdrawalYn(rset.getString("withdrawal_yn"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

}
