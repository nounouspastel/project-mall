package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.MembertUpdateService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MembertUpdateService memberUpdateService = new MembertUpdateService();

		MemberBean member = new MemberBean();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setZip_num(request.getParameter("zip_num"));
		member.setAddress1(request.getParameter("address1"));
		member.setAddress2(request.getParameter("address2"));
		member.setPhone(request.getParameter("phone"));

		boolean memberUpdate = memberUpdateService.updateMember(member);
		ActionForward forward = null;

		if (!memberUpdate) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패');");
			out.println("history.back()");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정완료');");
			out.println("location.href='index.jsp'");
			out.println("</script>");
		}

		return forward;
	}

}