package store.order.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import store.order.model.dao.OrderDao;
import store.order.model.vo.ProductOrder;
import store.product.model.vo.ProductDetail;

public class OrderService {
	
	private OrderDao odao = new OrderDao();
	
	public OrderService() {}
	
	public ArrayList<ProductDetail> selectProductOrder(String productId, int quantity) {
		Connection conn = getConnection();
		ArrayList<ProductDetail> list = odao.selectProductOrder(conn, productId, quantity);
		return list;
	}
	
	public int updatePayCancel() {
		return 0;
	}
	
	public int updatePayOk() {
		return 0;
	}
	
	public ProductOrder addOrderList(ProductOrder productOrder) {
		Connection conn = getConnection();
		ProductOrder list = odao.addOrderList(conn, productOrder);
		
		return list;
	}
	
	public String MakeOrderId(String productOrder) {
		Connection conn = getConnection();
		String orderid = odao.MakeOrderId(conn, productOrder);
		return orderid;
	}
}
