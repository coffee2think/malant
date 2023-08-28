package store.shoppingBasket.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import store.shoppingBasket.model.vo.ShoppingBasket;

public class ShoppingBasketDao {

	public ArrayList<ShoppingBasket> selectSblist(Connection conn, String userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteShoppingBasket(Connection conn, String userNo, String productId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ShoppingBasket addBasket(Connection conn, String userNo, String ProductId) {
		
		return null;
	}
	
}
