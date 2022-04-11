package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.admin.AdminLoginService;
import vo.ActionForward;
import vo.admin.Admin;

public class AdminLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Admin admin = new Admin();
		
		admin.setAdmin_id(request.getParameter("admin_id"));
		admin.setAdmin_pwd(request.getParameter("admin_pwd"));
		
		AdminLoginService adminLoginService = new AdminLoginService();
		boolean loginResult = adminLoginService.login(admin);
		ActionForward forward = null;
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("admin_id", admin.getAdmin_id());
			forward.setRedirect(true);
			forward.setPath("adminProductList.ad");

		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}