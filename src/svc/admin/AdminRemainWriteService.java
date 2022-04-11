package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.admin.AdminRemainDAO;
import vo.admin.AdminRemain;

public class AdminRemainWriteService {

	public boolean adminRemainWrite(AdminRemain remain) {
		boolean isRegistSuccess = false;	
		Connection con = null;
		try {
			con = getConnection();	
			AdminRemainDAO remainDAO = AdminRemainDAO.getInstance();
			remainDAO.setConnection(con);
			int insertCount = remainDAO.insertRemain(remain);
			
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

