package action.Product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Product.ProductListService;
import vo.ActionForward;
import vo.Product;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductListService ProductListService = new ProductListService();		
		ArrayList<Product> productList = ProductListService.getProductList();
		request.setAttribute("productList", productList);
		ActionForward forward = new ActionForward("shop-Detail.jsp", false);	
		
		return forward;
	}
}