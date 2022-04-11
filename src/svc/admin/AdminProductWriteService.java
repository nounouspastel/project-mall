package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminProductDAO;
import vo.admin.AdminProduct;

public class AdminProductWriteService {

	public boolean writeProduct(AdminProduct product) {
		boolean isRegistSuccess = false;	
		Connection con = null;
		try {
			con = getConnection();
			AdminProductDAO productDAO = AdminProductDAO.getInstance();
			productDAO.setConnection(con);			
			int insertCount = productDAO.insertProduct(product);
			
			if(insertCount>0){
				commit(con);
				isRegistSuccess=true;
			}else{
				rollback(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isRegistSuccess;
	}
}
