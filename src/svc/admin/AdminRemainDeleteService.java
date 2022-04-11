package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminRemainDAO;

public class AdminRemainDeleteService {

	public boolean removeAdminRemain(String order_num) {
		boolean isDeleteSuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			AdminRemainDAO remainDAO = AdminRemainDAO.getInstance();
			remainDAO.setConnection(con);
			int deletCount = remainDAO.deleteRemain(order_num);
			
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