package community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.FileNameChange;
import community.model.service.BoardService;
import community.model.vo.Board;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/binsert")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public InsertBoardServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form의 enctype='multipart/form-data' 속성 누락됨.");
			view.forward(request, response);
		}
		int maxSize = 1024 * 1024 * 10;
		String savePath = request.getSession().getServletContext().getRealPath("/resources/board/images/");

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		Board board = new Board();
		board.setUserNo(mrequest.getParameter("userno"));
		board.setNickname(mrequest.getParameter("nickname"));
		board.setBoardTitle(mrequest.getParameter("title"));
		board.setBoardContent(mrequest.getParameter("content"));
	
		String renameFileName = null;

		String originalFileName = mrequest.getFilesystemName("input-image");
		System.out.println(originalFileName);
		renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");

		board.setBoardPhoto(renameFileName);

		int result = new BoardService().insertBoard(board);

		if (result > 0) {
			String link = "/malant/myblist?userno=" + board.getUserNo();
			response.sendRedirect(link);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "새 게시 원글 등록 실패!");
			view.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
