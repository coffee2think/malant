package myplant.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import myplant.model.vo.Myplant;

public class MyplantDao {
	
	public MyplantDao() {}
	
	
	public int getListCount(Connection conn, String userNo) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from my_plant where user_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);      
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Myplant> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Myplant> list = new ArrayList<Myplant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select *  "
				+ "from (select rownum rnum, MYPLANT_ID, USER_NO, MYPLANT_NAME,  "
				+ "MYPLANT_VARIETY, MYPLANT_IMAGE_URL, MYPLANT_MEMO, MYPLANT_START_DATE, CREATED_DATE "
				+ "from (select * from my_plant "
				+ "order by USER_NO asc, MYPLANT_ID asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Myplant myplant = new Myplant();
				
				myplant.setMyplantId(rset.getString("MYPLANT_ID"));
				myplant.setUserNo(rset.getString("USER_NO"));
				myplant.setMyplantName(rset.getString("MYPLANT_NAME"));
				myplant.setMyplantVariety(rset.getString("MYPLANT_VARIETY"));
				myplant.setMyplantImageURL(rset.getString("MYPLANT_IMAGE_URL"));
				myplant.setMyplantMemo(rset.getString("MYPLANT_MEMO"));
				myplant.setMyplantStartDate(rset.getDate("MYPLANT_START_DATE"));

			    list.add(myplant);
			}
			/* System.out.println(list.size()); */
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	

	public int updateMyplant(Connection conn, Myplant myplant, String userNo, String myplantId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update my_plant "
						+ "set myplant_name = ?, "
						+ "myplant_variety = ?, "
						+ "myplant_image_url = ?, "
						+ "where user_no = ?, myplant_id = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, myplant.getMyplantName());
			pstmt.setString(2, myplant.getMyplantVariety());
			pstmt.setString(3, myplant.getMyplantImageURL());
			pstmt.setString(4, myplant.getUserNo());
			pstmt.setString(5, myplant.getMyplantId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertMyplantInformation(Connection conn, Myplant myplant, String userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		System.out.println("inert Dao : " + userNo);
		
		String query = "insert into my_plant  "
				+ "(MYPLANT_ID, USER_NO, MYPLANT_NAME, MYPLANT_VARIETY, MYPLANT_IMAGE_URL,  "
				+ "MYPLANT_MEMO, MYPLANT_START_DATE, CREATED_DATE) "
				+ "values (MY_PLANT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, myplant.getUserNo());
			pstmt.setString(2, myplant.getMyplantName());
			pstmt.setString(3, myplant.getMyplantVariety());
			pstmt.setString(4, myplant.getMyplantImageURL());
			pstmt.setString(5, myplant.getMyplantMemo());
			pstmt.setDate(6, myplant.getMyplantStartDate());

			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Myplant selectMyplantInfo(Connection conn, String userNo, String myplantId) {
		Myplant myplant = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from my_plant where user_no = ?, myplant_id = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, myplantId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				myplant = new Myplant();
				
				myplant.setMyplantName(rset.getString("MYPLANT_NAME"));
				myplant.setMyplantVariety(rset.getString("MYPLANT_VARIETY"));
				myplant.setMyplantImageURL(rset.getString("MYPLANT_IMAGE_URL"));
				myplant.setMyplantMemo(rset.getString("MYPLANT_MEMO"));
				myplant.setMyplantStartDate(rset.getDate("MYPLANT_START_DATE"));

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return myplant;
	}

	public int deleteMyplant(Connection conn, String userNo, String myplantId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from my_plant where USER_NO = ? and MYPLANT_ID = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setString(2, myplantId);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public Myplant selectMyplant(Connection conn, String userNo) {
		Myplant myplant = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from my_plant where user_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				myplant = new Myplant();
			
				myplant.setMyplantId(rset.getString("MYPLANT_ID"));
				myplant.setUserNo(rset.getString("USER_NO"));
				myplant.setMyplantName(rset.getString("MYPLANT_NAME"));
				myplant.setMyplantVariety(rset.getString("MYPLANT_VARIETY"));
				myplant.setMyplantImageURL(rset.getString("MYPLANT_IMAGE_URL"));
				myplant.setMyplantMemo(rset.getString("MYPLANT_MEMO"));
				myplant.setMyplantStartDate(rset.getDate("MYPLANT_START_DATE"));

				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return myplant;
	}
	
}

















