package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.admin.AdminRemainDeleteAction;
import action.admin.AdminRemainDetailAction;
import action.admin.AdminRemainListAction;
import action.admin.AdminRemainUpdateAction;
import action.admin.AdminRemainViewFormAction;
import action.admin.AdminRemainWriteAction;
import action.admin.AdminRemainWriteFormAction;
import vo.ActionForward;


@WebServlet("*.re")
public class AdminRemainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if(command.equals("/adminRemainWrite.re")) {
			action = new AdminRemainWriteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/adminRemainWriteForm.re")) {
			action = new AdminRemainWriteFormAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminRemainList.re")) {
			action = new AdminRemainListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/adminRemainDetail.re")) {
			action = new AdminRemainDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}else if(command.equals("/adminRemainUpdate.re")) {
			action = new AdminRemainUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminRemainDelete.re")) {
			action = new AdminRemainDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminRemainViewForm.re")) {
			action = new AdminRemainViewFormAction();
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
