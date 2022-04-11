package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.admin.AdminOrder_detailDAO;
import vo.admin.AdminOrder_detail;

public class AdminOrder_detailviewService {

	public AdminOrder_detail getOrder_detailview(String odseq, String pseq) {
		AdminOrder_detail order_detail = null;
		Connection con = null;
		
		try {
			con = getConnection();
			AdminOrder_detailDAO order_detailDAO = AdminOrder_detailDAO.getInstance();
			order_detailDAO.setConnection(con);	
			
			order_detail = order_detailDAO.selectOrder_detail(odseq, pseq);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)
				close(con);
		}

		return order_detail;
	}


}