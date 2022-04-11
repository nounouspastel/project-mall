package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminOrder_detailListService;
import vo.ActionForward;
import vo.admin.AdminOrder_detail;
import vo.admin.PageInfo;

public class AdminOrder_detailListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String odOption = "pseq";
		String odValue = null;
		if(request.getParameter("odOption") != null)
			odOption = request.getParameter("odOption");
		if(request.getParameter("odValue") != null)
			odValue = request.getParameter("odValue");
		else odValue = "";
		
		
		ArrayList<AdminOrder_detail> order_detailList= new ArrayList<AdminOrder_detail>();
		int page=1;
		int limit=10; //페이지에 보여줄 목록수
		int limitPage=10; //페이지 수
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		AdminOrder_detailListService adminOrder_detailListService=new AdminOrder_detailListService();
		int listCount=adminOrder_detailListService.getorder_detailListCount(odOption, odValue);
		
		order_detailList=adminOrder_detailListService.getorder_detailList(page,limit,odOption, odValue);
		
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
		request.setAttribute("odOption", odOption);
		request.setAttribute("odValue", odValue);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("order_detailList", order_detailList);
		ActionForward forward = new ActionForward("order/orderList.jsp", false);
	
		return forward;
	}
}
