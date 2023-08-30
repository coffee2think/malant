package calendar.model.service;

import calendar.model.dao.ArrayList;
import calendar.model.dao.Calendar;
import calendar.model.dao.CalendarDao;
import calendar.model.dao.Connection;

public class CalendarService {
	
	private CalendarDao cdao = new CalendarDao();	
		
	public int insertNewCalendarTodo(String, Date) {}
	
	public int updateCalendarTodo(Calendar, String, Date) {}
	
	public int deleteCalendarTodo(String, Date) {}

	public ArrayList<Calendar> updateCalendarAlarm(Calendar, String, Date) {}

	public int getManagingCount() {}
}
