package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃 컨트롤러
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			// 마지막 접속일 업데이트
			Member loginMember = (Member)session.getAttribute("loginMember");
			loginMember.setLastLoginDate(new Date(System.currentTimeMillis()));
			int result = new MemberService().updateMember(loginMember);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
			
			if(result > 0) {
				System.out.println(loginMember.getUserNo() + "의 last login date 업데이트 완료 : " + sdf.format(loginMember.getLastLoginDate()));
			} else {
				System.out.println(loginMember.getUserNo() + "의 last login date 업데이트 실패");
			}
			
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
