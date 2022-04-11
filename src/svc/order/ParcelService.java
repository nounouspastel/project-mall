package svc.order;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import vo.Order_Detail;

public class ParcelService {

	public ArrayList<Order_Detail> getParcelView(String id) {
		Connection con = null;
		ArrayList<Order_Detail> orderDelivery = null;
		
		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			orderDelivery = orderDAO.selectDelivery(id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return orderDelivery;
	}

}
