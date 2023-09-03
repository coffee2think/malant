package diary.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.FileNameChange;
import diary.model.service.DiaryService;
import diary.model.vo.Diary;

/**
 * Servlet implementation class DiaryInsertNewServlet
 */
@WebServlet("/dnew")
public class DiaryInsertNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryInsertNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userNo = request.getParameter("user_no");
		
 
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("view/common/error.jsp");
			request.setAttribute("message", "enctype='multipart/form-data' 속성 누락됨.");
			view.forward(request, response);
		}
		
		int maxSize = 1024 * 1024 * 10;
		

		String savePath = request.getSession().getServletContext().getRealPath("/resources/diary/diary_upimages");
		

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		

		Diary diary = new Diary();

		diary.setUserNo(mrequest.getParameter("user_no"));
		diary.setDiaryId(mrequest.getParameter("diary_id"));
		diary.setMyplantId(mrequest.getParameter("myplant_id"));
		diary.setDiaryWritingDate(Date.valueOf(mrequest.getParameter("diary_writing_date")));
		diary.setDiaryContent(mrequest.getParameter("diary_content"));
		diary.setDiaryImage1URL(mrequest.getParameter("diary_image1_url"));
		diary.setDiaryImage2URL(mrequest.getParameter("diary_image2_url"));
		diary.setDiaryImage3URL(mrequest.getParameter("diary_image3_url"));
		diary.setDiaryImage4URL(mrequest.getParameter("diary_image4_url"));
		diary.setDiaryManaging1(mrequest.getParameter("diary_managing1"));
		diary.setDiaryManaging2(mrequest.getParameter("diary_managing2"));
		diary.setDiaryManaging3(mrequest.getParameter("diary_managing3"));
		diary.setDiaryManaging4(mrequest.getParameter("diary_managing4"));

		
		
		String upFileName = mrequest.getFilesystemName("upfile");
		diary.setDiaryImage1URL(upFileName);
		diary.setDiaryImage2URL(upFileName);
		diary.setDiaryImage3URL(upFileName);
		diary.setDiaryImage4URL(upFileName);
		

		if(upFileName != null) {
			
			String newUpFileName = FileNameChange.change(upFileName, savePath, "yyyyMMddHHmmss");
			
			diary.setDiaryImage1URL(newUpFileName);
			diary.setDiaryImage2URL(newUpFileName);
			diary.setDiaryImage3URL(newUpFileName);
			diary.setDiaryImage4URL(newUpFileName);
		}
		
		int result = new DiaryService().insertNewDiray(diary, userNo);
		
		//받은 결과로 성공/실패 페이지 내보내기
		if(result > 0) {
			//서블릿에서 서블릿 실행함
			response.sendRedirect("/malant/dlist?page=1");
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "일기 등록 실패");
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
