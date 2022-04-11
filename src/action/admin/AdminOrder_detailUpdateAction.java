package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminOrder_detailUpdateService;
import vo.ActionForward;
import vo.admin.AdminOrder_detail;

public class AdminOrder_detailUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminOrder_detailUpdateService adminOrder_detailUpdateService = new AdminOrder_detailUpdateService();
		

		AdminOrder_detail order_detail = new AdminOrder_detail();
		order_detail.setOdseq(request.getParameter("odseq"));
		order_detail.setDeli(request.getParameter("deli"));
		String pseq = request.getParameter("pseq");
		
			
		boolean isRegistSuccess = adminOrder_detailUpdateService.adminOrder_detailUpdate(order_detail, pseq);  
	
		ActionForward forward = null;		
		if(isRegistSuccess){
			forward = new ActionForward("adminOrder_detailList.od", true);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패:상품코드 중복 및 누락된 부분 확인바랍니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
