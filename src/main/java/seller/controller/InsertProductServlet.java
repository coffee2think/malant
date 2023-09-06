package seller.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import seller.model.service.SellersService;
import store.product.model.vo.ProductDetail;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/sellpinsert")
public class InsertProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "/malant/resources/store/images";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 파일 업로드 설정
        int maxSize = 1024 * 1024 * 10; // 최대 10MB
        String encoding = "UTF-8";
        String uploadPath = getServletContext().getRealPath(UPLOAD_DIRECTORY);

        MultipartRequest mrequest = new MultipartRequest(
                request,
                uploadPath,
                maxSize,
                encoding,
                new DefaultFileRenamePolicy()
        );

        ProductDetail pdtail = new ProductDetail();

        pdtail.setProductName(mrequest.getParameter("product_name"));
        pdtail.setSellerName(mrequest.getParameter("store_name"));
        pdtail.setPrice(Integer.parseInt(mrequest.getParameter("price")));
        pdtail.setDeliveryCharge(Integer.parseInt(mrequest.getParameter("shipping_cost")));
        pdtail.setProductDescription(mrequest.getParameter("detail_description"));

//        FileItem thumbnailFileItem = mrequest.getFileItem("thumbnail_image");
//        if (thumbnailFileItem != null && !thumbnailFileItem.getName().isEmpty()) {
//            String thumbnailFileName = getUniqueFileName(thumbnailFileItem.getName());
//            String thumbnailFilePath = UPLOAD_DIRECTORY + File.separator + thumbnailFileName;
//            File thumbnailFile = new File(thumbnailFilePath);
//            thumbnailFileItem.write(thumbnailFile);
//            pdtail.setThumbnailImg(thumbnailFilePath);
//        }
//
//        FileItem detailImageFileItem = mrequest.getFileItem("detail_image");
//        if (detailImageFileItem != null && !detailImageFileItem.getName().isEmpty()) {
//            String detailImageFileName = getUniqueFileName(detailImageFileItem.getName());
//            String detailImageFilePath = UPLOAD_DIRECTORY + File.separator + detailImageFileName;
//            File detailImageFile = new File(detailImageFilePath);
//            detailImageFileItem.write(detailImageFile);
//            pdtail.setDetailImage(detailImageFilePath);
//        }

        ArrayList<String> options = new ArrayList<String>();

        String option5 = null;
        String option6 = null;

        for (int i = 1; i <= 8; i++) {
            if (mrequest.getParameter("option" + i) != null) {
                if (!(mrequest.getParameter("option" + i).equals("난이도")
                        || mrequest.getParameter("option" + i).equals("일조량")
                        || mrequest.getParameter("option" + i).equals("습도")
                        || mrequest.getParameter("option" + i).equals("정화능력")
                        || mrequest.getParameter("option" + i).equals("가습효과")
                        || mrequest.getParameter("option" + i).equals("크기")
                        || mrequest.getParameter("option" + i).equals("용도")
                        || mrequest.getParameter("option" + i).equals("재질")
                        || mrequest.getParameter("option" + i).equals("종류"))) {
                    if ("유".equals(mrequest.getParameter("option" + i)) && i == 5) {
                        option5 = "purification";
                    } else if ("유".equals(mrequest.getParameter("option" + i)) && i == 6) {
                        option6 = "humidifying";
                    } else {
                        option5 = null;
                        option6 = null;
                    }
                    options.add(mrequest.getParameter("option" + i));
                }
            }
        }

        RequestDispatcher view = null;

        int result = new SellersService().sellerInsertProduct(pdtail, options);
        if (result > 0) {
            System.out.println("성공");
            view = request.getRequestDispatcher("malant/sellplist?sellerNo=seller001");
        } else {
            System.out.println("실패");
        }
    }

    private String getUniqueFileName(Part part) {
        String submittedFileName = getSubmittedFileName(part);
        String fileExtension = submittedFileName.substring(submittedFileName.lastIndexOf('.'));
        String uniqueFileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + fileExtension;
        return uniqueFileName;
    }

    private String getSubmittedFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
    }


	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
