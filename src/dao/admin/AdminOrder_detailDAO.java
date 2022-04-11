package dao.admin;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.admin.AdminOrder_detail;

public class AdminOrder_detailDAO {
	
	Connection con;
	private static AdminOrder_detailDAO order_detailDAO;
	
	private AdminOrder_detailDAO() {
		
	}	
	

	public static AdminOrder_detailDAO getInstance() {
		if(order_detailDAO == null) {
			order_detailDAO = new AdminOrder_detailDAO();
		}
		return order_detailDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;		
		}

	public int selectOrder_detailListCount(String odOption, String odValue) {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select count(*) from order_detail left join product_order_detailview on order_detail.pseq = product_order_detailview.pseq1 left join member_order_detailview on order_detail.id = member_order_detailview.id1 where ";
		if (odOption.equals("odseq")){
			sql += "odseq like ?";
		}else if (odOption.equals("id")) {
			sql += "id like ?";
		}else if (odOption.equals("idname")) {
			sql += "idname like ?";
		}else if (odOption.equals("pseq")) {
			sql += "pseq like ?";
		}else if (odOption.equals("deli")) {
			sql += "deli like ?";
		}else if (odOption.equals("address1")) {
			sql += "address1 like ?";
		}else if (odOption.equals("address2")) {
			sql += "address2 like ?";
		}else if (odOption.equals("vip")) {
			sql += "vip like ?";
		}
		
				
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+odValue+"%");
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

	public ArrayList<AdminOrder_detail> selectAdminOrder_detailList(int page, int limit, String odOption, String odValue) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String order_detail_list_sql="select * from order_detail left join product_order_detailview on order_detail.pseq = product_order_detailview.pseq1 left join member_order_detailview on order_detail.id = member_order_detailview.id1 where ";
		if (odOption.equals("odseq")){
			order_detail_list_sql += "odseq like ? ";
		}else if(odOption.equals("id")) {
			order_detail_list_sql += "id like ? ";
		}else if(odOption.equals("idname")) {
			order_detail_list_sql += "idname like ? ";
		}else if(odOption.equals("pseq")) {
			order_detail_list_sql += "pseq like ? ";
		}else if(odOption.equals("deli")) {
			order_detail_list_sql += "deli like ? ";
		}else if(odOption.equals("address1")) {
			order_detail_list_sql += "address1 like ? ";
		}else if(odOption.equals("address2")) {
			order_detail_list_sql += "address2 like ? ";
		}else if(odOption.equals("vip")) {
			order_detail_list_sql += "vip like ? ";
		}
		
		order_detail_list_sql += " order by odseq asc limit ?,?";
		ArrayList<AdminOrder_detail> order_detailList=new ArrayList<AdminOrder_detail>();
		AdminOrder_detail order_detail=null;
		int startrow=(page-1)*limit;//읽기 시작할 row번호

		try {

			pstmt=con.prepareStatement(order_detail_list_sql);
			pstmt.setString(1, "%"+odValue+"%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				order_detail=new AdminOrder_detail();
				order_detail.setOdseq(rs.getString("odseq"));
				order_detail.setId(rs.getString("id"));
				order_detail.setPseq(rs.getString("pseq"));
				order_detail.setQuantity(rs.getInt("quantity"));
				order_detail.setDeli(rs.getString("deli"));
				order_detail.setIndate(rs.getDate("indate"));
				order_detail.setName(rs.getString("name"));
				order_detail.setKind(rs.getString("kind"));
				order_detail.setPrice_in(rs.getInt("price_in"));
				order_detail.setPrice_out(rs.getInt("price_out"));
				order_detail.setIdname(rs.getString("idname"));
				order_detail.setAddress1(rs.getString("address1"));
				order_detail.setAddress2(rs.getString("address2"));
				order_detail.setPhone(rs.getString("phone"));
				order_detail.setVip(rs.getString("vip"));
				order_detailList.add(order_detail);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(order_detailList);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return order_detailList;
	}


	public AdminOrder_detail selectOrder_detail(String odseq, String pseq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminOrder_detail order_detail = null;
		
		try {
			pstmt = con.prepareStatement("select * from order_detail where odseq=? and pseq=?");
			pstmt.setString(1, odseq);
			pstmt.setString(2, pseq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				order_detail = new AdminOrder_detail(
						rs.getString("odseq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return order_detail;
	}


	public int updateOrder_detail(AdminOrder_detail order_detail, String pseq) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update order_detail set odseq=?,deli=? where odseq=? and pseq=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_detail.getOdseq());
			pstmt.setString(2, order_detail.getDeli());
			pstmt.setString(3, order_detail.getOdseq());
			pstmt.setString(4, pseq);
			
			updateCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}


	public int deleteOrder_detail(String odseq, String pseq) {
		PreparedStatement pstmt = null;
		String order_detail_delete_sql="delete from order_detail where odseq=? and pseq=?";
		int deleteCount=0;
		
		try {
			pstmt=con.prepareStatement(order_detail_delete_sql);
			pstmt.setString(1, odseq);
			pstmt.setString(2, pseq);
			deleteCount=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

}
