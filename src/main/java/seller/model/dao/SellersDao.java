package seller.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import seller.model.vo.Sellers;
import store.product.model.vo.ProductDetail;

public class SellersDao {

//	public int addOrderList(Connection conn, ProductOrder productOrder) {
//		int result = 0;

//		송장번호 입력 랜덤숫자 발생기
//		String TrackingNo = null;
//		Random random = new Random();
//      long lTrackingNo = Math.abs(random.nextLong() % 10000000000000000L);
//      TrackingNo = String.valueOf(lTrackingNo);
//      System.out.println(TrackingNo);

//		PreparedStatement pstmt = null;
//
//		String query = "update ST_ORDER " + "set PAYMENT_STATUS = ?, ORDER_STATE = ? " + "where order_id = ?";
//
//		try {
//			pstmt = conn.prepareStatement(query);
//
//			pstmt.setString(1, productOrder.getPaymentStatus());
//			pstmt.setString(2, "결제완료");
//			pstmt.setString(3, productOrder.getOrderId());
//
//			System.out.println("PaymentStatus " + productOrder.getPaymentStatus());
//			System.out.println("getOrderId " + productOrder.getOrderId());
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//		System.out.println("result : " + result);
//
//		return result;
//	}

	public ArrayList<Sellers> slogin(Connection conn, String sellerid, String sellerpwd) {

		ArrayList<Sellers> sellers = new ArrayList<Sellers>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select seller_id, seller_pwd from st_seller";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Sellers s = new Sellers();

				s.setSellerId(rset.getString("SELLER_ID"));
				s.setSellerPwd(rset.getString("SELLER_PWD"));
				
				sellers.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return sellers;
	}

	public ArrayList<ProductDetail> slist(Connection conn, String sellerno) {
		
		ArrayList<ProductDetail> sellers = new ArrayList<ProductDetail>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * "
				+ "from st_product "
				+ "join st_seller using(seller_no) "
				+ "where seller_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sellerno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
			ProductDetail spd = new ProductDetail();
			
			spd.setThumbnailImg(rset.getString("PRODUCT_THUMBNAIL_IMG"));
			spd.setProductName(rset.getString("PRODUCT_NAME"));
			spd.setPrice(rset.getInt("PRICE"));
			spd.setProductRegistDate(rset.getDate("PRODUCT_REGIST_DATE"));
			spd.setExposureYn(rset.getString("EXPOSURE_YN"));
			spd.setProductId(String.valueOf(rset.getInt("PRODUCT_ID")));
			
			sellers.add(spd);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return sellers;
	}
}
