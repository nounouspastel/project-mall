package action.order;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import action.Action;
import svc.order.PaymentService;
import vo.ActionForward;
import vo.Cart;
import vo.Order_Detail;

public class PaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ActionForward forward = new ActionForward();
		if (id == null) {
			forward.setRedirect(true);
			forward.setPath("memberLoginForm.me");
			return forward;
		}
		PaymentService paymentService = new PaymentService();
		
		Order_Detail orderDetail = new Order_Detail();
					 orderDetail.setOdseq(request.getParameter("odseq"));
					 orderDetail.setId(request.getParameter("id"));
					 orderDetail.setPseq(request.getParameter("pseq"));
					 orderDetail.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			ArrayList<Cart> cartList = (ArrayList<Cart>)paymentService.getCartList(id);
			request.setAttribute("cartList", cartList);
//			System.out.println(cartList);
			String odseq = orderDetail.getOdseq();
			boolean paymentSuccess = paymentService.payment(orderDetail, cartList);
			boolean isDeleteSuccess = paymentService.deleteCartList(id);
			if(paymentSuccess) {
				String today = request.getParameter("date");

				ArrayList<Order_Detail> ordertodayview = paymentService.getTodayView(id , today);
				request.setAttribute("ordertodayview", ordertodayview);
				
				request.setAttribute("odseq", odseq);
				isDeleteSuccess = true;
				request.setAttribute("orderDetail", orderDetail);
				forward = new ActionForward("orderingProcess/payment.jsp",false);
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('결제실패');");
				out.println("history.back();");
				out.println("</script>");
			}
		
		return forward;
	}

}
