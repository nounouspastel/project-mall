package dao.admin;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;

import vo.admin.AdminRemain;

public class AdminRemainDAO {
	
	Connection con;
	private static AdminRemainDAO remainDAO;
	
	private AdminRemainDAO() {
		
	}

	public static AdminRemainDAO getInstance() {
		if(remainDAO == null) {
			remainDAO = new AdminRemainDAO();
		}
		return remainDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;		
	}

	public int insertRemain(AdminRemain remain) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		try {
			sql = "insert into remain(order_num, pseq, deli, quantity) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, remain.getOrder_num());
			pstmt.setString(2, remain.getPseq());
			pstmt.setString(3, remain.getDeli());
			pstmt.setInt(4, remain.getQuantity());
	
			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}

	public ArrayList<AdminRemain> selectAdminRemainList(int page, int limit, String rOption, String rValue) {

		PreparedStatement pstmt=null;
		ResultSet rs=null;
//		String remain_list_sql="select * from remain left join productview on remain.pseq = productview.pseq1 union all select * from order_detail left join productview on order_detail.pseq = productview.pseq1 where ";		
//		String remain_list_sql="select * from remain union all select * from order_detail where ";
//		String remain_list_sql="select * from remain left join productview on remain.pseq = productview.pseq1 union all select odseq as order_num, id, pseq, quantity, deli, indate as re_date, pseq1, name, kind from order_detail left join productview on order_detail.pseq = productview.pseq1 where ";
		String remain_list_sql="select * from totalremainview where ";
		
//		String remain_list_sql="select * from remain left join productview on remain.pseq = productview.pseq1 where ";
		if (rOption.equals("order_num")){
			remain_list_sql += "order_num like ? ";
		}else if(rOption.equals("pseq")) {
			remain_list_sql += "pseq like ? ";
		}else if(rOption.equals("name")) {
			remain_list_sql += "name like ? ";
		}else if(rOption.equals("kind")) {
			remain_list_sql += "kind like ? ";
		}
		remain_list_sql += " order by order_num asc limit ?,?";
		ArrayList<AdminRemain> remainList=new ArrayList<AdminRemain>();
		AdminRemain remain=null;
		int startrow=(page-1)*limit;//읽기 시작할 row번호

		try {

			pstmt=con.prepareStatement(remain_list_sql);
			pstmt.setString(1, "%"+rValue+"%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				remain=new AdminRemain();
				remain.setOrder_num(rs.getString("order_num"));
				remain.setPseq(rs.getString("pseq"));
				remain.setName(rs.getString("name"));
				remain.setKind(rs.getString("kind"));
				remain.setDeli(rs.getString("deli"));
				remain.setQuantity(rs.getInt("quantity"));
				remain.setRe_date(rs.getDate("re_date"));
				remainList.add(remain);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return remainList;
	}


	public AdminRemain selectRemain(String order_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminRemain remain = null;
		
		try {
			pstmt = con.prepareStatement("select * from remain where order_num=?");
			pstmt.setString(1, order_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				remain = new AdminRemain(
						rs.getString("order_num"),
						rs.getString("pseq"),
						rs.getString("deli"),
						rs.getInt("quantity"),
						rs.getDate("re_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return remain;
	}

	public int updateRemain(AdminRemain remain) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update remain set pseq=?,deli=?,quantity=? where order_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, remain.getPseq());
			pstmt.setString(2, remain.getDeli());
			pstmt.setInt(3, remain.getQuantity());
			pstmt.setString(4, remain.getOrder_num());

			updateCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}

	public int deleteRemain(String order_num) {
		PreparedStatement pstmt = null;
		String remain_delete_sql="delete from remain where order_num=?";
		int deleteCount=0;
		
		try {
			pstmt=con.prepareStatement(remain_delete_sql);
			pstmt.setString(1, order_num);
			deleteCount=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

	public int selectListCount(String rOption, String rValue) {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql= "select count(*) from totalremainview where ";
		
//		String sql= "select count(*) from remain left join productview on remain.pseq = productview.pseq1 where ";
		if (rOption.equals("order_num")){
			sql += "order_num like ?";
		}else if (rOption.equals("pseq")) {
			sql += "pseq like ?";
		}else if (rOption.equals("name")) {
			sql += "name like ?";
		}else {
			sql += "kind like ?";
		}
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+rValue+"%");
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
