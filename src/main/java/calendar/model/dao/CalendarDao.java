package calendar.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import calendar.model.vo.Calendar;
import static common.JDBCTemplate.*;

public class CalendarDao {
	
	public CalendarDao() {}

	public int insertNewCalendarTodo(Connection conn, Calendar calendar, String userNo, Date calendarDate) {
		int result = 0; 
		PreparedStatement pstmt = null;
		
		String query = "";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(2, calendar.getUserNo());
			pstmt.setDate(1, calendar.getCalendarDate());
			pstmt.setString(3, calendar.getMyplantNo());
			pstmt.setInt(3, calendar.getDiaryNo());
			pstmt.setString(2, calendar.getManagingPruningTrimming());
			pstmt.setString(2, calendar.getManagingFertilization());
			pstmt.setString(2, calendar.getManagingPestDisease());
			pstmt.setString(2, calendar.getManagingWatering());
			pstmt.setString(2, calendar.getManagingVentilation());
			pstmt.setString(2, calendar.getManagingPottingTransplant());
			pstmt.setString(2, calendar.getManagingSoilReplacement());
			pstmt.setString(2, calendar.getManagingRemovalDeadplants());
			pstmt.setString(2, calendar.getManagingWaterReplacement());
			pstmt.setString(2, calendar.getManagingRelocation());
			pstmt.setString(2, calendar.getManagingFlowering());
			pstmt.setString(2, calendar.getManagingHarvesting());
			pstmt.setString(2, calendar.getManagingNutrientSupplement());
			pstmt.setString(2, calendar.getManagingNewGrowth());
			pstmt.setString(2, calendar.getManagingDormancy());
			
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateCalendarTodo(Connection conn, Calendar calendar, String userNo, Date calendarDate) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	return result;
	}

	public int deleteCalendarTodo(Connection conn, String userNo, Date calendarDate) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from calendar where  ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			pstmt.setDate(2, calendarDate);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


//	public ArrayList<Calendar> updateCalendarAlarm(Connection, String, Date) {}

}
