package svc.order;

import static db.JdbcUtil.*;

import vo.Cart;
import vo.Order_Detail;
import java.sql.Connection;
import java.util.ArrayList;

import dao.CartDAO;
import dao.OrderDAO;

public class PaymentService {

	public boolean payment(Order_Detail orderDetail, ArrayList<Cart> cartList) {
		Connection con = null;
		boolean paymentSuccess = false;
		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			int insertCount = orderDAO.payment(orderDetail, cartList);

			if (insertCount > 0) {
				commit(con);
				paymentSuccess = true;
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return paymentSuccess;
	}

	public boolean deleteCartList(String id) {
		boolean isDeleteSuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			CartDAO cartDAO = CartDAO.getInstance();
			cartDAO.setConnection(con);
			int deleteCount = cartDAO.deleteCartId(id);

			if (deleteCount > 0) {
				commit(con);
				isDeleteSuccess = true;
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return isDeleteSuccess;
	}

	public ArrayList<Cart> getCartList(String id) {
		Connection con = null;
		ArrayList<Cart> cartList = null;
		try {
			con = getConnection();
			CartDAO cartDAO = CartDAO.getInstance();
			cartDAO.setConnection(con);
			cartList = cartDAO.selectCartList(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return cartList;
	}
	public ArrayList<Order_Detail> getTodayView(String id, String today) {
		Connection con = null;
		ArrayList<Order_Detail> ordertoday = null;

		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			ordertoday = orderDAO.selectTodayList(id, today);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return ordertoday;
	}
}
