package action.order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.order.PaymentViewService;
import vo.ActionForward;
import vo.MemberBean;
import vo.Order_Detail;

public class PaymentViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		PaymentViewService paymentViewService = new PaymentViewService();
		String odseq = request.getParameter("odseq");
		System.out.println(odseq);
		//주문자 정보 가져오게 하는 것
		MemberBean orderId = paymentViewService.getOrderId(id);
		request.setAttribute("orderId", orderId);
		
		//order_detail 주문 목록 가져오게 하는것
		ArrayList<Order_Detail> orderview = paymentViewService.getPaymentView(id , odseq);
		
		int sumPrice = 0;
		if(orderview != null) {
			for(int i = 0; i < orderview.size(); i++) {
				sumPrice += orderview.get(i).getTotalprice();
			}
		}
		request.setAttribute("sumPrice", sumPrice);
		request.setAttribute("orderview", orderview);
		
		ActionForward forward = new ActionForward("orderingProcess/order_detail_view.jsp",false);
		return forward;
	}

}
