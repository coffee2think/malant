package community.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import community.model.service.BoardService;
import community.model.vo.Board;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class BoardTop3LikeServlet
 */
@WebServlet("/btoplike")
public class BoardTop3LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardTop3LikeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ajax 요청으로 조회수 많은 인기 게시글 3개 조회 요청 처리용 컨트롤러

		ArrayList<Board> list = new BoardService().selectTop3Like();
		//System.out.println(list.toString());
		JSONArray jarr = new JSONArray();
		
		for (Board board : list) {
			JSONObject job = new JSONObject();
		
			// 한글이 있는 값 인코딩 처리
			job.put("bno", board.getBoardNo());
			job.put("bnick", URLEncoder.encode(board.getNickname(), "utf-8"));
			job.put("btitle", URLEncoder.encode(board.getBoardTitle(), "utf-8"));
			job.put("blike", board.getBoardLike());
			job.put("bthum", board.getThumbnail());
			job.put("bcount", board.getViewcount());
			job.put("bdate", board.getBoardDate().toString());
			
			jarr.add(job);
		}

		//System.out.println("안찍힘");
		
		JSONObject sendJson = new JSONObject();
		sendJson.put("blist", jarr);

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
