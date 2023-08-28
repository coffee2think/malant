package store.orderList.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import store.orderList.model.dao.OrderListDao;
import store.orderList.model.vo.OrderList;

public class OrderListService {
	OrderListDao oldao = new OrderListDao();
	
	public ArrayList<OrderList> selectOrderList(String userNo) {
		Connection conn = getConnection();
		ArrayList<OrderList> list = oldao.selectOrderList(conn, userNo);
		
		return list;
	}
	public ArrayList<OrderList> selectFilterOrderList(String userNo, String orderState) {
		Connection conn = getConnection();
		ArrayList<OrderList> list = oldao.selectFilterOrderList(conn, userNo, orderState);
		
		return list;
	}
	public String deliveryTracking(String orderId) {
		Connection conn = getConnection();
		String trakingNo = null;
		trakingNo = oldao.deliveryTracking(conn, orderId);
		
		return trakingNo;
	}
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = oldao.getListCount(conn);
		close(conn);
		return listCount;
	}
}
