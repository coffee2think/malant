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

	public int[] selectCheckDuplicate(Connection conn, String userId, String email) {
		int[] result = {0, 0};
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select (select count(user_id) from member where user_id = ?), "
				+ "(select count(email) from member where email = ?) from dual";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result[0] = rset.getInt(1);
				result[1] = rset.getInt(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
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

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("update member ")
					.append("set info_update_date = sysdate")
					.append(", alarm_yn = ?")
					.append(", notice_yn = ?");
		
		if(member.getNickname() != null) {
			queryBuilder.append(", nickname = ?");
		}
		if(member.getEmail() != null) {
			queryBuilder.append(", email = ?");
		}
		if(member.getUserPwd() != null) {
			queryBuilder.append(", user_pwd = ?");
			queryBuilder.append(", pwd_update_date = ?");
		}
		
		queryBuilder.append(" where user_id = ?");
		
		String query = queryBuilder.toString();
		
		try {
			int cnt = 1;
			pstmt = conn.prepareStatement(query);
			pstmt.setString(cnt++, member.getAlarmYn());
			pstmt.setString(cnt++, member.getNoticeYn());
			if(member.getNickname() != null) {
				pstmt.setString(cnt++, member.getNickname());
			}
			if(member.getEmail() != null) {
				pstmt.setString(cnt++, member.getEmail());
			}
			if(member.getUserPwd() != null) {
				pstmt.setString(cnt++, member.getUserPwd());
				pstmt.setDate(cnt++, member.getPwdUpdateDate());
			}
			pstmt.setString(cnt++, member.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member selectMemberByUserNo(Connection conn, String userNo) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where user_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				
				member.setUserNo(rset.getString("user_no"));
				member.setUserId(rset.getString("user_id"));
				member.setUserPwd(rset.getString("user_pwd"));
				member.setNickname(rset.getString("nickname"));
				member.setEmail(rset.getString("email"));
				member.setProfileImg(rset.getString("profile_img"));
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