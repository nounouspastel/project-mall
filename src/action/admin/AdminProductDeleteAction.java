package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminProductDeleteService;
import vo.ActionForward;

public class AdminProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String pseq = request.getParameter("pseq");
		AdminProductDeleteService adminProductDeleteService = new AdminProductDeleteService();

			boolean isDeleteSuccess = adminProductDeleteService.removeAdminProduct(pseq);
			if(! isDeleteSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath("adminProductList.ad");
			}
		
	
		return forward;
	}
}
