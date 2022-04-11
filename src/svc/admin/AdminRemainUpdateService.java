package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminRemainDAO;
import vo.admin.AdminRemain;

public class AdminRemainUpdateService {

	public boolean adminRemainUpdate(AdminRemain remain) {
		boolean isModifySuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			AdminRemainDAO remainDAO = AdminRemainDAO.getInstance();
			remainDAO.setConnection(con);
			int updateCount = remainDAO.updateRemain(remain);
			
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