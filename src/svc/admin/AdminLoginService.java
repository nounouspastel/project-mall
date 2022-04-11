package svc.admin;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.admin.AdminDAO;
import vo.admin.Admin;

public class AdminLoginService {

	public boolean login(Admin admin) {
		boolean loginResult = false;
		Connection con = null;
		
		try {
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			
			String loginId = adminDAO.selectLoginId(admin);
			if(loginId != null) {
				loginResult = true;	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}

		return loginResult;
	}
	
}
