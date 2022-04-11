package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.admin.AdminLoginAction;
import action.admin.AdminProductDeleteAction;
import action.admin.AdminProductDetailAction;
import action.admin.AdminProductDetailFormAction;
import action.admin.AdminProductListAction;
import action.admin.AdminProductUpdatFormeAction;
import action.admin.AdminProductUpdateAction;
import action.admin.AdminProductUpdateMainFormAction;
import action.admin.AdminProductWriteAction;
import action.admin.AdminProductWriteFormAction;
import vo.ActionForward;

@WebServlet("*.ad")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if(command.equals("/adminLoginAction.ad")) {
			action = new AdminLoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/adminProductWrite.ad")) {
			action = new AdminProductWriteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminProductList.ad")) {
			action = new AdminProductListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}		
		}else if(command.equals("/adminProductDetail.ad")) {
			action = new AdminProductDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/adminProductDelete.ad")) {
			action = new AdminProductDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}		
		}else if(command.equals("/adminProductUpdate.ad")) {
			action = new AdminProductUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}		
		}else if(command.equals("/adminProductUpdateForm.ad")) {
			action = new AdminProductUpdatFormeAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/adminProductWriteForm.ad")) {
			action = new AdminProductWriteFormAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}					
		}else if(command.equals("/adminProductDetailForm.ad")) {
			action = new AdminProductDetailFormAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}					
		}else if(command.equals("/adminProductUpdateMainForm.ad")) {
			action = new AdminProductUpdateMainFormAction();
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}

}
