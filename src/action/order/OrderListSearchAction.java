package action.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.order.OrderListSearchService;
import vo.ActionForward;
import vo.Order_Detail;

public class OrderListSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
//		String deli = request.getParameter("deli");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		OrderListSearchService orderListSearchService = new OrderListSearchService();
		ArrayList<Order_Detail> orderList = orderListSearchService.getOrderListSearchList(id,startdate,enddate);
		request.setAttribute("orderList", orderList);
		request.setAttribute("startdate", startdate);
		request.setAttribute("enddate", enddate);
		
		ActionForward forward = new ActionForward("orderingProcess/orders.jsp", false);
		return forward;
	}

}
