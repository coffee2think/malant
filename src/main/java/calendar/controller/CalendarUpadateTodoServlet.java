package calendar.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendar.model.service.CalendarService;
import calendar.model.vo.Calendar;

/**
 * Servlet implementation class CalendarUpadateTodoServlet
 */
@WebServlet("/cupdate")
public class CalendarUpadateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarUpadateTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  request.setCharacterEncoding("utf-8");
		   
	      Calendar calendar = new Calendar();
	      
	      String userNo = request.getParameter("user_no");
		  Date calendarDate = Date.valueOf(request.getParameter("calendar_date"));
	      
	      calendar.setUserNo(request.getParameter("user_no"));
	      calendar.setCalendarDate(Date.valueOf(request.getParameter("calendar_date")));
	      calendar.setMyplantNo(request.getParameter("myplant_id"));
	      calendar.setDiaryNo(Integer.parseInt(request.getParameter("diary_no"))); 
	      calendar.setCalendarMemo(request.getParameter("calendar_memo"));
	      calendar.setManagingPruningTrimming(request.getParameter("mgr_prun_trim"));
	      calendar.setManagingFertilization(request.getParameter("mgr_fertilization"));
	      calendar.setManagingPestDisease(request.getParameter("mgr_pest_disease"));
	      calendar.setManagingWatering(request.getParameter("mgr_watering"));
	      calendar.setManagingVentilation(request.getParameter("mgr_ventilation"));
	      calendar.setManagingPottingTransplant(request.getParameter("mgr_replant"));
	      calendar.setManagingSoilReplacement(request.getParameter("mgr_soil_change"));
	      calendar.setManagingRemovalDeadplants(request.getParameter("mgr_disposal"));
	      calendar.setManagingWaterReplacement(request.getParameter("mgr_water_change"));
	      calendar.setManagingRelocation(request.getParameter("mgr_relocation"));
	      calendar.setManagingFlowering(request.getParameter("mgr_flowering"));
	      calendar.setManagingHarvesting(request.getParameter("mgr_harvest"));
	      calendar.setManagingNutrientSupplement(request.getParameter("mgr_nutrient"));
	      calendar.setManagingNewGrowth(request.getParameter("mgr_sprout"));
	      calendar.setManagingDormancy(request.getParameter("mgr_dormancy"));
	      
	      //모델 서비스로 전달하고 결과 받기
	      int result = new CalendarService().updateCalendarTodo(calendar, userNo, calendarDate);
	      
	      //성공/실패 페이지 내보내기
	      if (result > 0) {
	         response.sendRedirect("/malant/cnew");
	      }else {
	         RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
	         request.setAttribute("message", "새 일정 등록 실패");
	         view.forward(request, response);
	      }
	}	      
	 
	   /**
	    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	    */
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	      doGet(request, response);
	   }


	

}
