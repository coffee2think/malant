package diary.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import diary.model.vo.Diary;
import static common.JDBCTemplate.*;

public class DiaryDao {
	
	public DiaryDao() {}
	
//	public ArrayList<Diary> selectDiaryList(Connection, String, int){}
//	
//	public int insertNewDiray (Connection, Diary, String) {}
//	
//	public int updateDiary(Connection, Diary, String) {}
//	
//	public int deleteDiary(Connection, String, int) {}
//	
//	public int insertDiaryImage(Connection, String, int) {}
//	
//	public int insertDiaryEmoji(Connection, String, int) {}
//	
//	public ArrayList<Diary> intertDiaryManaging(Connection, String, int) {}
//	
//	public int getDiaryManagingCount() {}

	public int getDiaryCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from my_diary";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Diary> selectList(Connection conn, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}
}
