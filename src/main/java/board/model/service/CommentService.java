package board.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.CommentDao;
import board.model.vo.Comment;


public class CommentService {

	private CommentDao cdao = new CommentDao();

	public CommentService() {
	}

	public ArrayList<Comment> selectCommentList() {
		Connection conn = getConnection();
		ArrayList<Comment> list = cdao.selectCommentList(conn);
		close(conn);

		return list;
	}

	public int insertComment(Comment comment) {
		Connection conn = getConnection();
		int result = cdao.insertComment(conn, comment);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	




}
