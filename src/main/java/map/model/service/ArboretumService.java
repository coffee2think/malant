package map.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import map.model.dao.ArboretumDao;
import map.model.vo.Arboretum;

public class ArboretumService {
	
	private ArboretumDao adao = new ArboretumDao();
	
	public ArboretumService() {}
	
	public ArrayList<Arboretum> briefInfoList() {
		Connection conn = getConnection();
		ArrayList<Arboretum> list = adao.briefInfoList(conn);
		close(conn);
		return list;
	}

	public Arboretum selectDetailInformation() {
		Connection conn = getConnection();
		Arboretum arboretum = adao.selectInformation(conn);
		close(conn);
		return arboretum;
	}
}
