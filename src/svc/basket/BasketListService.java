package svc.basket;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.CartDAO;
import vo.Cart;

public class BasketListService {

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

}
