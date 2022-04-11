package dao.admin;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.admin.AdminMember;

public class AdminMemberDAO {

	Connection con;
	private static AdminMemberDAO memberDAO;
	
	private AdminMemberDAO( ) {
		
	}
	
	public static AdminMemberDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new AdminMemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;		
	}


	public ArrayList<AdminMember> selectAdminMemberList(int page, int limit, String mOption, String mValue) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String member_list_sql="select * from member where ";
		if (mOption.equals("id")){
			member_list_sql += "id like ? ";
		}else if(mOption.equals("name")) {
			member_list_sql += "name like ? ";
		}else if(mOption.equals("address1")) {
			member_list_sql += "address1 like ? ";
		}else if(mOption.equals("address2")) {
			member_list_sql += "address2 like ? ";
		}else if(mOption.equals("phone")) {
			member_list_sql += "phone like ? ";
		}else if(mOption.equals("vip")) {
			member_list_sql += "vip like ? ";
		}else if(mOption.equals("indate")) {
			member_list_sql += "indate like ? ";
		}
		
		member_list_sql += " order by id asc limit ?,?";
		ArrayList<AdminMember> memberList=new ArrayList<AdminMember>();
		AdminMember member=null;
		int startrow=(page-1)*limit;//읽기 시작할 row번호

		try {

			pstmt=con.prepareStatement(member_list_sql);
			pstmt.setString(1, "%"+mValue+"%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				member=new AdminMember();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_num(rs.getString("zip_num"));
				member.setAddress1(rs.getString("address1"));
				member.setAddress2(rs.getString("address2"));
				member.setPhone(rs.getString("phone"));
				member.setVip(rs.getString("vip"));
				member.setIndate(rs.getDate("indate"));
				memberList.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberList;
	}

	public int selectListCount(String mOption, String mValue) {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql= "select count(*) from member where ";
		if (mOption.equals("id")){
			sql += "id like ?";
		}else if (mOption.equals("name")) {
			sql += "name like ?";
		}else if (mOption.equals("address1")) {
			sql += "address1 like ?";
		}else if (mOption.equals("address2")) {
			sql += "address2 like ?";
		}else if (mOption.equals("phone")) {
			sql += "phone like ?";
		}else if (mOption.equals("vip")) {
			sql += "vip like ?";
		}else {
			sql += "indate like ?";
		}
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+mValue+"%");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				listCount=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

}
