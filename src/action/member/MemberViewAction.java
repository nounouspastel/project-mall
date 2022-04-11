package action.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.member.MemberViewService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberViewAction implements action.Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = null;
		
		if(id==null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("login.jsp");
		}else {
			forward = new ActionForward();
			MemberViewService memberViewService = new MemberViewService();
			String viewId = request.getParameter("id");
			MemberBean member = memberViewService.getMember(viewId);
			request.setAttribute("member", member);
			forward = new ActionForward("member_info.jsp",false);;
		}
		return forward;
	}

}
