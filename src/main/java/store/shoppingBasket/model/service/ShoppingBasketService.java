package store.shoppingBasket.model.service;

import static common.JDBCTemplate.*;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import store.orderList.model.vo.OrderList;
import store.shoppingBasket.model.dao.ShoppingBasketDao;
import store.shoppingBasket.model.vo.ShoppingBasket;

public class ShoppingBasketService {
	ShoppingBasketDao sdao = new ShoppingBasketDao();

	public ArrayList<ShoppingBasket> selectSblist(String userNo) {
		Connection conn = getConnection();
		ArrayList<ShoppingBasket> list = sdao.selectSblist(conn, userNo);

		return list;
	}

	public int deleteShoppingBasket(String userNo, String productId) {
		Connection conn = getConnection();
		int result = sdao.deleteShoppingBasket(conn, userNo, productId);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ShoppingBasket addBasket(String userNo, String productId) {
		Connection conn = getConnection();
		ShoppingBasket sbasket = sdao.addBasket(conn, userNo, productId);

		return sbasket;
	}

}