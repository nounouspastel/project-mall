package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import vo.MemberBean;

import static db.JdbcUtil.*;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(MemberBean member) {
		String loginId = null;
		String sql = "select id from member where id = ? and pwd = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginId = rs.getString("id");
			}
		} catch (Exception e) {
			System.out.println(" 에러 : " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}

	public int insertMember(MemberBean member) {
		String sql = "insert into member(id, pwd, name, email, zip_num, address1, address2, phone) values(?,?,?,?,?,?,?,?)";
		int insertCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getZip_num());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setString(8, member.getPhone());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("joinMember 에러 : " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<MemberBean> selectMemberList() {
		String sql = "select * from member";
		ArrayList<MemberBean> List = new ArrayList<MemberBean>();
		MemberBean mb = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					mb = new MemberBean();
					mb.setId(rs.getString("id"));
					mb.setPwd(rs.getString("pwd"));
					mb.setName(rs.getString("name"));
					mb.setEmail(rs.getString("email"));
					mb.setZip_num(rs.getString("zip_num"));
					mb.setAddress1(rs.getString("address1"));
					mb.setAddress2(rs.getString("address2"));
					mb.setPhone(rs.getString("phone"));
					List.add(mb);
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("getDetailMember 에러: " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return List;
	}

	public MemberBean selectMember(String id) {
		String sql = "select * from member where id=?";
		MemberBean mb = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb = new MemberBean();
				mb.setId(rs.getString("id"));
				mb.setPwd(rs.getString("pwd"));
				mb.setName(rs.getString("name"));
				mb.setEmail(rs.getString("email"));
				mb.setZip_num(rs.getString("zip_num"));
				mb.setAddress1(rs.getString("address1"));
				mb.setAddress2(rs.getString("address2"));
				mb.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			System.out.println("getDetailMember 에러 : " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mb;
	}

	public int deleteMember(String id) {
		String sql = "delete from member where id=?";
		int deleteCount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("deleteMeber 에러 : " + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public int updateMember(MemberBean member) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update member set id=?,pwd=?,name=?,email=?,zip_num=?,address1=?,address2=?,phone=? where id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getZip_num());
			pstmt.setString(6, member.getAddress1());
			pstmt.setString(7, member.getAddress2());
			pstmt.setString(8, member.getPhone());
			pstmt.setString(9, member.getId());
			updateCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return updateCount;
	}
	public MemberBean selectOrderId(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean mb = null;
		try {
			pstmt = con.prepareStatement("select name,id,phone,email,zip_num,address1,address2 from member where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb = new MemberBean();
				mb.setName(rs.getString("name"));
				mb.setId(rs.getString("id"));
				mb.setPhone(rs.getString("phone"));
				mb.setEmail(rs.getString("email"));
				mb.setZip_num(rs.getString("zip_num"));
				mb.setAddress1(rs.getString("address1"));
				mb.setAddress2(rs.getString("address2"));
			}
		}catch (Exception e) {
			System.out.println("selectOrderId 에러" + e);
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		return mb;
	}
	public MemberBean selectCartId(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean member = null;
		
		try {
			pstmt = con.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				member = new MemberBean(
						rs.getString("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return member;
	}

}
