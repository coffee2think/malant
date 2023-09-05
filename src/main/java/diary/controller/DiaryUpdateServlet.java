package diary.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.FileNameChange;
import diary.model.service.DiaryService;
import diary.model.vo.Diary;

/**
 * Servlet implementation class DiaryUpdateServlet
 */
@WebServlet("/dupdate")
public class DiaryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiaryUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("utf-8");
				
				String userNo = request.getParameter("user_no");
				String diaryId = request.getParameter("diary_id");
				
				RequestDispatcher view = null;
				
				if(!ServletFileUpload.isMultipartContent(request)) {
					view = request.getRequestDispatcher("view/common/error.jsp");
					request.setAttribute("message", "form의 enctype='multipart/form-data' 속성 누락됨.");
					view.forward(request, response);
				}
				
				
				int maxSize = 1024 * 1024 * 10;
				
				
				String savePath = request.getSession().getServletContext().getRealPath("/resources/diary/diary_upimages");
				
		
				
				MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
				
				
				Diary diary = new Diary();
				
				diary.setUserNo(mrequest.getParameter("user_no"));
				diary.setDiaryWritingDate(Date.valueOf(mrequest.getParameter("diary_writing_date")));
				diary.setDiaryContent(mrequest.getParameter("diary_content"));
				
				int currentPage = Integer.parseInt(mrequest.getParameter("page"));
				
				//이전 첨부파일에 대한 삭제여부 값 추출
				String deleteFlag = mrequest.getParameter("deleteFlag");
				
				//이전 첨부파일의 파일명 추출
				String inFileName = mrequest.getParameter("inFile");
				
				//6.새로운 첨부파일명 추출
				String upFileName = mrequest.getFilesystemName("upFile");
				
				/*
				 * //첨부파일 확인: //원래 파일과 새로 업로드된 파일의 이름이 갖고, //파일의 용량도 동일하면 원래 이름 그대로 기록함 //업로드된
				 * 파일의 file 객체 만들기 File upFile = new File(savePath + "\\" + upFileName); File
				 * inFile = new File(savePath + "\\" + inFileName);
				 * 
				 * 
				 * //이전 첨부파일이 있었다면 삭제함 if(inFileName != null) { new File(savePath + "\\" +
				 * inFileName).delete();
				 * 
				 * }
				 * 
				 * }
				 */
					
				// 6. 서비스 메소드로 전달하고 결과받기
				int result = new DiaryService().updateDiary(diary);

				// 7. 받은 결과로 성공/실패 페이지 내보내기
				if (result > 0) {
					//서블릿에서 서블릿 실행
					response.sendRedirect("/malant/mpinfo?myplantId=" + diary.getDiaryId() + "&page=" + currentPage);
				} else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", 
							"일기 수정 실패!");
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
