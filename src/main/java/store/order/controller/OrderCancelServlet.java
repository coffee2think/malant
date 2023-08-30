package store.order.controller;

import java.io.IOException;
<<<<<<< HEAD
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
=======
import member.model.service.MemberService;
import member.model.vo.Member;

>>>>>>> cd63facf850b2123faeced3ad88786a403cfd976
/**
 * Servlet implementation class OrderCancelServlet
 */
@WebServlet("/ocancel")
public class OrderCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCancelServlet() {
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
		// 회원가입 처리용 컨트롤러
		//1. 전송온 값에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("UTF-8");  //전송보낸 뷰페이지의 문자셋(charset)을 값으로 사용함
		
		//2. 전송온 값 꺼내서 변수 또는 객체에 옮겨 저장하기
		Member member = new Member();  //모델 서비스로 보낼 값의 갯수가 1개 이상이면 객체에 저장함
		
		member.setUserId(request.getParameter("userid"));
		String userpwd = request.getParameter("userpwd");  //암호화 처리를 위해 변수에 저장
		member.setNickname(request.getParameter("nickname"));
		member.setEmail(request.getParameter("email"));
		
		/* 프로필 이미지 코드 수정해야함 */
		member.setProfileImg("/malant/resources/member_profiles/2308271740.jpg");
		
		member.setSignType(request.getParameter("signtype").toUpperCase());
		member.setReceptionNotification(request.getParameter("alarm") == null ? "N" : "Y");
		member.setReceptionAd(request.getParameter("notice") == null ? "N" : "Y");
		
		//웹에서는 암호화 알고리즘 사용시 단방향 알고리즘만 사용함 : SHA-512
		//단방향 알고리즘은 복호화 알고리즘이 없음
		//java.security.MessageDigest 클래스 이용함
		String cryptoUserpwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			//패스워드 문자열을 암호문으로 바꾸려면, byte[] 로 변환해야 함
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
			//암호문으로 바꾸기
			md.update(pwdValues);
			//암호화된 byte[] 을 String 으로 바꿈 : 암호문 상태임
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			
			//확인
			//System.out.println("암호화된 패스워드 : " + cryptoUserpwd);
			//System.out.println("글자길이 : " + cryptoUserpwd.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		member.setUserPwd(cryptoUserpwd);
		
		//3. 모델의 서비스 메소드로 값 전달 실행하고 결과받기
		int result = new MemberService().insertMember(member);
		
		//4. 받은 결과로 성공 또는 실패 페이지 내보내기
		if(result > 0) {
			//회원가입 성공시 로그인 페이지로 이동 처리
			response.sendRedirect("/malant/views/member/loginPage.jsp");
		} else {
			//회원가입 실패시 error.jsp 로 에러메세지를 보냄
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			//상대경로만 사용할 수 있음
			
			//지정한 뷰로 내보낼 정보나 객체가 있으면 request에 기록 저장함
			//request.setAttribute(String name, Object value);
			request.setAttribute("message", "회원가입 실패!");
			
			//뷰를 포워딩함
			view.forward(request, response);
		}
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
