package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminOrder_detailviewService;
import vo.ActionForward;
import vo.admin.AdminOrder_detail;

public class AdminOrder_detailviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminOrder_detailviewService adminOrder_detailviewService = new AdminOrder_detailviewService();
		String odseq = request.getParameter("odseq");
		String pseq = request.getParameter("pseq");
		AdminOrder_detail order_detail = adminOrder_detailviewService.getOrder_detailview(odseq, pseq);
		request.setAttribute("order_detail", order_detail);
		
		ActionForward forward = new ActionForward("order/orderUpdate.jsp", false);
		return forward;
	}

}
