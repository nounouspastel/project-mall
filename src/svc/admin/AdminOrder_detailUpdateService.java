package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminOrder_detailDAO;
import vo.admin.AdminOrder_detail;

public class AdminOrder_detailUpdateService {

	public boolean adminOrder_detailUpdate(AdminOrder_detail order_detail, String pseq) {
		boolean isModifySuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			AdminOrder_detailDAO order_detailDAO = AdminOrder_detailDAO.getInstance();
			order_detailDAO.setConnection(con);
			int updateCount = order_detailDAO.updateOrder_detail(order_detail,pseq);
			
			if(updateCount > 0) {
				commit(con);
				isModifySuccess=true;
			}else {
				rollback(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}	
		return isModifySuccess;
	}
}
