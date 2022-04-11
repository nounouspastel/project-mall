package svc.basket;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.CartDAO;
import vo.Cart;

public class BasketDeleteService {

	public boolean deleteCart(String pseq, String id) {
		boolean isDeleteSuccess = false;
		Connection con = null;

		try {
			con = getConnection();
			CartDAO cartDAO = CartDAO.getInstance();
			cartDAO.setConnection(con);
			int deletCount = cartDAO.deleteCart(pseq, id);

			if (deletCount > 0) {
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
}