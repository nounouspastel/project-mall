package action.basket;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.basket.BasketAddService;
import vo.ActionForward;
import vo.Cart;

public class BasketAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BasketAddService basketAddService = new BasketAddService();
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
			Cart ct = new Cart();
			ct.setOverlap(request.getParameter("overlap"));
			ct.setId(request.getParameter("id"));
			ct.setPseq(request.getParameter("pseq"));
			ct.setName(request.getParameter("name"));
			ct.setKind(request.getParameter("kind"));
			ct.setTotalremain(Integer.parseInt(request.getParameter("totalremain")));
			ct.setPrice_out(Integer.parseInt(request.getParameter("price_out")));
			ct.setQuantity(Integer.parseInt(request.getParameter("quantity")));

			boolean isRegistSuccess = basketAddService.AddCart(ct);

			if (isRegistSuccess) {
				request.setAttribute("cartList", ct);
				forward = new ActionForward("./basketList.ba", true);
			} else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패');");
				out.println("history.back();");
				out.println("</script>");
			}
		}
		return forward;
	}
}