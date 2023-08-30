package store.main.controller;

import java.io.IOException;
<<<<<<< HEAD
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

=======
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import store.main.model.service.MainService;
import store.main.model.vo.MainBanner;
import store.main.model.vo.MainProduct;
=======
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976

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
<<<<<<< HEAD
        // TODO Auto-generated constructor stub
=======
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD

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
=======
		// 전송온 값 변수 저장
		String email = request.getParameter("email");
		
		// 서비스 메소드로 값 전달 실행하고 결과 받기
		Member member = new MemberService().selectEmail(email);
		
		// 받은 결과를 가지고 성공/실패 페이지 내보내기
		if(member == null) { // email이 존재하지 않으면
			
		} else { // 로그인 실패
			// 에러페이지 뷰 객체 생성
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			
			// 뷰로 보낼 메시지 설정
			if(member != null && member.getBlockedYn().equals("Y")) { // 제한된 회원이라면
				request.setAttribute("message", "로그인이 제한된 회원입니다. 관리자에게 문의하세요.");
			} else if(member == null) {
				request.setAttribute("message", "로그인 실패. 아이디 또는 암호를 확인하세요.");
			}
			
			// 요청한 클라이언트로 전송함
			view.forward(request, response);
		}
	}
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
		doGet(request, response);
	}

}
