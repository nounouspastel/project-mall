package svc.order;

import java.sql.Connection;

import dao.OrderDAO;

import static db.JdbcUtil.*;

public class OrderCancellationService {

	public boolean orderCancell(String pseq, String id, String odseq) {
		Connection con = null;
		boolean isCancellSuccess = false;
		
		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			int cancellCount = orderDAO.orderCancell(pseq, id, odseq);
			
			if(cancellCount > 0) {
				commit(con);
				isCancellSuccess = true;
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isCancellSuccess;
	}

}
