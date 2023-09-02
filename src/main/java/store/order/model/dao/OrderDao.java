package store.order.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import store.order.model.vo.ProductOrder;
import store.product.model.vo.ProductDetail;

public class OrderDao {

	public ArrayList<ProductDetail> selectProductOrder(Connection conn, String productId, int quantity) {
		
		ArrayList<ProductDetail> list = new ArrayList<ProductDetail>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ST_PRODUCT where product_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			
			ProductDetail pdetail = new ProductDetail();
			
			pdetail.setProductId(productId);
			pdetail.setProductName(rset.getString("PRODUCT_NAME"));
			pdetail.setPrice(rset.getInt("PRICE"));
			pdetail.setDeliveryCharge(rset.getInt("DELIVERY_CHARGE"));
			pdetail.setThumbnailImg(rset.getString("PRODUCT_THUMBNAIL_IMG"));
			
			list.add(pdetail);
			}

		} catch(Exception e){
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
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

	public String MakeOrderId(Connection conn, String productOrder) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
