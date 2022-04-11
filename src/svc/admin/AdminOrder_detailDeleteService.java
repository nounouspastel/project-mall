package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminOrder_detailDAO;

public class AdminOrder_detailDeleteService {

	public boolean removeAdminOrder_detail(String odseq, String pseq) {
		boolean isDeleteSuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			AdminOrder_detailDAO order_detailDAO = AdminOrder_detailDAO.getInstance();
			order_detailDAO.setConnection(con);
			int deletCount = order_detailDAO.deleteOrder_detail(odseq,pseq);
			
			if(deletCount > 0) {
				commit(con);
				isDeleteSuccess=true;
			}else {
				rollback(con);	
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isDeleteSuccess;
	}
}
