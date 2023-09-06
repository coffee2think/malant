package seller.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import seller.model.dao.SellersDao;
import seller.model.vo.Sellers;
import store.product.model.vo.ProductDetail;


public class SellersService {
	
	private SellersDao sdao = new SellersDao();
	
	public ArrayList<Sellers> slogin(String sellerid, String sellerpwd) {
		Connection conn = getConnection();
		ArrayList<Sellers> sellers = sdao.slogin(conn, sellerid, sellerpwd);
		close(conn);
		return sellers;
	}
	
	
	public ArrayList<ProductDetail> sellerPlist(String sellerno){
		Connection conn = getConnection();
		ArrayList<ProductDetail> sellers = sdao.slist(conn, sellerno);
		close(conn);
		return sellers;
	}
}
