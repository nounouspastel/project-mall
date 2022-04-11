package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.member.MemberDeleteService;
import vo.ActionForward;

public class MemberDeleteAction implements action.Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = null;
		if(id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("login.jsp");
		}else {
			String deleteid = request.getParameter("id");
			MemberDeleteService memberDeleteService = new MemberDeleteService();
			boolean deleteResult = memberDeleteService.deleteMember(deleteid);
			
			if(!deleteResult) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원탈퇴 실패.');");
				out.println("history.back()");
				out.println("</script>");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원탈퇴 성공.');");
				out.println("location.href='logout.jsp'");
				out.println("</script>");
			}
		}
		return forward;
	}

}
