package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminOrder_detailDeleteService;
import vo.ActionForward;

public class AdminOrder_detailDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String odseq = request.getParameter("odseq");
		String pseq = request.getParameter("pseq");
		AdminOrder_detailDeleteService adminOrder_detailDeleteService = new AdminOrder_detailDeleteService();

			boolean isDeleteSuccess = adminOrder_detailDeleteService.removeAdminOrder_detail(odseq,pseq);
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
				forward.setPath("adminOrder_detailList.od");
			}
		
	
		return forward;
	}
}