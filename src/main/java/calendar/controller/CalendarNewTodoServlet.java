package calendar.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendar.model.service.CalendarService;
import calendar.model.vo.Calendar;

/**
 * Servlet implementation class CalendarNewTodoServlet
 */
@WebServlet("/cnew")
public class CalendarNewTodoServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarNewTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //캘린더 일정 추가 처리 컨트롤러
      
      //1. 데이터 베이스에 기록할 값 추출
      Calendar calendar = new Calendar();
      RequestDispatcher view = null;
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
       String stdate = request.getParameter("date");  
       Date date = null;
      try {
         date = (Date)sdf.parse(stdate);
      } catch (ParseException e) {
         e.printStackTrace();
      }
   
      calendar.setCalendarDate(date);
      calendar.setCalendarMemo(request.getParameter("memo"));
      /* calendar.setDiaryNo(Integer.parseInt(request.getParameter("diaryno"))); */
      calendar.setManagingPruningTrimming(request.getParameter("pruningtrimming"));
      calendar.setManagingFertilization(request.getParameter("fertilization"));
      calendar.setManagingPestDisease(request.getParameter("disease"));
      calendar.setManagingWatering(request.getParameter("watering"));
      calendar.setManagingVentilation(request.getParameter("ventilation"));
      calendar.setManagingPottingTransplant(request.getParameter("pottingtrans"));
      calendar.setManagingSoilReplacement(request.getParameter("soilreplace"));
      calendar.setManagingRemovalDeadplants(request.getParameter("removedead"));
      calendar.setManagingWaterReplacement(request.getParameter("waterreplace"));
      calendar.setManagingRelocation(request.getParameter("relocation"));
      calendar.setManagingFlowering(request.getParameter("flowering"));
      calendar.setManagingHarvesting(request.getParameter("harvesting"));
      calendar.setManagingNutrientSupplement(request.getParameter("nutrient"));
      calendar.setManagingNewGrowth(request.getParameter("newgrowth"));
      calendar.setManagingDormancy(request.getParameter("dormancy"));
      
      //모델 서비스로 전달하고 결과 받기
      int result = new CalendarService().insertNewCalendarTodo(calendar);
      
      //성공/실패 페이지 내보내기
      if (result > 0) {
         response.sendRedirect("/malant/cnew");
      }else {
         view = request.getRequestDispatcher("views/common/error.jsp");
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