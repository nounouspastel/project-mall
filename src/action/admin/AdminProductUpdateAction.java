package action.admin;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.admin.AdminProductUpdateService;
import vo.ActionForward;
import vo.admin.AdminProduct;

public class AdminProductUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminProductUpdateService adminProductUpdateService = new AdminProductUpdateService();
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
		boolean isModifySuccess = adminProductUpdateService.adminModifyProduct(product);	
		ActionForward forward = null;
		
			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("adminProductList.ad?"); 
			}

		return forward;
	}

}