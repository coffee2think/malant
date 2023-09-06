package community.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import common.Paging;
import community.model.dao.BoardDao;
import community.model.vo.Board;
import community.model.vo.CMHashtag;
import community.model.vo.Comment;

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

	public ArrayList<CMHashtag> selectTop5Hash() {
		Connection conn = getConnection();
		ArrayList<CMHashtag> list = bdao.selectTop5Hash(conn);
		close(conn);

		return list;
	}

	public ArrayList<Board> selectListSortByDate() {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectListSortByDate(conn);
		close(conn);

		return list;
	}

	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		Board board = bdao.selectBoard(conn, boardNo);
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

	public ArrayList<Board> selectMyList(String userno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectMyList(conn, startRow, endRow, userno);
		close(conn);
		return list;
	}

	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result = bdao.deleteBoard(conn, boardNo);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateOriginBoard(Board board) {
		Connection conn = getConnection();
		int result = bdao.updateOriginBoard(conn, board);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateHashtag(Board board) {
		Connection conn = getConnection();
		int result = bdao.updateHashtag(conn, board);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int insertBoard(Board board) {
		Connection conn = getConnection();
		int result = bdao.insertBoard(conn, board);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getMyListCount(String userno) {
		Connection conn = getConnection();
		int listCount = bdao.getMyListCount(conn, userno);
		close(conn);
		return listCount;
	}

	public int getSearchHashtagCount(String keyword) {
		Connection conn = getConnection();
		int listCount = bdao.getSearchHashtagCount(conn, keyword);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectSearchHashtag(String keyword, Paging paging) {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectSearchHashtag(conn, keyword, paging);
		close(conn);
		return list;
	}
}
