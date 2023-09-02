package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.vo.Comment;

public class CommentDao {
	

	public ArrayList<Comment> selectCommentList(Connection conn) {
		ArrayList<Comment> list = new ArrayList<Comment>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select *  " + "from cm_comment " + "join cm_comment_like using (comment_no) "
				+ "where REPORTED_YN = 'N' ";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Comment comment = new Comment();
				comment.setBoardNo(rset.getInt("BOARD_NO"));
				comment.setCommentNo(rset.getInt("COMMENT_NO"));
				comment.setUserNo(rset.getString("USER_NO"));
				comment.setNickname(rset.getString("NICKNAME"));
				comment.setCommentLike(rset.getInt("COMMENT_LIKE"));
				comment.setCommentContent(rset.getString("COMMENT_CONTENT"));
				comment.setCommentDate(rset.getDate("COMMENT_DATE"));
				comment.setReportedYn(rset.getString("REPORTED_YN"));
				
				list.add(comment);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);

		}
		return list;
	}

	public int insertComment(Connection conn, Comment comment) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		System.out.println("comment : "+comment.toString());
		
		String query = "insert into cm_comment values (?, (select max(comment_no) +1 from cm_comment), "
				+ " ?, ?, default, ?, default, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, comment.getBoardNo());
			pstmt.setString(2, comment.getUserNo());
			pstmt.setString(3, comment.getNickname());
			pstmt.setString(4, comment.getCommentContent());
			
			result = pstmt.executeUpdate();
			System.out.println("들어간다 댓글");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
