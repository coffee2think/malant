package store.main.model.dao;

import java.sql.*;
import java.util.ArrayList;

import store.main.model.vo.*;
import static common.JDBCTemplate.*;

public class MainDao {
	public MainDao(){
		
	}
	
	public ArrayList<MainBanner> selectBanner(Connection conn){
		ArrayList<MainBanner> list = new ArrayList<MainBanner>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM NOTICE "
				+ "WHERE notice_type = 'banner' and START_DATE <= SYSDATE AND END_DATE >= SYSDATE ";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				MainBanner banner = new MainBanner();
				
				banner.setBannerImage(rset.getString("THUMBNAIL"));
				banner.setBannerLink(rset.getString("CONTENT"));
				banner.setBannerPrority(rset.getInt("PRIORITY"));
				
				list.add(banner);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
		
		return list;	
    }
	
	
	
	public ArrayList<MainProduct> selectMainProductList(Connection conn) {
		ArrayList<MainProduct> list = new ArrayList<MainProduct>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT PRODUCT_ID, PRODUCT_NAME, PRICE, PRODUCT_THUMBNAIL_IMG, THUMBNAIL_DESCRIPTION "
				+ "FROM PRODUCT "
				+ "WHERE EXPOSURE_YN='Y'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				MainProduct product = new MainProduct();
				
				product.setProductId(rset.getString("PRODUCT_ID"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setPrice(rset.getInt("PRICE"));
				product.setProductThumbnail(rset.getString("PRODUCT_THUMBNAIL_IMG"));
				product.setProductSimpleExplan(rset.getString("THUMBNAIL_DESCRIPTION"));

				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(stmt);
		}
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
  