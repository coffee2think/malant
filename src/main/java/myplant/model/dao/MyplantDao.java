package myplant.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import myplant.model.vo.Myplant;

public class MyplantDao {
	
	public MyplantDao() {}
	
	public ArrayList<Myplant> selectMyplantList(Connection, String) {}
	
	public ArrayList<Myplant> selectMyplantManaging(Connection, String, String) {}
	
	public int selectMyplantInformation(Connection, String, String) {}
	
	public int insertMyplantInformation(Connection, Myplant, String) {}
	
	public int updateMyplantInformation(Connection, Myplant, String) {}
	
	public int deleteMyplantInformation(Connection, String, String) {}
 
}
