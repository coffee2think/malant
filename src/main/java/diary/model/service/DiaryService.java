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


	public ArrayList<Diary> selectList(String userNo, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Diary> list = ddao.selectList(conn, userNo, startRow, endRow);
		close(conn);
		return list;
	}

	public int insertNewDiray(Diary diary, String userNo) {
		Connection conn = getConnection();
		int result = ddao.insertNewDiray(conn, diary, userNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	
	}

	public int updateDiary(Diary diary, String userNo, String diaryId) {
		Connection conn = getConnection();
		int result = ddao.updateMyplant(conn, diary, userNo, diaryId);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteDiary(String userNo, String diaryId) {
		Connection conn = getConnection();
		int result = ddao.deleteDiary(conn, userNo, diaryId);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}




	
}
