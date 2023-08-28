package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.vo.Board;
import static common.JDBCTemplate.*;

public class BoardDao {

	public ArrayList<Board> selectTop3Like(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = " select  nickname, board_title, board_like, board_photo, VIEW_COUNT, rownum "
				+ " from (select nickname, board_title, board_like, board_photo, VIEW_COUNT, rownum "
				+ "         from cm_board " + "         order by board_like desc) " + " where rownum <= 3";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Board board = new Board();

				board.setNickname(rset.getString("nickname"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardLike(rset.getInt("board_like"));
				board.setBoardPhoto(rset.getString("view_count"));
				
				System.out.println(board.getNickname());

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
}
