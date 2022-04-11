package action.order;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.order.OrderListService;
import vo.ActionForward;
import vo.Order_Detail;

public class OrderListAction implements Action {

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

			OrderListService orderListService = new OrderListService();
			ArrayList<Order_Detail> orderList = (ArrayList<Order_Detail>) orderListService.getOrderList(id);
//			System.out.println(id);

			request.setAttribute("orderList", orderList);
			forward = new ActionForward("orderingProcess/orders.jsp", false);
		}
		return forward;
	}

}
