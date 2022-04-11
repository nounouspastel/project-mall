package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminProductDetailService;
import vo.ActionForward;
import vo.admin.AdminProduct;

public class AdminProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminProductDetailService adminProductDetailService = new AdminProductDetailService();
		String pseq = request.getParameter("pseq");
		AdminProduct product = adminProductDetailService.getAdminProductView(pseq);
		request.setAttribute("product", product);
		
		ActionForward forward = new ActionForward("product/productDetail.jsp", false);
		return forward;
	}

}
