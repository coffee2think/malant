package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.model.service.BoardService;
import board.model.service.CommentService;
import board.model.vo.Board;
import board.model.vo.Comment;

/**
 * Servlet implementation class CommentListSortByLikeServlet
 */
@WebServlet("/cmllist")
public class CommentListSortByLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CommentListSortByLikeServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Comment> list = new CommentService().selectCommentList();
		JSONArray jarr = new JSONArray();

		for (Comment comment : list) {
			JSONObject job = new JSONObject();
			Board board = new BoardService().selectBoardByBoardNo(comment.getBoardNo());
			job.put("cno", comment.getCommentNo());
			job.put("bno", comment.getBoardNo());
			job.put("userno", URLEncoder.encode(comment.getUserNo(), "utf-8"));
			job.put("nickname", URLEncoder.encode(comment.getNickname(), "utf-8"));
			job.put("clike", comment.getCommentLike());
			job.put("ccontent", URLEncoder.encode(comment.getCommentContent(), "utf-8"));
			job.put("cdate", comment.getCommentDate());
			job.put("clike", comment.getLikeDate().toString());
			job.put("clikeyn", comment.getLikeYn());

			jarr.add(job);
			//System.out.println("댓글 확인 :" + comment.toString());
		}
		JSONObject sendJson = new JSONObject();
		sendJson.put("commentlist", jarr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sendJson.toJSONString());
		out.flush();
		out.close();
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
