package store.order.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import store.order.model.vo.ProductOrder;

public class OrderDao {

	public ArrayList<ProductOrder> selectProductOrder(Connection conn, String userNo, String productId, int quantity) {
		// TODO Auto-generated method stub
		return null;
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
