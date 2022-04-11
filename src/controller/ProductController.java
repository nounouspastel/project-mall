package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.Product.MainProductListAction;
import action.Product.ProductDetailAction;
import action.Product.ProductListAction;
import vo.ActionForward;

@WebServlet("*.pd")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if(command.equals("/mainProductList.pd")) {
			action = new MainProductListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/productDetail.pd")) {
			action = new ProductDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}						
		}else if(command.equals("/productList.pd")) {
			action = new ProductListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}										
		}if(forward != null) {
			if(forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
		}
	}
}		
		
		
		
//		if(command.equals("/memberIndex.me")) {
//			request.setAttribute("pagefile", "/member/member_Index.jsp");
//			forward = new ActionForward();
//			forward.setPath("index.jsp");
//		}else if(command.equals("/memberLogoutAction.me")){
//			request.setAttribute("pagefile", "/member/logoutForm.jsp");
//			forward = new ActionForward();
//			forward.setPath("index.jsp");
//		}else if(command.equals("/memberLogin.me")) {
//			request.setAttribute("pagefile", "/member/loginForm.jsp");
//			forward = new ActionForward();
//			forward.setPath("index.jsp");
//		}else if(command.equals("/memberJoin.me")) {
//			request.setAttribute("pagefile", "/member/joinForm.jsp");
//			forward = new ActionForward();
//			forward.setPath("index.jsp");
//		}else if(command.equals("/memberLoginAction.me")) {
//			action = new MemberLoginAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}else if(command.equals("/memberJoinAction.me")) {
//			action = new MemberJoinAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}

//		}else if(command.equals("/memberViewAction.me")) {
//			action = new MemberViewAction();
//			try {
//				forward = action.execute(request, response);
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}else if(command.equals("/memberDeleteAction.me")) {
//			action = new MemberDeleteAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}

}
