package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
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

	public int selectCheckId(Connection conn, String userId) {
		int idCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(userid) from member where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				idCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return idCount;
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
//		String query = "insert into member (user_no, user_id, user_pwd, nickname, email, profile_img, sign_type, alarm_yn, notice_yn) "
//				+ "values (member_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		
//		String query = "insert into member (user_no, user_id, user_pwd, nickname, email) "
//				+ "values (?, ?, ?, ?, ?)";
		
		String query = "insert into member (user_no, user_id, user_pwd, nickname, email, profile_img, sign_type, alarm_yn, notice_yn) "
				+ "values (MEMBER_SEQ.nextval, 'user02', 'pass02', 'name02', 'user01@gmail.com', '/malant/resources/member_profiles/' || sysdate || '.jpg', 'COMMON', 'Y', 'Y')";
		
		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, (int)(Math.random() * 100 + 1));
//			pstmt.setString(2, member.getUserId());
//			pstmt.setString(3, member.getUserPwd());
//			pstmt.setString(4, member.getNickname());
//			pstmt.setString(5, member.getEmail());
//			pstmt.setString(6, member.getProfileImg());
//			pstmt.setString(7, member.getSignType());
//			pstmt.setString(8, member.getReceptionNotification());
//			pstmt.setString(9, member.getReceptionAd());
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
