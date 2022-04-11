package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.order.OrderCancellationAction;
import action.order.OrderCategoryAction;
import action.order.OrderFormAction;
import action.order.OrderListAction;
import action.order.OrderListSearchAction;
import action.order.ParcelAction;
import action.order.PaymentAction;
import action.order.PaymentViewAction;
import vo.ActionForward;

/**
 * Servlet implementation class BasketFrontController
 */
@WebServlet("*.or")
public class OrderFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderFrontController() {
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

		// order form
		if (command.equals("/order.or")) {
			action = new OrderFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// Payment Completed (insert table order_detail)
		else if (command.equals("/payment.or")) {
			action = new PaymentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Payment Completed (orderList)
		else if(command.equals("/orderList.or")) {
			action = new OrderListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// Payment Completed (view) detail view
		else if(command.equals("/paymentView.or")) {
			action = new PaymentViewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// Payment parcel 배송준비,배송중인 상품 조회
		else if(command.equals("/parcel.or")) {
			action = new ParcelAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// orderList search
		else if(command.equals("/search.or")) {
			action = new OrderListSearchAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// delivery 상태 카테고리 기능(미비)
		else if(command.equals("/category.or")) {
			action = new OrderCategoryAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// 주문 취소 기능
		else if(command.equals("/ordercancellation.or")) {
			action = new OrderCancellationAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		// 3. 포워드
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
