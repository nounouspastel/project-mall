package action.basket;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.basket.BasketListService;
import vo.ActionForward;
import vo.Cart;

public class BasketListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		BasketListService basketListService = new BasketListService();
		ArrayList<Cart> cartList = (ArrayList<Cart>) basketListService.getCartList(id);
		
		int totalMoney = 0;
		int money=0;
		if(cartList != null) {
			for(int i = 0; i < cartList.size(); i++) {
				money = cartList.get(i).getPrice_out()*cartList.get(i).getQuantity();
				totalMoney += money;
			}
		}
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("orderingProcess/cart.jsp",false);
		
		return forward;
	}

}
