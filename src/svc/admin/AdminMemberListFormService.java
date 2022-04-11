package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.admin.AdminMemberDAO;
import vo.admin.AdminMember;

public class AdminMemberListFormService {

	public ArrayList<AdminMember> getAdminMemberList(int page, int limit, String mOption, String mValue) {
		ArrayList<AdminMember> memberList=null;
		Connection con = null;
		
		try {
			con= getConnection();
			AdminMemberDAO memberDAO=AdminMemberDAO.getInstance();
			memberDAO.setConnection(con);
			memberList=memberDAO.selectAdminMemberList(page,limit,mOption,mValue);			
		}catch (Exception e) {
			e.printStackTrace();		
		}finally {
			close(con);
		}
		return memberList;
	}

	public int getAdminMemberListCount(String mOption, String mValue) {
		int listCount=0;
		Connection con = null;
		try {
			con=getConnection();
			AdminMemberDAO memberDAO=AdminMemberDAO.getInstance();
			memberDAO.setConnection(con);
			listCount=memberDAO.selectListCount(mOption, mValue);			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}

}