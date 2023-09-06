package community.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.Paging;
import community.model.vo.Board;
import community.model.vo.CMBoardPhoto;
import community.model.vo.CMHashtag;
import community.model.vo.Comment;

public class BoardDao {

	public ArrayList<Board> selectTop3Like(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "			from(select rownum, BOARD_NO, USER_NO,  NICKNAME, BOARD_TITLE,"
				+ "              BOARD_CONTENT, BOARD_LIKE,BOARD_DATE, VIEW_COUNT, THUMBNAIL, REPORT_COUNT  "
				+ "				      from (select * "
				+ "                              from cm_board   "
				+ "                              where sysdate - board_date <= 7 "
				+ "                              order by board_like desc)) "
				+ "where rownum <= 3";

		try {
			pstmt = conn.prepareStatement(query);
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
				board.setViewcount(rset.getInt("VIEW_COUNT"));
				board.setReportCount(rset.getInt("REPORT_COUNT"));
				board.setThumbnail(rset.getString("THUMBNAIL"));

				list.add(board);
			}
			
//			System.out.println(list);
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

		String query = "update cm_board set view_count = view_count + 1 where board_no = ?";
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

	public ArrayList<CMHashtag> selectTop5Hash(Connection conn) {
		ArrayList<CMHashtag> list = new ArrayList<CMHashtag>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT hashtag_content, hashtag_no  "
					+ "FROM (SELECT hashtag_content, hashtag_no,  ROWNUM rnum   "
					+ "            FROM ( SELECT hashtag_content, hashtag_no, COUNT(*)  usagecount "
					+ "                        FROM cm_board_hashtag "
					+ "				       JOIN cm_hashtag USING (hashtag_no) "
					+ "                       GROUP BY hashtag_content, hashtag_no  "
					+ "				       ORDER BY usagecount DESC ) ) "
					+ "WHERE rnum <= 5";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				CMHashtag hash = new CMHashtag();

				hash.setHashtagNo(rset.getInt("HASHTAG_NO"));
				hash.setHashtagContent(rset.getString("HASHTAG_CONTENT"));

				list.add(hash);
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

				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setUserNo(rset.getString("USER_NO"));
				board.setNickname(rset.getString("NICKNAME"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));
				board.setBoardLike(rset.getInt("BOARD_LIKE"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setViewcount(rset.getInt("VIEW_COUNT"));
				board.setReportCount(rset.getInt("REPORT_COUNT"));
				board.setThumbnail(rset.getString("THUMBNAIL"));
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

	public Board selectBoard(Connection conn, int boardNo) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from cm_board where board_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new Board();

				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setUserNo(rset.getString("USER_NO"));
				board.setNickname(rset.getString("NICKNAME"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardContent(rset.getString("BOARD_CONTENT"));
				board.setBoardLike(rset.getInt("BOARD_LIKE"));
				board.setBoardDate(rset.getDate("BOARD_DATE"));
				board.setViewcount(rset.getInt("VIEW_COUNT"));
				board.setReportCount(rset.getInt("REPORT_COUNT"));
				board.setThumbnail(rset.getString("THUMBNAIL"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return board;
	}

	public Comment selectBestComment(Connection conn, int boardNo) {
		Comment comment = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select *  "
				+ "from (select board_no, comment_no, user_no, nickname, comment_like, comment_content, comment_date, reported_yn, rownum "
				+ "from cm_comment " + "left join cm_comment_like using (comment_no, board_no, user_no) "
				+ "where board_no = ? " + "order by comment_like desc) " + "where rownum = 1";

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
				comment.setCommentContent(rset.getString("COMMENT_CONTENT"));
				comment.setCommentDate(rset.getDate("COMMENT_DATE"));

				// System.out.println("댓글 출력 확인 : " + comment.toString());

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return comment;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from cm_board";

		try {
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * "
					+ "from (select rownum rnum, BOARD_NO, USER_NO, NICKNAME, BOARD_TITLE, BOARD_CONTENT, "
					+ "                    BOARD_LIKE, BOARD_DATE, VIEW_COUNT, THUMBNAIL, REPORT_COUNT "
					+ "        from (select * "
					+ "                 from CM_BOARD "
					+ "                 order by  BOARD_NO desc)) "
					+ "where rnum between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

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
				board.setViewcount(rset.getInt("VIEW_COUNT"));
				board.setReportCount(rset.getInt("REPORT_COUNT"));
				board.setThumbnail(rset.getString("THUMBNAIL"));
				
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

	public ArrayList<Board> selectMyList(Connection conn, String userno) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select CM_BOARD.* from CM_BOARD  where user_no = ? order by board_no desc";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userno);

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
				board.setViewcount(rset.getInt("VIEW_COUNT"));
				board.setReportCount(rset.getInt("REPORT_COUNT"));
				board.setThumbnail(rset.getString("THUMBNAIL"));

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

	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from cm_board where board_no = ?";
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

	public int updateOriginBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update cm_board " + "set board_title = ?, " + "    board_content = ?, " + "    board_photo = ?"
				+ "where board_no = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(4, board.getBoardNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateHashtag(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update cm_hashtag " + "set hashtag_content = ? " + "where hashtag_no in ( "
				+ "    select hashtag_no " + "    from cm_board_hashtag " + "    where board_no = ? " + ")";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(2, board.getBoardNo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(pstmt);
		}
		return result;
	}

	public int insertBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into cm_board values "
				+ "((select max(board_no) + 1 from cm_board), ?, ?, ?, ?, default, default, default,  ?, default)";

		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, board.getUserNo());
			pstmt.setString(2, board.getNickname());
			pstmt.setString(3, board.getBoardTitle());
			pstmt.setString(4, board.getBoardContent());
			pstmt.setString(5, board.getThumbnail());
			
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getMyListCount(Connection conn, String userno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from cm_board where user_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public int getSearchHashtagCount(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) "
				+ "from cm_board  "
				+ "join cm_board_hashtag using (board_no) "
				+ "join cm_hashtag using (hashtag_no) "
				+ "where hashtag_content = ?";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, keyword);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	public ArrayList<Board> selectSearchHashtag(Connection conn, String keyword, Paging paging) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from (select rownum rnum, BOARD_NO, USER_NO, NICKNAME, BOARD_TITLE, BOARD_CONTENT,  "
				+ "			 BOARD_LIKE, BOARD_DATE, VIEW_COUNT, THUMBNAIL, REPORT_COUNT "
				+ "          from (select * "
				+ "                                   from cm_board  "
				+ "                                    join cm_board_hashtag using (board_no) "
				+ "                                    join cm_hashtag using (hashtag_no) "
				+ "                                    where hashtag_content = ? "
				+ "					                order by  BOARD_NO desc)) "
				+ "				where rnum between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			pstmt.setInt(2, paging.getStartRow());
			pstmt.setInt(3, paging.getEndRow());

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
				board.setViewcount(rset.getInt("VIEW_COUNT"));
				board.setReportCount(rset.getInt("REPORT_COUNT"));
				board.setThumbnail(rset.getString("THUMBNAIL"));

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

	public ArrayList<CMBoardPhoto> selectBoardPhotoList(Connection conn, int bnum) {
		ArrayList<CMBoardPhoto> list = new ArrayList<CMBoardPhoto>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from cm_board_photo "
				+ "where BOARD_NO = ? "
				+ "order by  PHOTO_NO asc";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bnum);


			rset = pstmt.executeQuery();

			while (rset.next()) {
				CMBoardPhoto photo = new CMBoardPhoto();

				photo.setBoardNo(rset.getInt("BOARD_NO"));
				photo.setPhotoNo(rset.getInt("PHOTO_NO"));
				photo.setFilename(rset.getString("FILENAME"));
				
				list.add(photo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertBoardPhoto(Connection conn, CMBoardPhoto photo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into cm_board_photo values "
				+ "((select max(photo_no) + 1 from cm_board_photo), ?, "
				+ "((select max(board_no) from cm_board))";

		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, photo.getBoardNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
