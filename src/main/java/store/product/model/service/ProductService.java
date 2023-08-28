package store.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import store.product.model.dao.ProductDao;
import store.product.model.vo.Product;
import store.product.model.vo.ProductDetail;

import static common.JDBCTemplate.*;

public class ProductService {
	private ProductDao pdao = new ProductDao();

	public ProductService() {
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = pdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Product> selectProductList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Product> list = pdao.selectProductList(conn, startRow, endRow);

		return list;
	}

	public ArrayList<Product> selectFilterList(String parentCategoryId, String[] categoryName) {
		Connection conn = getConnection();
		ArrayList<Product> list = pdao.selectFilterList(parentCategoryId, categoryName);
		return list;
	}
	
	public ProductDetail selectProductDetail(String productid){
		Connection conn = getConnection();
		ProductDetail productInfo = pdao.selectProductDetail(conn, productid);
		
		return productInfo;
	}

	public int addViewCount(int productViewCount) {
		Connection conn = getConnection();
		int result = pdao.addViewCount(conn, productViewCount);
		return result;
	}
}
