package action.admin;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminRemainWriteService;
import vo.ActionForward;
import vo.admin.AdminRemain;

public class AdminRemainWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminRemainWriteService AdminRemainWriteService = new AdminRemainWriteService();
	

		AdminRemain remain = new AdminRemain();	
	 	    remain.setOrder_num(request.getParameter("order_num"));
			remain.setPseq(request.getParameter("pseq"));
			remain.setDeli(request.getParameter("deli"));
			remain.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			remain.setRe_date(null);
			
		boolean isRegistSuccess = AdminRemainWriteService.adminRemainWrite(remain);  
	
		ActionForward forward = null;		
		if(isRegistSuccess){
			forward = new ActionForward("adminRemainList.re", true);
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