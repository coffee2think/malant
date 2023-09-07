package community.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.BoardService;
import community.model.vo.CMBoardPhoto;

/**
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/bdelete")
public class DeleteCommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCommunityServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService bservice = new BoardService();
		RequestDispatcher view = null;
		int boardNo = Integer.parseInt(request.getParameter("board"));
		
		ArrayList<CMBoardPhoto> list = bservice.selectBoardPhotoList(boardNo);
		
		for(CMBoardPhoto photo : list) {
			String fileName = photo.getFilename();
			if(fileName != null) {
				String savePath = request.getSession().getServletContext()
						.getRealPath("/resources/board/images");
				new File(savePath + "\\" + fileName).delete();
			}
		}
		
		int result = bservice.deleteBoard(boardNo);
		if(result > 0) {
			response.sendRedirect("bdlist");
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", boardNo + "번 게시글 삭제 실패!");
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
