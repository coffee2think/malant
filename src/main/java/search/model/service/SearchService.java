package search.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import member.model.vo.Member;
import search.model.dao.SearchDao;
import search.model.vo.Plant;

public class SearchService {
	//DI(Dependency Injection : 의존성 주입)
	private SearchDao sdao = new SearchDao();
	
	public ArrayList<Plant> selectPlantList(String keyword) {
		Connection conn = getConnection();
		ArrayList<Plant> list = sdao.selectPlantList(conn, keyword);
		close(conn);
		return list;
	}

}
