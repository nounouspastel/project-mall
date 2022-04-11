package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminRemainDeleteService;
import vo.ActionForward;

public class AdminRemainDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		String order_num = request.getParameter("order_num");
		AdminRemainDeleteService adminRemainDeleteService = new AdminRemainDeleteService();

			boolean isDeleteSuccess = adminRemainDeleteService.removeAdminRemain(order_num);
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
				forward.setPath("adminRemainList.re");
			}
		
	
		return forward;
	}
}