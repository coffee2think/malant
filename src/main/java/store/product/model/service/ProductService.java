package store.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import store.product.model.dao.ProductDao;
import store.product.model.vo.ProductDetail;

import static common.JDBCTemplate.*;

public class ProductService {
	private ProductDao pdao = new ProductDao();

	public ProductService() {
	}

//	public int getListCount() {
//		Connection conn = getConnection();
//		int listCount = pdao.getListCount(conn);
//		close(conn);
//		return listCount;
//	}

	public ArrayList<ProductDetail> selectProductList(String categoryid) {
		Connection conn = getConnection();
		ArrayList<ProductDetail> list = pdao.selectProductList(conn, categoryid);

		return list;
	}

	public ArrayList<ProductDetail> selectFilterList(ArrayList<String> options) {
		Connection conn = getConnection();
		ArrayList<ProductDetail> list = pdao.selectFilterList(conn, options);
		return list;
	}
	
	public ArrayList<ProductDetail> selectProductDetail(String productid){
		
		Connection conn = getConnection();
		ArrayList<ProductDetail> list = pdao.selectProductDetail(conn, productid);
		close(conn);

		return list;
	}

	public int addViewCount(int productViewCount) {
		Connection conn = getConnection();
		int result = pdao.addViewCount(conn, productViewCount);
		return result;
	}
}
