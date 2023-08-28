package store.orderList.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import store.orderList.model.vo.OrderList;

public class OrderListDao {

	public ArrayList<OrderList> selectOrderList(Connection conn, String userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderList> selectFilterOrderList(Connection conn, String userNo, String orderState) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deliveryTracking(Connection conn, String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getListCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}
}
