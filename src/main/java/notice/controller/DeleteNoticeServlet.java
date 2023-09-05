package notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class DeleteNoticeServlet
 */
@WebServlet("/ndelete")
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteNoticeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int noticeNo = Integer.parseInt(request.getParameter("nno"));
        System.out.println(noticeNo);
        if (new NoticeService().deleteNotice(noticeNo) > 0) {
            String renameFileName = request.getParameter("rfile");
            if (renameFileName != null) {
                String savePath = request.getSession().getServletContext()
                        .getRealPath("resources/notice/notice_content_img");
                new File(savePath + "\\" + renameFileName).delete();
            }

            // 공지사항 목록을 다시 가져와서 "nlist" 속성으로 설정
            Notice nservice = new NoticeService().selectOne(noticeNo);
            request.setAttribute("nno", noticeNo);

            response.sendRedirect("/malant/ntitlelist");
        } else {
            RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
            request.setAttribute("message", noticeNo + "번 공지사항 삭제 실패!");
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
