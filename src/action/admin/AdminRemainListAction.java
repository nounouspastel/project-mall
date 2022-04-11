package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminRemainListService;
import vo.ActionForward;
import vo.admin.PageInfo;
import vo.admin.AdminRemain;

public class AdminRemainListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String rOption = "order_num";
		String rValue = null;
		if(request.getParameter("rOption") != null)
			rOption = request.getParameter("rOption");
		if(request.getParameter("rValue") != null)
			rValue = request.getParameter("rValue");
		else rValue = "";
		
		
		ArrayList<AdminRemain> remainList= new ArrayList<AdminRemain>();
		int page=1;
		int limit=10; //페이지에 보여줄 목록수
		int limitPage=10; //페이지 수
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		AdminRemainListService adminRemainListService=new AdminRemainListService();
		int listCount=adminRemainListService.getAdminRemainListCount(rOption, rValue);
		
		remainList=adminRemainListService.getAdminRemainList(page,limit,rOption, rValue);
		
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
		request.setAttribute("rOption", rOption);
		request.setAttribute("rValue", rValue);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("remainList", remainList);
		ActionForward forward = new ActionForward("remain/remainList.jsp", false);
	
		return forward;
	}
}

