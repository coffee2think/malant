package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

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

}
