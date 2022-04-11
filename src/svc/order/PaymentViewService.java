package svc.order;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.MemberDAO;
import dao.OrderDAO;
import vo.MemberBean;
import vo.Order_Detail;

public class PaymentViewService {

	public ArrayList<Order_Detail> getPaymentView(String id, String odseq) {
		Connection con = null;
		ArrayList<Order_Detail> orderview = null;

		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			orderview = orderDAO.selectOrderDetail(id, odseq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return orderview;
	}

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

}
