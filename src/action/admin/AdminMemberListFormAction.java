package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminMemberListFormService;
import vo.ActionForward;
import vo.admin.AdminMember;
import vo.admin.PageInfo;

public class AdminMemberListFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mOption = "id";
		String mValue = null;
		if(request.getParameter("mOption") != null)
			mOption = request.getParameter("mOption");
		if(request.getParameter("mValue") != null)
			mValue = request.getParameter("mValue");
		else mValue = "";
		
		
		ArrayList<AdminMember> memberList= new ArrayList<AdminMember>();
		int page=1;
		int limit=10; //페이지에 보여줄 목록수
		int limitPage=10; //페이지 수
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		AdminMemberListFormService adminMemberListFormService=new AdminMemberListFormService();
		int listCount=adminMemberListFormService.getAdminMemberListCount(mOption, mValue);
		
		memberList=adminMemberListFormService.getAdminMemberList(page,limit,mOption, mValue);
		
		int maxPage=(int)((double)listCount/limit+0.95);
		
		int startPage=(((int)((double)page/limitPage+0.9))-1)*limitPage+1;
		
		int endPage=startPage+limitPage-1;
		
		if(endPage>maxPage)endPage =maxPage;
		
		PageInfo pageInfo=new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("mOption", mOption);
		request.setAttribute("mValue", mValue);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("memberList", memberList);
		ActionForward forward = new ActionForward("member/adminMemberList.jsp", false);
	
		return forward;
	}
}	
	

