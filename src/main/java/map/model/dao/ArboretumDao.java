package map.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import map.model.vo.Arboretum;
import static common.JDBCTemplate.close;
public class ArboretumDao {
	
	public ArboretumDao() {}
	
	public ArrayList<Arboretum> briefInfoList(Connection conn){
		ArrayList<Arboretum> list = new ArrayList<Arboretum>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//관리자를 제외한 일반회원만 전체 조회
		String query = "select arboretum_latitude, arboretum_longitude, arboretum_name, arboretum_address"
					+ " from arboretum";
		try {
			pstmt = conn.prepareStatement(query);					
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Arboretum arboretum = new Arboretum();
				
				//결과매핑 : 컬럼값 꺼내서 필드에 옮기기
				arboretum.setArboretum_name(rset.getString("arboretum_name"));
				arboretum.setArboretum_latitude(rset.getDouble("arboretum_latitude"));
				arboretum.setArboretum_longitude(rset.getDouble("arboretum_longitude"));
				arboretum.setArboretum_address(rset.getString("arboretum_address"));
				
				
				list.add(arboretum);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	public Arboretum selectInformation(Connection conn, String arboretum_id) {
		Arboretum arboretum = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from arboretum where arboretum_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, arboretum_id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				arboretum = new Arboretum();
				
				arboretum.setArboretum_id(arboretum_id);
				arboretum.setArboretum_name(rset.getString(0));
				arboretum.setArboretum_address(rset.getString(0));
				arboretum.setArboretum_homepage(rset.getString(0));
				arboretum.setArboretum_tel(rset.getString(0));
				arboretum.setEntrance_fee_yn(rset.getString(0));
				arboretum.setFee_teenage(rset.getInt(0));;
				arboretum.setFee_child(rset.getInt(0));
				arboretum.setFee_disabled(rset.getInt(0));
				arboretum.setFee_etc(rset.getString(0));
				arboretum.setOpen_days(rset.getString(0));
				arboretum.setClosed_days(rset.getString(0));
				arboretum.setWith_pet_yn(rset.getString(0));
				arboretum.setWith_guidedog_yn(rset.getString(0));
				arboretum.setEdu_program_yn(rset.getString(0));
				arboretum.setEdu_program_name(rset.getString(0));
				arboretum.setEdu_pro_reservation(rset.getString(0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return arboretum;
	}
	
}
