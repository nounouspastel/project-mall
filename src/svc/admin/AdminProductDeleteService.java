package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminProductDAO;

public class AdminProductDeleteService {

	public boolean removeAdminProduct(String pseq) {
		boolean isDeleteSuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			AdminProductDAO productDAO = AdminProductDAO.getInstance();
			productDAO.setConnection(con);
			int deletCount = productDAO.deleteProduct(pseq);
			
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
