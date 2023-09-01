package search.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import search.model.vo.Plant;

public class SearchDao {

	public ArrayList<Plant> selectPlantList(Connection conn, String keyword) {
		ArrayList<Plant> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from plant where plant_name like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, keyword);			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Plant plant = new Plant();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
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
