package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminProductDAO;
import vo.admin.AdminProduct;

public class AdminProductUpdateService {

	public boolean adminModifyProduct(AdminProduct product) {
		boolean isModifySuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			AdminProductDAO productDAO = AdminProductDAO.getInstance();
			productDAO.setConnection(con);
			int updateCount = productDAO.updateProduct(product);
			
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