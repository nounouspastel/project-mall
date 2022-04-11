package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.member.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction implements action.Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean loginResult = memberLoginService.login(member);
		ActionForward forward = null;
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("id", member.getId());
			request.setAttribute("pagefile", "index.jsp");
			forward = new ActionForward("index.jsp", false);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("location.href='login.jsp';");
			out.println("</script>");
		}
		return forward;
	}

}
