package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;
<<<<<<< HEAD
import member.model.vo.Seller;
=======
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976

public class MemberService {
	
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}

	public int selectCheckId(String userId) {
		Connection conn = getConnection();
		int idCount = mdao.selectCheckId(conn, userId);
		close(conn);
		return idCount;
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

<<<<<<< HEAD
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

=======
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
}
