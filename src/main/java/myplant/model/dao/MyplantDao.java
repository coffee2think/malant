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

	public ArrayList<Myplant> selectList(Connection conn, int startRow, int endRow, String userNo) {
		ArrayList<Myplant> list = new ArrayList<Myplant>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select *  "
				+ "from (select rownum rnum, MYPLANT_ID, USER_NO, MYPLANT_NAME,  "
				+ "MYPLANT_VARIETY, MYPLANT_IMAGE_URL, MYPLANT_MEMO,  "
				+ "MYPLANT_START_DATE, POS_WINDOW, POS_VERANDA, POS_DESK, POS_YARD,  "
				+ "POS_GARDEN, ENV_SUNNY, ENV_SHADY, ENV_WINDY, ENV_DRY, ENV_HUMID,  "
				+ "WITH_PET, WITH_PLANT, WITH_CHILD, WITH_FRIEND, WITH_ALONE, CREATED_DATE "
				+ "from (select * from my_plant where user_no = ? "
				+ "order by USER_NO asc, MYPLANT_ID asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
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
				myplant.setPosWindow(rset.getString("POS_WINDOW"));
				myplant.setPosVeranda(rset.getString("POS_VERANDA"));
				myplant.setPosDesk(rset.getString("POS_DESK"));
				myplant.setPosYard(rset.getString("POS_YARD"));
				myplant.setPosGarden(rset.getString("POS_GARDEN"));
				myplant.setEnvSunny(rset.getString("ENV_SUNNY"));
				myplant.setEnvShady(rset.getString("ENV_SHADY"));
				myplant.setEnvWindy(rset.getString("ENV_WINDY"));
				myplant.setEnvDry(rset.getString("ENV_DRY"));
				myplant.setEnvHumid(rset.getString("ENV_HUMID"));
				myplant.setWithPet(rset.getString("WITH_PET"));
				myplant.setWithPlant(rset.getString("WITH_PLANT"));
				myplant.setWithChild(rset.getString("WITH_CHILD"));
				myplant.setWithFriend(rset.getString("WITH_FRIEND"));
				myplant.setWithAlone(rset.getString("WITH_ALONE"));
				myplant.setCreatedDate(rset.getDate("CREATED_DATE"));

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
	
	

	public int updateMyplant(Connection conn, Myplant myplant) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update my_plant "
						+ "set myplant_name = ?, "
						+ "myplant_variety = ?, "
						+ "myplant_image_url = ?, "
						+ "pos_mindow = ?, "
						+ "pos_veranda = ?, "
						+ "pos_desk = ?, "
						+ "pos_yard = ?, "
						+ "pos_garden = ?, "
						+ "env_sunny = ?, "
						+ "env_shady = ?, "
						+ "env_windy = ?, "
						+ "env_dry = ?, "
						+ "env_humid = ?, "
						+ "with_pet = ?, "
						+ "with_plant = ?, "
						+ "with_child = ?, "
						+ "with_friend = ?, "
						+ "with_alone = ? "
						+ "where user_no = ?, myplant_id = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, myplant.getMyplantName());
			pstmt.setString(2, myplant.getMyplantVariety());
			pstmt.setString(3, myplant.getMyplantImageURL());
			pstmt.setString(4, myplant.getPosWindow());
			pstmt.setString(5, myplant.getPosVeranda());
			pstmt.setString(6, myplant.getPosDesk());
			pstmt.setString(7, myplant.getPosYard());
			pstmt.setString(8, myplant.getPosGarden());
			pstmt.setString(9, myplant.getEnvSunny());
			pstmt.setString(10, myplant.getEnvShady());
			pstmt.setString(11, myplant.getEnvWindy());
			pstmt.setString(12, myplant.getEnvDry());
			pstmt.setString(13, myplant.getEnvHumid());
			pstmt.setString(14, myplant.getWithPet());
			pstmt.setString(15, myplant.getWithPlant());
			pstmt.setString(16, myplant.getWithChild());
			pstmt.setString(17, myplant.getWithFriend());
			pstmt.setString(18, myplant.getWithAlone());
			pstmt.setString(19, myplant.getUserNo());
			pstmt.setString(20, myplant.getMyplantId());
			
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
		
		String query = "insert into my_plant "
					+ "(MYPLANT_ID, USER_NO, MYPLANT_NAME, MYPLANT_VARIETY, MYPLANT_IMAGE_URL, "
					+ "MYPLANT_MEMO, MYPLANT_START_DATE, POS_WINDOW, POS_VERANDA, POS_DESK, POS_YARD, "
					+ "POS_GARDEN, ENV_SUNNY, ENV_SHADY, ENV_WINDY, ENV_DRY, ENV_HUMID, WITH_PET, "
					+ "WITH_PLANT, WITH_CHILD, WITH_FRIEND, WITH_ALONE, CREATED_DATE)  "
					+ "values (my_plant_seq.NEXTVAL, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?,  "
					+ "?, ?, ?, ?, ?, ?, ?, DEFAULT)";	
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, myplant.getUserNo());
			pstmt.setString(2, myplant.getMyplantName());
			pstmt.setString(3, myplant.getMyplantVariety());
			pstmt.setString(4, myplant.getMyplantImageURL());
			pstmt.setString(5, myplant.getMyplantMemo());
			pstmt.setDate(6, myplant.getMyplantStartDate());
			pstmt.setString(7, myplant.getPosWindow());
			pstmt.setString(8, myplant.getPosVeranda());
			pstmt.setString(9, myplant.getPosDesk());
			pstmt.setString(10, myplant.getPosYard());
			pstmt.setString(11, myplant.getPosGarden());
			pstmt.setString(12, myplant.getEnvSunny());
			pstmt.setString(13, myplant.getEnvShady());
			pstmt.setString(14, myplant.getEnvWindy());
			pstmt.setString(15, myplant.getEnvDry());
			pstmt.setString(16, myplant.getEnvHumid());
			pstmt.setString(17, myplant.getWithPet());
			pstmt.setString(18, myplant.getWithPlant());
			pstmt.setString(19, myplant.getWithChild());
			pstmt.setString(20, myplant.getWithFriend());
			pstmt.setString(21, myplant.getWithAlone());
			
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
				myplant.setPosWindow(rset.getString("POS_WINDOW"));
				myplant.setPosVeranda(rset.getString("POS_VERANDA"));
				myplant.setPosDesk(rset.getString("POS_DESK"));
				myplant.setPosYard(rset.getString("POS_YARD"));
				myplant.setPosGarden(rset.getString("POS_GARDEN"));
				myplant.setEnvSunny(rset.getString("ENV_SUNNY"));
				myplant.setEnvShady(rset.getString("ENV_SHADY"));
				myplant.setEnvWindy(rset.getString("ENV_WINDY"));
				myplant.setEnvDry(rset.getString("ENV_DRY"));
				myplant.setEnvHumid(rset.getString("ENV_HUMID"));
				myplant.setWithPet(rset.getString("WITH_PET"));
				myplant.setWithPlant(rset.getString("WITH_PLANT"));
				myplant.setWithChild(rset.getString("WITH_CHILD"));
				myplant.setWithFriend(rset.getString("WITH_FRIEND"));
				myplant.setWithAlone(rset.getString("WITH_ALONE"));
				
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
				myplant.setPosWindow(rset.getString("POS_WINDOW"));
				myplant.setPosVeranda(rset.getString("POS_VERANDA"));
				myplant.setPosDesk(rset.getString("POS_DESK"));
				myplant.setPosYard(rset.getString("POS_YARD"));
				myplant.setPosGarden(rset.getString("POS_GARDEN"));
				myplant.setEnvSunny(rset.getString("ENV_SUNNY"));
				myplant.setEnvShady(rset.getString("ENV_SHADY"));
				myplant.setEnvWindy(rset.getString("ENV_WINDY"));
				myplant.setEnvDry(rset.getString("ENV_DRY"));
				myplant.setEnvHumid(rset.getString("ENV_HUMID"));
				myplant.setWithPet(rset.getString("WITH_PET"));
				myplant.setWithPlant(rset.getString("WITH_PLANT"));
				myplant.setWithChild(rset.getString("WITH_CHILD"));
				myplant.setWithFriend(rset.getString("WITH_FRIEND"));
				myplant.setWithAlone(rset.getString("WITH_ALONE"));
				myplant.setCreatedDate(rset.getDate("CREATED_DATE"));
				
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

















