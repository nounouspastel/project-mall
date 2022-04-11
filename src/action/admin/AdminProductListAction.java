package action.admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.admin.AdminProductListService;
import vo.ActionForward;
import vo.admin.PageInfo;
import vo.admin.AdminProduct;

public class AdminProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pOption = "pseq";
		String pValue = null;
		if(request.getParameter("pOption") != null)
			pOption = request.getParameter("pOption");
		if(request.getParameter("pValue") != null)
			pValue = request.getParameter("pValue");
		else pValue = "";
		
		
		ArrayList<AdminProduct> productList= new ArrayList<AdminProduct>();
		int page=1;
		int limit=10; //페이지에 보여줄 목록수
		int limitPage=10; //페이지 수
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		AdminProductListService adminProductListService=new AdminProductListService();
		int listCount=adminProductListService.getproductListCount(pOption, pValue);
		
		productList=adminProductListService.getproductList(page,limit,pOption, pValue);
		
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
		request.setAttribute("pOption", pOption);
		request.setAttribute("pValue", pValue);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("productList", productList);
		ActionForward forward = new ActionForward("product/productList.jsp", false);
	
		return forward;
	}
}