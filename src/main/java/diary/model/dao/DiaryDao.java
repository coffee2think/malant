package diary.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Board;
import diary.model.vo.Diary;

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

	public ArrayList<Diary> selectList(Connection conn, String userNo, int startRow, int endRow) {
		ArrayList<Diary> list = new ArrayList<Diary>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select *  "
				+ "from (select rownum rnum, diary_id, user_no, myplant_id,  "
				+ "diary_writing_date, diary_content, diary_image1_url,  "
				+ "diary_image2_url, diary_image3_url, diary_image4_url, diary_managing1, diary_managing2,  "
				+ "diary_managing3, diary_managing4, "
				+ "from (select * from diary where user_no = ? "
				+ "order by diary_writing_date desc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Diary diary = new Diary();
				
				diary.setUserNo(rset.getString("diary_id"));
				diary.setDiaryId(rset.getString("user_no"));
				diary.setMyplantId(rset.getString("myplant_id"));
				diary.setDiaryWritingDate(rset.getDate("diary_writing_date"));
				diary.setDiaryContent(rset.getString("diary_content"));
				diary.setDiaryImage1URL(rset.getString("diary_image1_url"));
				diary.setDiaryImage2URL(rset.getString("diary_image2_url"));
				diary.setDiaryImage3URL(rset.getString("diary_image3_url"));
				diary.setDiaryImage4URL(rset.getString("diary_image4_url"));
				diary.setDiaryManaging1(rset.getString("diary_managing1"));
				diary.setDiaryManaging2(rset.getString("diary_managing2"));
				diary.setDiaryManaging3(rset.getString("diary_managing3"));
				diary.setDiaryManaging4(rset.getString("diary_managing4"));
				
				list.add(diary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	public int insertNewDiray(Connection conn, Diary diary, String userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into diary "
				+ "(diary_id, user_no, myplant_id, diary_writing_date, diary_content, "
				+ "diary_image1_url, diary_image2_url, diary_image3_url, diary_image4_url, diary_managing1, diary_managing2, "
				+ "diary_managing3, diary_managing4)  "
				+ "values (?, ?, ? ,? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";	
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, diary.getUserNo());
			pstmt.setString(2, diary.getDiaryId());
			pstmt.setString(3, diary.getMyplantId());
			pstmt.setDate(4, diary.getDiaryWritingDate());
			pstmt.setString(5, diary.getDiaryContent());
			pstmt.setString(5, diary.getDiaryImage1URL());
			pstmt.setString(5, diary.getDiaryImage2URL());
			pstmt.setString(5, diary.getDiaryImage3URL());
			pstmt.setString(5, diary.getDiaryImage4URL());
			pstmt.setString(5, diary.getDiaryManaging1());
			pstmt.setString(5, diary.getDiaryManaging2());
			pstmt.setString(5, diary.getDiaryManaging3());
			pstmt.setString(5, diary.getDiaryManaging4());
			
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		
		return result;
	}

	public int updateMyplant(Connection conn, Diary diary, String userNo, String diaryId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update diary "
						+ "set diary_id = ?, "
						+ "user_no = ?, "
						+ "myplant_id = ?, "
						+ "diary_writing_date = ?, "
						+ "diary_content = ?, "
						+ "diary_image1_url = ?, "
						+ "diary_image2_url = ?, "
						+ "diary_image3_url = ?, "
						+ "diary_image4_url = ?, "
						+ "diary_managing1 = ?, "
						+ "diary_managing2 = ?, "
						+ "diary_managing3 = ?, "
						+ "diary_managing4 = ?";


		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, diary.getUserNo());
			pstmt.setString(2, diary.getDiaryId());
			pstmt.setString(3, diary.getMyplantId());
			pstmt.setDate(4, diary.getDiaryWritingDate());
			pstmt.setString(5, diary.getDiaryContent());
			pstmt.setString(5, diary.getDiaryImage1URL());
			pstmt.setString(5, diary.getDiaryImage2URL());
			pstmt.setString(5, diary.getDiaryImage3URL());
			pstmt.setString(5, diary.getDiaryImage4URL());
			pstmt.setString(5, diary.getDiaryManaging1());
			pstmt.setString(5, diary.getDiaryManaging2());
			pstmt.setString(5, diary.getDiaryManaging3());
			pstmt.setString(5, diary.getDiaryManaging4());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteDiary(Connection conn, String userNo, String diaryId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from my_plant where USER_NO = ? and DIARY_ID = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, diaryId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
