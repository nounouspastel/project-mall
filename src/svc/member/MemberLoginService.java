package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberLoginService {

	public boolean login(MemberBean member) {		
		boolean loginResult = false;
		Connection con = null;
		try {
		con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		String loginId = memberDAO.selectLoginId(member);
		if(loginId != null) {
			loginResult = true;
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			close(con);
		}
		return loginResult;
	}
}
