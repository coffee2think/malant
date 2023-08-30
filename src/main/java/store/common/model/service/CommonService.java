package store.common.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import store.common.model.dao.CommonDao;
import store.common.model.vo.Product;
import store.common.model.vo.ProductSimpleInfo;

public class CommonService{
	private CommonDao cdao = new CommonDao();
	
	public CommonService() {}
	
	
	
	public String goProductDetail(String productid){
		Connection conn = getConnection();
		String result = cdao.goProductDetail(conn, productid);
		
		return result;
	}
	
	public ProductSimpleInfo getProductInfo(String productid) {
		Connection conn = getConnection();
		ProductSimpleInfo list = cdao.getProductInfo(conn, productid);
		
		return list;
	}
	
	
}
