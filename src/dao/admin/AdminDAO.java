package dao.admin;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.admin.Admin;

public class AdminDAO {
	
	public static AdminDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private AdminDAO() {}

	public static AdminDAO getInstance() {
		if(instance == null) {
			instance = new AdminDAO();
		}
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(Admin admin) {
		String loginId = null;
		String sql="select admin_id from admin where admin_id= ? and admin_pwd= ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, admin.getAdmin_id());
			pstmt.setString(2, admin.getAdmin_pwd());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("admin_id");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}

}
