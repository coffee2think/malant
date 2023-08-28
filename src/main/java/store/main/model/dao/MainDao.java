package store.main.model.dao;

import java.sql.*;
import java.util.ArrayList;

import store.main.model.vo.Main;
import static common.JDBCTemplate.*;

public class MainDao {
	public MainDao(){
		
	}
	
	public ArrayList<Main> selectBanner(Connection conn){
		ArrayList<Main> list = new ArrayList<Main>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM NOTICE "
				+ "WHERE notice_type = 'banner'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Main main = new Main();
				
				main.setBannerImage(rset.getString("THUMBNAIL"));
				main.setBannerLink(rset.getString("CONTENT"));
				main.setBannerPrority(rset.getInt("PRIORITY"));
				main.setBannerStart(rset.getDate("EVENT_START"));
				main.setBannerEnd(rset.getDate("EVENT_END"));
				
				list.add(main);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		
		return list;	
    }
	
	
	
	public ArrayList<Main> selectMainProductList() {
		ArrayList<Main> list = new ArrayList<Main>();
		
		return list;	
	}

	public int getBannerViewCount() {
		int result=0;
		
		return result;
	}

	public int getListCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
  