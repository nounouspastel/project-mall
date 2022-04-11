package action.basket;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import dao.CartDAO;
import svc.basket.BasketDeleteService;
import vo.ActionForward;

public class BasketDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pseq = request.getParameter("pseq");
		ActionForward forward = new ActionForward();
		if (id == null) {
			forward.setRedirect(true);
			forward.setPath("./login.me");
			return forward;
		}
		BasketDeleteService basketDeleteService = new BasketDeleteService();

		boolean isDeleteSuccess = basketDeleteService.deleteCart(pseq , id);
		if(! isDeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward=new ActionForward();
			forward.setRedirect(true);
			forward.setPath("basketList.ba");
		}
	

		return forward;
	}
}
