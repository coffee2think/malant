package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.vo.Board;
import board.model.vo.Comment;


public class BoardDao {

	public ArrayList<Board> selectTop3Like(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from(select  BOARD_DATE, BOARD_CONTENT, user_no, board_no,NICKNAME, board_title, board_like, board_photo, PROFILE_IMG, rownum "
				+ "         from cm_board  join member using (user_no, nickname) where sysdate - board_date <= 7 order by board_like desc) "
				+ "        where rownum <= 3";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setNickname(rset.getString("NICKNAME"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardLike(rset.getInt("BOARD_LIKE"));
				board.setBoardPhoto(rset.getString("BOARD_PHOTO"));
				board.setUserNo(rset.getString("USER_NO"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);

		}
		return list;
	}

	public int addReadCount(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update cm_board set board_like = board_like + 1 where board_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateBoardLike(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update cm_board set board_like = board_like + 1 where board_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Board> selectTop3Hash(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT hashtag_content, hashtag_no "
				+ "FROM ( "
				+ "    SELECT hashtag_content, hashtag_no, "
				+ "           ROWNUM as r_num "
				+ "    FROM ( "
				+ "        SELECT hashtag_content, hashtag_no, COUNT(*) as usage_count "
				+ "        FROM cm_hashtag "
				+ "        JOIN cm_board_hashtag USING (hashtag_no) "
				+ "        GROUP BY hashtag_content, hashtag_no "
				+ "        ORDER BY usage_count DESC "
				+ "    ) "
				+ ") "
				+ "WHERE r_num <= 5";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setHashtagNo(rset.getInt("HASHTAG_NO"));
				board.setHashtagContent(rset.getString("HASHTAG_CONTENT"));

				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);

		}
		return list;
	}

	public ArrayList<Board> selectListSortByDate(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select BOARD_DATE, BOARD_CONTENT, user_no, board_no,NICKNAME, board_title, board_like, board_photo, PROFILE_IMG,BOARD_DATE "
				+ "				  from( select  BOARD_DATE, BOARD_CONTENT, user_no, board_no,NICKNAME, board_title, board_like, board_photo, PROFILE_IMG, rownum "
				+ "				  from cm_board  join member using (user_no, nickname)) "
				+ "				  order by board_like desc";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();

				board.setNickname(rset.getString("NICKNAME"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardLike(rset.getInt("BOARD_LIKE"));
				board.setBoardPhoto(rset.getString("BOARD_PHOTO"));
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setUserNo(rset.getString("USER_NO"));
			
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);

		}
		return list;
	}
	public ArrayList<Board> selectBoardByBoardNo(Connection conn, int boardNo) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from cm_board where board_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setUserNo(rset.getString("USER_NO"));
				board.setNickname(rset.getString("NICKNAME"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));
				board.setBoardLike(rset.getInt("BOARD_LIKE"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setBoardPhoto(rset.getString("BOARD_PHOTO"));
				board.setViewcount(rset.getInt("VIEW_COUNT"));
				board.setReportedYN(rset.getString("REPORTED_YN"));
			
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public Comment selectBestComment(Connection conn, int boardNo) {
		Comment comment = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select *  "
				+ "from (select board_no, comment_no, user_no, nickname, comment_like, comment_content, comment_date, reported_yn, rownum "
				+ "from cm_comment "
				+ "left join cm_comment_like using (comment_no, board_no, user_no) "
				+ "where board_no = ? "
				+ "order by comment_like desc) "
				+ "where rownum = 1";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				comment = new Comment();
				
				comment.setBoardNo(rset.getInt("BOARD_NO"));
				comment.setUserNo(rset.getString("USER_NO"));
				comment.setNickname(rset.getString("NICKNAME"));
				comment.setCommentNo(rset.getInt("COMMENT_NO"));
				comment.setCommentLike(rset.getInt("COMMENT_LIKE"));
				comment.setCommentContent(rset.getString("COMMENT_CONTENT"));
				comment.setCommentDate(rset.getDate("COMMENT_DATE"));
				comment.setReportedYn(rset.getString("REPORTED_YN"));

				//System.out.println("댓글 출력 확인 : " + comment.toString());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return comment;
	}


}
