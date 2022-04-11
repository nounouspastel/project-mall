package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberViewService {

	public MemberBean getMember(String viewId) {
		MemberBean member = null;
		Connection con = null;
		try {
		con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		member = memberDAO.selectMember(viewId);
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)
				close(con);
		}
		return member;
	}
}
