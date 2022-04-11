package svc.order;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.CartDAO;
import dao.MemberDAO;
import vo.Cart;
import vo.MemberBean;

public class OrderFormService {

	public MemberBean getOrderId(String id) {
		Connection con = null;
		MemberBean orderId = null;
		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			orderId = memberDAO.selectOrderId(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return orderId;
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

	public ArrayList<Cart> getCheckquantityList(String id) {
		Connection con = null;
		ArrayList<Cart> cartList = null;
		try {
			con = getConnection();
			CartDAO cartDAO = CartDAO.getInstance();
			cartDAO.setConnection(con);
			cartList = cartDAO.selectQuantityList(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return cartList;
	}

}
