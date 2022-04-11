package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MembertUpdateService {

	public boolean updateMember(MemberBean member) {
		boolean isModifySuccess = false;
		Connection con = null;
		try {
		con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		int updateCount = memberDAO.updateMember(member);

		if (updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			close(con);
		}
		return isModifySuccess;
	}

}
