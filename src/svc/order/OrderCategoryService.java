package svc.order;

import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;

import static db.JdbcUtil.*;
import vo.Order_Detail;

public class OrderCategoryService {

	public ArrayList<Order_Detail> getCategoryList(String id, String deli) {
		Connection con = null;
		ArrayList<Order_Detail> orderList = null;
		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			orderList = orderDAO.selectOrderCategoryList(id,deli);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return orderList;
	}

}
