package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.admin.AdminRemainDAO;
import vo.admin.AdminRemain;

public class AdminRemainListService {

	public ArrayList<AdminRemain> getAdminRemainList(int page, int limit, String rOption, String rValue) {
		ArrayList<AdminRemain> remainList=null;
		Connection con = null;
		try {
			con= getConnection();
			AdminRemainDAO remainDAO=AdminRemainDAO.getInstance();
			remainDAO.setConnection(con);
			remainList=remainDAO.selectAdminRemainList(page,limit,rOption,rValue);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return remainList;
	}


	public int getAdminRemainListCount(String rOption, String rValue) {
		int listCount=0;
		Connection con = null;
		try {
			con=getConnection();
			AdminRemainDAO remainDAO=AdminRemainDAO.getInstance();
			remainDAO.setConnection(con);
			listCount=remainDAO.selectListCount(rOption, rValue);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}
}
