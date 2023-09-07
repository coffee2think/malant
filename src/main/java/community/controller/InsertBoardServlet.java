package community.controller;

import java.io.File;
import java.io.IOException;

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
import community.model.service.BoardService;
import community.model.vo.Board;
import community.model.vo.CMBaordHashtag;
import community.model.vo.CMBoardPhoto;
import community.model.vo.CMHashtag;
import net.coobird.thumbnailator.Thumbnails;

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
		String savePath = request.getSession().getServletContext().getRealPath("/resources/board/images");

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		Board board = new Board();

		board.setUserNo(mrequest.getParameter("userno"));
		board.setNickname(mrequest.getParameter("writer"));
		board.setBoardTitle(mrequest.getParameter("title"));
		board.setBoardContent(mrequest.getParameter("content"));

		String[] hashtags = mrequest.getParameterValues("hashtag");

//		String originalFileName = mrequest.getFilesystemName("multifile");
//		System.out.println(originalFileName);

//
//		CMBoardPhoto photo = null;
//		if (originalFileName != null) {
//			// 업로드된 파일이 있을 때만 파일명 바꾸기 실행함
//			photo = new CMBoardPhoto();
//			renameFileName = FileNameChange.change(originalFileName, savePath, "yyyyMMddHHmmss");
//
//			photo.setFilename(renameFileName);
//		} // 업로드된 파일이 있다면...
		// board.getThumbnail(renameFileName);

		// request.getSession().getServletContext() => "/first" + 뒤에 하위 폴더 경로 추가함

		// 4. request 를 MultipartRequest 로 변환해야 함
		// MultipartRequest 클래스는 외부 라이브러리를 사용해야 함 : cos.jar 사용한 경우
		// MultipartRequest 객체가 생성되면, 자동으로 지정 폴더에 업로드된 파일이 저장됨

		// 5. 데이터베이스 board 테이블에 기록할 값 추출
		// mrequest 사용해야 함 (request 사용 못 함)//
		/*
		 * System.out.println(mrequest.getParameter("title"));
		 * System.out.println(mrequest.getParameter("writer"));
		 * System.out.println(mrequest.getParameter("content"));
		 * System.out.println(mrequest.getParameter("hashtag"));
		 * 
		 */

		// 6. 업로드된 원본 파일이름 추출
//		for (String fname : fileNames) {
//			System.out.println(fname);
//		}

		// 6. 업로드된 원본 파일이름 추출 : 마지막 파일명만 출력됨
//				Enumeration fileList = mrequest.getFileNames();
//				Iterator fileIter = fileList.asIterator();
//				while (fileIter.hasNext()) {
//					String paramName = (String) fileIter.next();
//					System.out.println("폴더에 저장된 파일명 : " + mrequest.getFilesystemName(paramName));
//					System.out.println("전송온 원래 파일명 : " + mrequest.getOriginalFileName(paramName));
//				}

		// *******************************************************
		// 업로드된 이미지 파일 중 첫번째 이미지를 썸네일 이미지로 만들기
		// Thumbnailator 라이브러리를 사용한 경우
		String[] fileNames = mrequest.getParameterValues("filenames");
		File[] imageFiles = new File[fileNames.length];
		for(int i = 0; i < imageFiles.length; i++) {
			imageFiles[i] = new File(savePath + "\\" + fileNames[i]);;
		}
		
		String[] renameFileNames = new String[fileNames.length];
		for(int i = 0; i < renameFileNames.length; i++) {
			renameFileNames[i] = FileNameChange.change(imageFiles[i].getName(), savePath, "yyyyMMddHHmmss");
		}
				
		String thumbFileName = "thumb_" + renameFileNames[0];
		File thumbFile = new File(savePath + "\\" + thumbFileName);

		for(int i = 0; i < renameFileNames.length; i++) {
			imageFiles[i] = new File(savePath + "\\" + renameFileNames[i]);
		}
//		firstImageFile = new File(savePath + "\\" + renameFileName);

		Thumbnails.of(imageFiles[0]).size(50, 50).toFile(thumbFile);

		System.out.println(imageFiles[0].getName() + " : " + thumbFile);

		board.setThumbnail(thumbFileName);
		System.out.println("thumbFileName : " + thumbFileName);
		
		
		int result = new BoardService().insertBoard(board);
		

		if (result > 0) {
			int boardNo = new BoardService().selectRecentBoardNo();
			
			for (int i = 0; i < renameFileNames.length; i++) {
				CMBoardPhoto photo = new CMBoardPhoto();
				photo.setBoardNo(boardNo);
				photo.setFilename(renameFileNames[i]);
				int result2 = new BoardService().insertBoardPhoto(photo);

				if (result2 > 0) {
					System.out.println(renameFileNames[i] + " 사진 삽입 성공");
				} else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "새글 사진 등록 실패!");
					view.forward(request, response);
				}
			}

			for (int i = 0; i < hashtags.length; i++) {
				CMHashtag hashtag = new CMHashtag();
				hashtag.setHashtagContent(hashtags[i]);

				CMHashtag hashtagOk = new BoardService().selectHashtag(hashtags[i]);
				if(hashtagOk == null) {
					int result3 = new BoardService().insertHashtag(hashtags[i]);
					
					if(result3 > 0) {
						System.out.println(hashtags[i] + " 해시태그 삽입 성공");
					} else {
						System.out.println(hashtags[i] + " 해시태그 존재함");
					}
				}
				
				int hashtagNo = new BoardService().selectHashtagNo(hashtags[i]);
				
				CMBaordHashtag boardHashTag = new CMBaordHashtag();
				boardHashTag.setBoardNo(boardNo);
				boardHashTag.setHashtagNo(hashtagNo);
				
				int result4 = new BoardService().insertBoardHashtag(boardHashTag);
				if (result4 > 0) {
					System.out.println(boardNo + "번 게시글에 " + hashtags[i] + "해쉬태그 삽입 성공");
				} else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", boardNo + "번 게시글에 " + hashtags[i] + "해쉬태그 삽입 실패");
					view.forward(request, response);
				}
			}
			
//			view = request.getRequestDispatcher("bdlist");
//			view.forward(request, response);
			response.sendRedirect("bdlist");

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
