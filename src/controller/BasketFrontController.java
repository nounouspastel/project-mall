package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.basket.BasketAddAction;
import action.basket.BasketDeleteAction;
import action.basket.BasketListAction;
//import action.basket.BasketPLAddAction;
import action.basket.BasketQtyUpdateAction;
import vo.ActionForward;

/**
 * Servlet implementation class BasketFrontController
 */
@WebServlet("*.ba")
public class BasketFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BasketFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;

		// 장바구니 추가
		if (command.equals("/basketAdd.ba")) {
			action = new BasketAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// ProductList에서 장바구니 바로 추가하기
//		else if(command.equals("/basketPLAdd.ba")) {
//			action = new BasketPLAddAction();
//			try {
//				forward = action.execute(request, response);
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		// 장바구니 보기
		else if (command.equals("/basketList.ba")) {
			action = new BasketListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		// 삭제
		}else if(command.equals("/basketDelete.ba")) {
			action = new BasketDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		// 수량 수정
		}else if(command.equals("/basketQty.ba")) {
			action = new BasketQtyUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// 3. 포워딩
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);

			}
		}

	}
}
