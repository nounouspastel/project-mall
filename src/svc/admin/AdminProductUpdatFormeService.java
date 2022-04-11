package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.admin.AdminProductDAO;
import vo.admin.AdminProduct;

public class AdminProductUpdatFormeService {

	public AdminProduct getProductUpdate(String pseq) {
		AdminProduct product = null;
		Connection con = null;
		
		try {
			con = getConnection();
			AdminProductDAO productDAO = AdminProductDAO.getInstance();
			productDAO.setConnection(con);
			
			product = productDAO.selectProduct(pseq);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)
				close(con);
		}
		
		return product;
	}

}