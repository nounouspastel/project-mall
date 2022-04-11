package svc.basket;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CartDAO;
import vo.Cart;

public class BasketAddService {

	public boolean AddCart(Cart cart) {
		Connection con = null;
		boolean isRegistSuccess = false;
		try {
			con = getConnection();
			CartDAO cartDAO = CartDAO.getInstance();
			cartDAO.setConnection(con);

			int insertCount = cartDAO.cartAdd(cart);

			if (insertCount > 0) {
				commit(con);
				isRegistSuccess = true;
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return isRegistSuccess;
	}
}