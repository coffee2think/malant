package store.main.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import store.main.model.dao.MainDao;
import store.main.model.vo.Main;

public class MainService {
	private MainDao mdao = new MainDao();
	
	public MainService() {}
	
	public ArrayList<Main> selectBanner(){
		Connection conn = getConnection();
		ArrayList<Main> list = mdao.selectBanner(conn);
		close(conn);
		return list;
    }

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = mdao.getListCount(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Main> selectMainProductList() {
		ArrayList<Main> list = new ArrayList<Main>();
		
		return list;
	}

	public int getBannerViewCount() {
		int result=0;
		
		return result;
	}
}
