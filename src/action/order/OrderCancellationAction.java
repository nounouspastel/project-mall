package action.order;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.order.OrderCancellationService;
import vo.ActionForward;

public class OrderCancellationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pseq = request.getParameter("pseq");
		String odseq = request.getParameter("odseq");
		ActionForward forward = new ActionForward();
		System.out.println(id);
		System.out.println(odseq);
		System.out.println(pseq);
		OrderCancellationService orderCancellationService = new OrderCancellationService();
		
		boolean isCancellSuccess = orderCancellationService.orderCancell(pseq, id, odseq);
		
		if(! isCancellSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("paymentView.or?odseq="+odseq);
		}
		return forward;
	}

}
