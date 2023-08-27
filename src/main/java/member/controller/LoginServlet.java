package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("loginid");
		String userPwd = request.getParameter("loginpwd");
		
		// 패스워드 암호화 처리 : SHA-512
		String cryptoUserpwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] pwdValues = userPwd.getBytes(Charset.forName("UTF-8"));
			
			md.update(pwdValues);
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 서비스 메소드로 값 전달 실행하고 결과 받기
//		Member loginMember = new MemberService().selectLogin(userId, cryptoUserpwd);
		Member loginMember = new MemberService().selectLogin(userId, userPwd);
		
		
		// 받은 결과를 가지고 성공/실패 페이지 내보내기
		if(loginMember != null && loginMember.getBlockedYn().equals("N")) { // 로그인 성공
			// 로그인 상태 확인용 세션 객체 생성
			HttpSession session = request.getSession();
			
			// 로그인한 회원의 정보를 세션객체에 저장함
			session.setAttribute("loginMember", loginMember);
			
			// 로그인 성공시 내보낼 페이지 지정
			response.sendRedirect("index.jsp");
		} else { // 로그인 실패
			// 에러페이지 뷰 객체 생성
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			
			// 뷰로 보낼 메시지 설정
			if(loginMember != null && loginMember.getBlockedYn().equals("Y")) { // 제한된 회원이라면
				request.setAttribute("message", "로그인이 제한된 회원입니다. 관리자에게 문의하세요.");
			} else if(loginMember == null) {
				request.setAttribute("message", "로그인 실패. 아이디 또는 암호를 확인하세요.");
			}
			
			// 요청한 클라이언트로 전송함
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
