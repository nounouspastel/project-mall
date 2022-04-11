package action.Product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.Product.ProductDetailService;
import svc.Product.ProductListService;
import vo.ActionForward;
import vo.Product;

public class ProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDetailService ProductDetailService = new ProductDetailService();
		String pseq = request.getParameter("pseq");
		Product product = ProductDetailService.getsProductDetail(pseq);
		request.setAttribute("product", product);
		
		ProductListService ProductListService = new ProductListService();		
		ArrayList<Product> productList = ProductListService.getProductList();
		request.setAttribute("productList", productList);
		
		ActionForward forward = new ActionForward("shop-Detail.jsp", false);
		return forward;
	}

}
