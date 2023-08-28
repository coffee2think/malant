package myplant.model.service;

import java.util.ArrayList;

import myplant.model.dao.MyplantDao;
import myplant.model.vo.Myplant;

public class MyplantService {
	
	private MyplantDao mdao = new MyplantDao();
	
	public MyplantService(){}
	
	public ArrayList<Myplant> selectMyplantList(String) {}

	public int selectMyplantInormation(String, String) {}
	
	public int insertMyplantInformation(Myplant, String) {}
	
	public int updateMyplantInformation(Myplant, String) {}
	
	public int deleteMyplantInformation(String, String) {}
	
    

}
