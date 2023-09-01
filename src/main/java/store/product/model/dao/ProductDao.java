package store.product.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import store.product.model.vo.ProductDetail;

public class ProductDao {

	
	 public ArrayList<ProductDetail> selectFilterList(String[] parentCategoryId){
		 
		 return null;
	 }
	 

//	public int getListCount(Connection conn) {
//		int listCount = 0;
//		Statement stmt = null;
//		ResultSet rset = null;
//		
//		String query = "select count(*) from *****(테이블명)*******";
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
//	
//			if(rset.next()) {
//				listCount = rset.getInt(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(stmt);
//		}
//		return listCount;
//	}

	public ArrayList<ProductDetail> selectProductDetail(Connection conn, String productid) {
		ArrayList<ProductDetail> list = new ArrayList<ProductDetail>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * " + "from ST_PRODUCT " + "join ST_SELLER using(SELLER_NO) "
				+ "join ST_PROD_CATE using(PRODUCT_ID) " + "join ST_CATEGORY using(CATEGORY_ID) "
				+ "where PRODUCT_ID = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, productid);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				ProductDetail pdetail = new ProductDetail();

				pdetail.setCategoryId(rset.getString("CATEGORY_ID"));
				pdetail.setProductId(rset.getString("PRODUCT_ID"));
				pdetail.setProductName(rset.getString("PRODUCT_NAME"));
				pdetail.setSellerName(rset.getString("DISPLAYED_STORE_NAME"));
				pdetail.setPrice(rset.getInt("PRICE"));
				pdetail.setDeliveryCharge(rset.getInt("DELIVERY_CHARGE"));
				pdetail.setDetailImage(rset.getString("PRODUCT_DETAIL_IMG"));
				pdetail.setProductDescription(rset.getString("PRODUCT_DESCRIPTION"));
				pdetail.setProductRegistDate(rset.getDate("PRODUCT_REGIST_DATE"));
				pdetail.setParentCategoryId(rset.getString("PARENT_CATEGORY_ID"));
				pdetail.setCategoryName(rset.getString("CATEGORY_NAME"));
				pdetail.setSellerContact(rset.getString("CONTACT"));
				pdetail.setSellerAddress(rset.getString("ADDRESS"));
				pdetail.setSellerNo(rset.getString("SELLER_NO"));
				pdetail.setBusinissNo(rset.getString("BUSINESS_NO"));
				pdetail.setThumbnailImg(rset.getString("PRODUCT_THUMBNAIL_IMG"));
				pdetail.setProductDetailImg(rset.getString("PRODUCT_DETAIL_IMG"));
				pdetail.setExposureYn(rset.getString("EXPOSURE_YN"));

				list.add(pdetail);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<ProductDetail> selectProductList(Connection conn, String categoryid) {
		ArrayList<ProductDetail> list = new ArrayList<ProductDetail>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * "
				+ "from ST_PRODUCT "
				+ "join ST_SELLER using(SELLER_NO) "
				+ "join ST_PROD_CATE using(PRODUCT_ID) "
				+ "join ST_CATEGORY using(CATEGORY_ID) "
				+ "where CATEGORY_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryid);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				ProductDetail pdetail = new ProductDetail();

				pdetail.setCategoryId(rset.getString("CATEGORY_ID"));
				pdetail.setProductId(rset.getString("PRODUCT_ID"));
				pdetail.setProductName(rset.getString("PRODUCT_NAME"));
				pdetail.setSellerName(rset.getString("DISPLAYED_STORE_NAME"));
				pdetail.setPrice(rset.getInt("PRICE"));
				pdetail.setDeliveryCharge(rset.getInt("DELIVERY_CHARGE"));
				pdetail.setDetailImage(rset.getString("PRODUCT_DETAIL_IMG"));
				pdetail.setProductDescription(rset.getString("PRODUCT_DESCRIPTION"));
				pdetail.setProductRegistDate(rset.getDate("PRODUCT_REGIST_DATE"));
				pdetail.setParentCategoryId(rset.getString("PARENT_CATEGORY_ID"));
				pdetail.setCategoryName(rset.getString("CATEGORY_NAME"));
				pdetail.setSellerContact(rset.getString("CONTACT"));
				pdetail.setSellerAddress(rset.getString("ADDRESS"));
				pdetail.setSellerNo(rset.getString("SELLER_NO"));
				pdetail.setBusinissNo(rset.getString("BUSINESS_NO"));
				pdetail.setThumbnailImg(rset.getString("PRODUCT_THUMBNAIL_IMG"));
				pdetail.setProductDetailImg(rset.getString("PRODUCT_DETAIL_IMG"));
				pdetail.setExposureYn(rset.getString("EXPOSURE_YN"));

				list.add(pdetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	

	public int addViewCount(Connection conn, int productViewCount) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update board " + "set board_readcount = board_readcount + 1 " + "where board_num = ?"
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



	/*
	 * public void addReadCount(int ---) { Connection conn = getConnection(); int
	 * result = ---.addReadCount(conn, ---); if(result > 0) commit(conn); else
	 * rollback(conn); close(conn); }
	 */

}
