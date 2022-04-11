package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.admin.AdminOrder_detailDAO;
import vo.admin.AdminOrder_detail;

public class AdminOrder_detailListService {

	public int getorder_detailListCount(String odOption, String odValue) {
		int listCount=0;
		Connection con = null;
		try {
			con=getConnection();
			AdminOrder_detailDAO order_detailDAO=AdminOrder_detailDAO.getInstance();
			order_detailDAO.setConnection(con);
			listCount=order_detailDAO.selectOrder_detailListCount(odOption, odValue);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}

	public ArrayList<AdminOrder_detail> getorder_detailList(int page, int limit, String odOption, String odValue) {
		ArrayList<AdminOrder_detail> order_detailList=null;
		Connection con = null;
		try {
			con= getConnection();
			AdminOrder_detailDAO order_detailDAO=AdminOrder_detailDAO.getInstance();
			order_detailDAO.setConnection(con);
			order_detailList=order_detailDAO.selectAdminOrder_detailList(page,limit,odOption,odValue);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return order_detailList;
	}

}
