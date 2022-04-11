package svc.basket;

import java.sql.Connection;

import dao.CartDAO;

import static db.JdbcUtil.*;

public class BasketQtyUpdateService {

	public boolean QtyModify(int quantity, String pseq) {
//		System.out.println(quantity);
		boolean isQtyUpdateSuccess = false;
		Connection con = null;
		try {
		con = getConnection();
		CartDAO cartDAO = CartDAO.getInstance();
		cartDAO.setConnection(con);
		int updateCount = cartDAO.updateQty(quantity, pseq);
		
		if(updateCount > 0) {
			commit(con);
			isQtyUpdateSuccess = true;
		}else {
			rollback(con);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isQtyUpdateSuccess;
	}

}
