package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import member.model.vo.Seller;

public class MemberService {
	
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}

	public int[] selectCheckDuplicate(String userId, String email) {
		Connection conn = getConnection();
		int[] result = mdao.selectCheckDuplicate(conn, userId, email);
		close(conn);
		return result;
	}
	
	public Member selectLogin(String userId, String userPwd) {
		Connection conn = getConnection();
		Member loginMember = mdao.selectLogin(conn, userId, userPwd);
		close(conn);
		return loginMember;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.insertMember(conn, member);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertSeller(Seller seller) {
		Connection conn = getConnection();
		int result = mdao.insertSeller(conn, seller);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member member = mdao.selectMember(conn, userId);
		close(conn);
		return member;
	}
	
	public Member selectMemberByUserNo(String userNo) {
		Connection conn = getConnection();
		Member member = mdao.selectMemberByUserNo(conn, userNo);
		close(conn);
		return member;
	} 

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = mdao.updateMember(conn, member);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	

}
