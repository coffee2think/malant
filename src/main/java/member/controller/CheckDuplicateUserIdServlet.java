<<<<<<< HEAD
package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class CheckDuplicateUserIdServlet
 */
@WebServlet("/checkdupid")
public class CheckDuplicateUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDuplicateUserIdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
=======
package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class CheckDuplicateUserIdServlet
 */
@WebServlet("/checkdupid")
public class CheckDuplicateUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDuplicateUserIdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
