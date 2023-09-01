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
import board.model.vo.Board;
import board.model.vo.Comment;
import member.model.service.MemberService;
import member.model.vo.Member;


/**
 * Servlet implementation class BoardListSortByDateServlet
 */
@WebServlet("/bdlist")
public class BoardListSortByDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardListSortByDateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Board> list = new BoardService().selectListSortByDate();
		
		
		JSONArray jarr = new JSONArray();
		
		
		for (Board board : list) {
			JSONObject job = new JSONObject();
			Member member = new MemberService().selectMemberByUserNo(board.getUserNo());
			Comment comment = new BoardService().selectBestComment(board.getBoardNo());
		
			// 게시글 사진, 좋아요 수, 프로필 사진, 사용자 닉네임, 작성날짜
			job.put("bno", board.getBoardNo());
			job.put("bnick", URLEncoder.encode(board.getNickname(), "utf-8"));
			job.put("btitle", URLEncoder.encode(board.getBoardTitle(), "utf-8"));
			job.put("blike", board.getBoardLike());
			job.put("bphoto",board.getBoardPhoto());
			job.put("bprofile", member.getProfileImg());
			// date 타입은 꼭 형변환 해주기!!
			job.put("bdate", board.getBoardDate().toString());
			job.put("bcontent",URLEncoder.encode(board.getBoardContent(), "utf-8"));
	
			// Comment 가져오기
			
			if (comment != null) {
			
				job.put("cno", comment.getCommentNo());
				job.put("bno", comment.getBoardNo());
				job.put("userno", URLEncoder.encode(comment.getUserNo(), "utf-8"));
				job.put("nickname", URLEncoder.encode(comment.getNickname(), "utf-8"));
				job.put("clike", comment.getCommentLike());
				job.put("ccontent", URLEncoder.encode(comment.getCommentContent(), "utf-8"));
				job.put("cdate", comment.getCommentDate().toString());
				
			}			
			jarr.add(job);
		}
		
		JSONObject sendJson = new JSONObject();
		sendJson.put("dlist", jarr);

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sendJson.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
