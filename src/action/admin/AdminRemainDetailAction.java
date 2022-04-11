package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminRemainDetailService;
import vo.ActionForward;
import vo.admin.AdminRemain;

public class AdminRemainDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminRemainDetailService adminRemainDetailService = new AdminRemainDetailService();
		String order_num = request.getParameter("order_num");
		AdminRemain remain = adminRemainDetailService.getAdminRemainView(order_num);
		request.setAttribute("remain", remain);
		
		ActionForward forward = new ActionForward("remain/remainDetail.jsp", false);
		return forward;
	}

}
