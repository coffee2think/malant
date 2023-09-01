package diary.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import diary.model.dao.DiaryDao;
import diary.model.vo.Diary;

import static common.JDBCTemplate.*;

public class DiaryService {
	
	private DiaryDao ddao = new DiaryDao();
	
	public DiaryService () {}
	
//	public ArrayList<Diary> selectDiaryList(String){}
//	
//	public int insertNewDiray (Diary, String) {}
//	
//	public int updateDiary(Diary, String) {}
//	
//	public int deleteDiary(String, int) {}
//	
//	public int insertDiaryImage(String, int) {}
//	
//	public int insertDiaryEmoji(String, int) {}
//	
//	public int intertDiaryManaging(String, int) {}
//
//	public int getDiaryManagingCount() {}	
	
	
	
	public int getDiaryCount() {
		Connection conn = getConnection();
		int listcount = ddao.getDiaryCount(conn);
		close(conn);
		return listcount;
	}


	public ArrayList<Diary> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Diary> list = ddao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}


	
}
