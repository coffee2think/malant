package board.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.service.CommentService;
import board.model.vo.Board;
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
		// getParameter 사용시 디비에서 값을 가져오는게 아니라 프론트에서 값을 받아 사용자에게 보여주는것으로
		// 프론트 values 에 해당 값을 이름을 지정해 보낼 수 있게 해준다 getParameter("jsp 에서 보내준 이름")
		// 프로필, 댓글내용, 댓글 날짜, 댓글의좋아요수, 보드번호, 사용자 닉네임
		comment.setUserNo(request.getParameter("userno"));
		comment.setBoardNo(Integer.parseInt(request.getParameter("bno"))); // 데이블명X
		comment.setCommentContent(request.getParameter("comment"));
		comment.setCommentContent(request.getParameter("profile"));
		
		
		
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
