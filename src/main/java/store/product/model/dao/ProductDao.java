package store.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import store.product.model.vo.Product;
import store.product.model.vo.ProductDetail;

public class ProductDao {

	public ArrayList<Product> selectFilterList(String parentCategoryId, String[] categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from *****(테이블명)*******";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
	
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public ProductDetail selectProductDetail(Connection conn, String productid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addViewCount(Connection conn, int productViewCount) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board "
				+ "set board_readcount = board_readcount + 1 "
				+ "where board_num = ?"
				+ "*** 쿼리문 작성부분 수정할것***";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productViewCount);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Product> selectProductList(Connection conn, int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addReadCount(int ---) {
		Connection conn = getConnection();
		int result = ---.addReadCount(conn, ---);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);		
	}
	
}
