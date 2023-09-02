package store.order.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import store.order.model.dao.OrderDao;
import store.order.model.vo.ProductOrder;
import store.product.model.vo.ProductDetail;

public class OrderService {
	
	private OrderDao odao = new OrderDao();
	
	public OrderService() {}
	
	public ProductOrder selectProductOrder(String productId, int quantity) {
		Connection conn = getConnection();
		ProductOrder list = odao.selectProductOrder(conn, productId, quantity);
		close(conn);
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
		close(conn);
		return list;
	}
	
	public String MakeOrderId(String productOrder) {
		Connection conn = getConnection();
		String orderid = odao.MakeOrderId(conn, productOrder);
		close(conn);		
		return orderid;
	}
}
