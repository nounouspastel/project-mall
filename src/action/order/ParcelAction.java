package action.order;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.order.ParcelService;
import vo.ActionForward;
import vo.Order_Detail;

public class ParcelAction implements Action {

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
			ParcelService parcelService = new ParcelService();

			ArrayList<Order_Detail> orderPacel = parcelService.getParcelView(id);
			request.setAttribute("orderPacel", orderPacel);

			forward = new ActionForward("orderingProcess/parcelView.jsp", false);
		}
		return forward;
	}

}
