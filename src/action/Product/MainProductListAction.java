package action.Product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Product.MainProductListService;
import vo.ActionForward;
import vo.Product;

public class MainProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kind = request.getParameter("kind");
		MainProductListService adminProductListService = new MainProductListService();		
		ArrayList<Product> productList = adminProductListService.getAdminProductList(kind);
		request.setAttribute("productList", productList);
		ActionForward forward = new ActionForward("shop-List.jsp", false);	
		
		return forward;
	}
}