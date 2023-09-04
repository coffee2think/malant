package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.Comment;

import static common.JDBCTemplate.*;

public class BoardService {
	private BoardDao bdao = new BoardDao();

	public BoardService() {
	}

	public ArrayList<Board> selectTop3Like() {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectTop3Like(conn);
		close(conn);

		return list;
	}

	public int addReadCount(int boardNo) {
		Connection conn = getConnection();
		int result = bdao.addReadCount(conn, boardNo);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}



	public int updateBoardLike(int boardNo) {
		Connection conn = getConnection();
		int result = bdao.updateBoardLike(conn, boardNo);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}

	public ArrayList<Board> selectTop3Hash() {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectTop3Hash(conn);
		close(conn);

		return list;
	}

	public ArrayList<Board> selectListSortByDate() {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectListSortByDate(conn);
		close(conn);

		return list;
	}

	public Board selectBoardByBoardNo(int boardNo) {
		Connection conn = getConnection();
		Board board = bdao.selectBoardByBoardNo(conn, boardNo);
		close(conn);
		return board;
	}

	public Comment selectBestComment(int boardNo) {
		Connection conn = getConnection();
		Comment comment = bdao.selectBestComment(conn, boardNo);
		close(conn);

		return comment;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}
}
