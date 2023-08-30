package store.main.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import store.main.model.dao.MainDao;
<<<<<<< HEAD
import store.main.model.vo.*;
=======
import store.main.model.vo.Main;
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976

public class MainService {
	private MainDao mdao = new MainDao();
	
	public MainService() {}
	
<<<<<<< HEAD
	public ArrayList<MainBanner> selectBanner(){
		Connection conn = getConnection();
		ArrayList<MainBanner> list = mdao.selectBanner(conn);
=======
	public ArrayList<Main> selectBanner(){
		Connection conn = getConnection();
		ArrayList<Main> list = mdao.selectBanner(conn);
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
		close(conn);
		return list;
    }

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = mdao.getListCount(conn);
		close(conn);
		return listCount;
	}
	
<<<<<<< HEAD
	public ArrayList<MainProduct> selectMainProductList() {
		Connection conn = getConnection();
		ArrayList<MainProduct> list = mdao.selectMainProductList(conn);
		close(conn);
		System.out.println(list.toString());
=======
	public ArrayList<Main> selectMainProductList() {
		ArrayList<Main> list = new ArrayList<Main>();
		
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
		return list;
	}

	public int getBannerViewCount() {
		int result=0;
		
		return result;
	}
}
