package svc.member;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberJoinService {

	public boolean joinMember(MemberBean member) {
		boolean joinSuccess = false;
		Connection con = null;
		try {
		con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int insertCount = memberDAO.insertMember(member);
		
		if(insertCount > 0 ) {
			joinSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			close(con);
		}
		return joinSuccess;
	}
	
}
