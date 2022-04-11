package action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminProductUpdatFormeService;
import vo.ActionForward;
import vo.admin.AdminProduct;

public class AdminProductUpdatFormeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminProductUpdatFormeService adminProductUpdatFormeService = new AdminProductUpdatFormeService();		
		String pseq = request.getParameter("pseq");		
		AdminProduct product = adminProductUpdatFormeService.getProductUpdate(pseq);

		request.setAttribute("product", product);

		ActionForward forward = new ActionForward("product/productUpdate.jsp", false);
		return forward;
	}

}