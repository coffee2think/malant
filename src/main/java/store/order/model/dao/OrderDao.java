package store.order.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import store.order.model.vo.ProductOrder;
import store.product.model.vo.ProductDetail;

public class OrderDao {

	public ProductOrder selectProductOrder(Connection conn, String productId, int quantity) {
		
		ProductOrder porder = new ProductOrder();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ST_PRODUCT "
				+ "join ST_SELLER using(SELLER_NO) where product_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			porder.setProductId(productId);
			porder.setProductName(rset.getString("PRODUCT_NAME"));
			porder.setPrice(rset.getInt("PRICE"));
			porder.setDeliveryCharge(rset.getInt("DELIVERY_CHARGE"));
			porder.setThumbnailImg(rset.getString("PRODUCT_THUMBNAIL_IMG"));
			porder.setQuantity(quantity);
			porder.setStoreName(rset.getString("DISPLAYED_STORE_NAME"));
			}
			
			System.out.println("dao : "+ porder.toString());

		} catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return porder;
	}	
	
	public int updatePayCancel() {
		return 0;
	}
	
	public int updatePayOk() {
		return 0;
	}
	
	public ProductOrder addOrderList(Connection conn, ProductOrder productOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	public int saveOrderSheet(Connection conn, ProductOrder productOrder) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into member values "
				+ "(?, ?, ?, ?, ?, ?, ?, default, default, default, default, default, ?)";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, productOrder.getUserId());
			
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		
		
		
		
		
		return result;
	}
	
}
