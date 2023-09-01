package board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.CommentService;
import board.model.vo.Comment;

/**
 * Servlet implementation class InsertCommentServlet
 */
@WebServlet("/cminsert")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertCommentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		Comment comment = new Comment();
		
		comment.setUserNo(request.getParameter("USER_NO"));
		comment.setBoardNo(Integer.parseInt(request.getParameter("BOARD_NO")));
		comment.setCommentContent(request.getParameter("COMMENT_CONTENT"));
		comment.setCommentLike(Integer.parseInt(request.getParameter("COMMENT_LIKE")));
		
		String commentDateStr = request.getParameter("COMMENT_DATE");
		Date commentDate = Date.valueOf(commentDateStr);
		
		comment.setLikeDate(commentDate);
		
		CommentService cservice = new CommentService();
		cservice.insertComment(comment);
		
		int result = cservice.insertComment(comment);
		
		if (result > 0) {
			response.sendRedirect("/malant/bdetail?bno=" + boardNo);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("view/common/error.jsp");
			request.setAttribute("message", boardNo + "번 게시글의 댓글 등록 실패");
			view.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
