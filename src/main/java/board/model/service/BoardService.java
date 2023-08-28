package board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;

import static common.JDBCTemplate.*;

public class BoardService {
	private BoardDao bdao = new BoardDao();

	public BoardService() {
	}

	public ArrayList<Board> selectTop3Like() {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectTop3Like(conn);
		close(conn);
		
		System.out.println(list.toString());
		return list;
	}

}
