package svc.order;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import vo.Order_Detail;

public class OrderListSearchService {

	public ArrayList<Order_Detail> getOrderListSearchList(String id,String startdate, String enddate) {
		Connection con = null;
		ArrayList<Order_Detail> orderList = null;
		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			orderList = orderDAO.selectDateSearchList(id,startdate, enddate);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return orderList;
	}

}
