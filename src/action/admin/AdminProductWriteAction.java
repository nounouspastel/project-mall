package action.admin;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.admin.AdminProductWriteService;
import vo.ActionForward;
import vo.admin.AdminProduct;

public class AdminProductWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminProductWriteService AdminProductWriteService = new AdminProductWriteService();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;		
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		AdminProduct product = new AdminProduct(
				multi.getParameter("pseq"),
				multi.getParameter("name"), 
				multi.getParameter("kind"), 
				Integer.parseInt(multi.getParameter("price_in")),
				Integer.parseInt(multi.getParameter("price_out")),
				multi.getParameter("content"),
				image, 0, null);
		boolean isRegistSuccess = AdminProductWriteService.writeProduct(product);  
		ActionForward forward = null;
		
		if(isRegistSuccess){
			forward = new ActionForward("adminProductList.ad", true);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패:상품코드 중복 및 누락된 부분 확인바랍니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}