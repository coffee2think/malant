package store.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import store.main.model.service.MainService;
<<<<<<< HEAD
import store.main.model.vo.*;
=======
import store.main.model.vo.Main;
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976


/**
 * Servlet implementation class mainBannerServlet
 */
@WebServlet("/mbanner")
public class MainBannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainBannerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		        ArrayList<MainBanner> bannerList = new MainService().selectBanner();
		        
		        JSONArray jarr = new JSONArray();
		        
		        for(MainBanner banner : bannerList) {
		        	JSONObject job = new JSONObject();
		        	
		        	job.put("bimage", banner.getBannerImage());
		        	job.put("prority", banner.getBannerPrority());
		        	job.put("blink", banner.getBannerLink());
		        	
		        	jarr.add(job);
=======
		        ArrayList<Main> bannerList = new MainService().selectBanner();
		        
		        JSONArray jarr = new JSONArray();
		        
		        for(Main main : bannerList) {
		        	JSONObject job = new JSONObject();
		        	
		        	job.put("bimage", main.getBannerImage());
		        	job.put("prority", main.getBannerPrority());
		        	job.put("blink", main.getBannerLink());
		        	job.put("bstart", main.getBannerStart());
		        	job.put("bend", main.getBannerEnd());
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
		        }
		        JSONObject sendJson = new JSONObject();
		        sendJson.put("list", jarr);
		        
		        response.setContentType("application/json; charset=utf-8");
		        PrintWriter out = response.getWriter();
		        out.print(sendJson.toJSONString());
		        out.flush();
		        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
