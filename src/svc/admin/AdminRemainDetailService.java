package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.admin.AdminRemainDAO;
import vo.admin.AdminRemain;

public class AdminRemainDetailService {

	public AdminRemain getAdminRemainView(String order_num) {
		AdminRemain remain = null;
		Connection con = null;
		
		try {
			con = getConnection();
			AdminRemainDAO remainDAO = AdminRemainDAO.getInstance();
			remainDAO.setConnection(con);	
			
			remain = remainDAO.selectRemain(order_num);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)
				close(con);
		}

		return remain;
	}


}
