package store.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import store.main.model.service.MainService;
import store.main.model.vo.MainBanner;
import store.main.model.vo.MainProduct;

/**
 * Servlet implementation class mainListViewServlet
 */
@WebServlet("/mlist")
public class MainListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<MainProduct> MainProductList = new MainService().selectMainProductList();
        
        JSONArray jarr = new JSONArray();
        
        for(MainProduct mainpl : MainProductList) {
        	JSONObject job = new JSONObject();
        	
        	job.put("productid", mainpl.getProductId());
        	job.put("productname", URLEncoder.encode(mainpl.getProductName(), "UTF-8"));
        	job.put("price", mainpl.getPrice());
        	job.put("thumbnail", mainpl.getProductThumbnail());
        	job.put("simpleExp",  URLEncoder.encode(mainpl.getProductSimpleExplan(), "UTF-8")); 	
        	
        	jarr.add(job);
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
