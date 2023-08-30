package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.model.vo.Member;
import member.model.vo.Seller;

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
				
				member.setUserNo(rset.getString("user_no"));
				member.setUserId(rset.getString("user_id"));
				member.setUserPwd(rset.getString("user_pwd"));
				member.setPwdUpdateDate(rset.getDate("pwd_update_date"));
				member.setEmail(rset.getString("email"));
				member.setNickname(rset.getString("nickname"));
				member.setProfileImg(rset.getString("profile_img"));
				member.setSignType(rset.getString("sign_type"));
				member.setUserName(rset.getString("user_name"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setAlarmYn(rset.getString("alarm_yn"));
				member.setNoticeYn(rset.getString("notice_yn"));
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
		
		String query = "insert into member (user_no, user_id, user_pwd, nickname, email, profile_img, sign_type, alarm_yn, notice_yn)\n"
				+ "values (replace(? || decode((select to_char(max(to_number(substr(user_no, 4))) + 1, '0000000') from member), null, '0000001', (select to_char(max(to_number(substr(user_no, 4))) + 1, '0000000') from member)), ' ', ''), "
				+ "?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getSignType().substring(0, 3).toUpperCase());
			pstmt.setString(2, member.getUserId());
			pstmt.setString(3, member.getUserPwd());
			pstmt.setString(4, member.getNickname());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getProfileImg());
			pstmt.setString(7, member.getSignType());
			pstmt.setString(8, member.getAlarmYn());
			pstmt.setString(9, member.getNoticeYn());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertSeller(Connection conn, Seller seller) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "insert into st_seller (seller_no, business_no, seller_id, seller_pwd, contact, email, store_name, address) "
				+ "values (replace(? || (select to_char(max(to_number(substr(seller_no, 4))) + 1, '0000000') from st_seller), ' ', ''), ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "SEL");
			pstmt.setString(2, seller.getBusinessNo());
			pstmt.setString(3, seller.getSellerId());
			pstmt.setString(4, seller.getSellerPwd());
			pstmt.setString(5, seller.getContact());
			pstmt.setString(6, seller.getEmail());
			pstmt.setString(7, seller.getStoreName());
			pstmt.setString(8, seller.getAddress());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				
				member.setUserNo(rset.getString("user_no"));
				member.setUserId(rset.getString("user_id"));
				member.setUserPwd(rset.getString("user_pwd"));
				member.setNickname(rset.getString("nickname"));
				member.setEmail(rset.getString("email"));
				member.setProfileImg(rset.getString("profile_img"));
				member.setUserName(rset.getString("user_name"));
				member.setPhone(rset.getString("phone"));
				member.setAddress(rset.getString("address"));
				member.setSignType(rset.getString("sign_type"));
				member.setPwdUpdateDate(rset.getDate("pwd_update_date"));
				member.setAlarmYn(rset.getString("alarm_yn"));
				member.setNoticeYn(rset.getString("notice_yn"));
				member.setBlockedYn(rset.getString("blocked_yn"));
				member.setDormantYn(rset.getString("dormant_yn"));
				member.setWithdrawalYn(rset.getString("withdrawal_yn"));
				member.setCreatedDate(rset.getDate("created_date"));
				member.setLastLoginDate(rset.getDate("last_login_date"));
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
