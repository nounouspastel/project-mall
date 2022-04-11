package action.order;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.order.OrderFormService;
import vo.ActionForward;
import vo.Cart;
import vo.MemberBean;

public class OrderFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ActionForward forward = new ActionForward();
		if (id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용해 주세요!');");
			out.println("location.href='memberLoginForm.me';");
			out.println("</script>");
		} else {
			OrderFormService orderFormService = new OrderFormService();

			ArrayList<Cart> cartList = (ArrayList<Cart>) orderFormService.getCheckquantityList(id);
			if (cartList != null) {
				for (int i = 0; i < cartList.size(); i++) {
					int totalremain = cartList.get(i).getTotalremain();
					System.out.println(totalremain);
					if (cartList.get(i).getQuantity() > totalremain) {
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>");
						out.println("alert('재고가 부족합니다!');");
						out.println("location.href='history.back();';");
						out.println("</script>");
					} else {
						cartList = (ArrayList<Cart>)orderFormService.getCartList(id);
						int totalMoney = 0;
						int money = 0;
						if (cartList != null) {
							for (int j = 0; j < cartList.size(); j++) {
								money = cartList.get(j).getPrice_out() * cartList.get(j).getQuantity();
								totalMoney += money;
							}
						}
						MemberBean orderId = orderFormService.getOrderId(id);
						request.setAttribute("orderId", orderId);
						request.setAttribute("totalMoney", totalMoney);
						request.setAttribute("cartList", cartList);
					}
				}
			}
			forward = new ActionForward("orderingProcess/checkout.jsp", false);
		}
		return forward;
	}

}
