package store.order.controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.PrintWriter;

>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import member.model.service.MemberService;
import member.model.vo.Member;

>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
/**
 * Servlet implementation class AddOrderListServlet
 */
@WebServlet("/addolist")
public class AddOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderListServlet() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
		// 회원가입 시 등록할 아이디 중복 체크 요청 처리용 컨트롤러(ajax)
		
		String userId = request.getParameter("userid");
		int idCount = new MemberService().selectCheckId(userId);
		System.out.println("idCount : " + idCount);
		String returnValue = null; //ajax로 보낼 메시지
		
		if(idCount == 0) {
			returnValue = "ok";
		} else {
			returnValue = "duplicate";
		}
		
		//ajax 통신은 네트워크 입출력 → 별도의 스트림을 열어서 사용
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(returnValue);
		out.flush();
		out.close();
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
	}

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
