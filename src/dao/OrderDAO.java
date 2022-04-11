package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.sql.DataSource;

import vo.Cart;
import vo.Order_Detail;

public class OrderDAO {
	public static OrderDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public OrderDAO() {}
	
	public static OrderDAO getInstance() {
		if(instance == null) {
			instance = new OrderDAO();
		}
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	//insert 문
	public int payment(Order_Detail orderDetail, ArrayList<Cart> cartList) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		try {
			for(int i = 0; i < cartList.size(); i++) {
//				System.out.println(cartList.get(i).getPseq());
			sql = "insert into order_detail(odseq,id,pseq,quantity) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, orderDetail.getOdseq());
			pstmt.setString(2, orderDetail.getId());
			pstmt.setString(3, cartList.get(i).getPseq());
			pstmt.setInt(4, cartList.get(i).getQuantity());
			insertCount = pstmt.executeUpdate();
		}
		}catch(SQLException e) {
			System.out.println("order_detail 에러 : " + e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<Order_Detail> selectOrderDetail(String id,String odseq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order_Detail> orderDetail = null;
		String sql = "";
		try {
			sql = "select od.*, img.image from orderprice od "
					+ " left outer join productimageview img "
					+ " on od.pseq = img.pseq where id = ? and odseq = ? ;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, odseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderDetail = new ArrayList<Order_Detail>();
				do {
					orderDetail.add(new Order_Detail(
							rs.getString("odseq"),
							rs.getString("id"),
							rs.getString("pseq"),
							rs.getString("name"),
							rs.getInt("quantity"),
							rs.getInt("totalprice"),
							rs.getString("deli"),
							rs.getString("indate"),
							rs.getString("image")));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return orderDetail;
	}

	public ArrayList<Order_Detail> selectOrderList(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order_Detail> orderList = null;
		String sql = "";
		try {
			sql = "select odseq, id, sum(quantity) as quantity, "
					+ "pseq, name, deli,indate, sum(totalprice) as totalprice "
					+ "from orderprice where id = ? group by odseq order by indate desc;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderList = new ArrayList<Order_Detail>();
				do {
					orderList.add(new Order_Detail(
							rs.getString("odseq"),
							rs.getString("deli"),
							rs.getString("name"),
							rs.getInt("quantity"),
							rs.getString("pseq"),
							rs.getInt("totalprice"),
							rs.getString("id"),
							rs.getString("indate")));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}

	public ArrayList<Order_Detail> selectTodayList(String id, String today) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order_Detail> orderDetail = null;
		String sql = "";
		try {
			sql = "select od.*, img.image from orderprice od "
					+ " left outer join productimageview img "
					+ " on od.pseq = img.pseq "
					+ " where id = ? and odseq like ? "
					+ " order by indate desc limit 100;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, today);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderDetail = new ArrayList<Order_Detail>();
				do {
					orderDetail.add(new Order_Detail(
							rs.getString("odseq"),
							rs.getString("id"),
							rs.getString("pseq"),
							rs.getString("name"),
							rs.getInt("quantity"),
							rs.getInt("totalprice"),
							rs.getString("deli"),
							rs.getString("indate"),
							rs.getString("image")));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return orderDetail;
	}

	public ArrayList<Order_Detail> selectDelivery(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order_Detail> orderDelivery = null;
		String sql = "";
		try {
			sql = "select od.odseq, od.id, od.pseq,"
					+ " sum(quantity) as quantity, od.deli, od.indate,"
					+ " sum(totalprice) as totalprice ,"
					+ " od.name, od.kind, od.price_in, od.price_out ,"
					+ " img.image from orderprice od "
					+ " left outer join productimageview img "
					+ " on od.pseq = img.pseq where id = ?"
					+ " and deli not like '배송완료' "
					+ " group by odseq order by indate desc limit 100;";
					pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderDelivery = new ArrayList<Order_Detail>();
				do {
					orderDelivery.add(new Order_Detail(
							rs.getString("odseq"),
							rs.getString("id"),
							rs.getString("pseq"),
							rs.getString("name"),
							rs.getInt("quantity"),
							rs.getInt("totalprice"),
							rs.getString("deli"),
							rs.getString("indate"),
							rs.getString("image")));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return orderDelivery;
	}

	public ArrayList<Order_Detail> selectDateSearchList(String id, String startdate, String enddate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order_Detail> orderList = null;
		String sql = "";
		try {
			sql = "select odseq, id, sum(quantity) as quantity,"
					+ " pseq, name, deli,indate, sum(totalprice) as totalprice "
					+ " from orderprice where id = ? and "
					+ " indate between ? and ? group by odseq order by indate desc;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, startdate);
			pstmt.setString(3, enddate);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderList = new ArrayList<Order_Detail>();
				do {
					orderList.add(new Order_Detail(
							rs.getString("odseq"),
							rs.getString("deli"),
							rs.getString("name"),
							rs.getInt("quantity"),
							rs.getString("pseq"),
							rs.getInt("totalprice"),
							rs.getString("id"),
							rs.getString("indate")));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}

	public ArrayList<Order_Detail> selectOrderCategoryList(String id, String deli) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order_Detail> orderList = null;
		String sql = "";
		try {
			sql = "select odseq, id, sum(quantity) as quantity,"
					+ " pseq, name, deli,indate, sum(totalprice) as totalprice"
					+ " from orderprice "
					+ " where id = ? and deli = ? group by odseq order by indate desc;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, deli);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				orderList = new ArrayList<Order_Detail>();
				do {
					orderList.add(new Order_Detail(
							rs.getString("odseq"),
							rs.getString("deli"),
							rs.getString("name"),
							rs.getInt("quantity"),
							rs.getString("pseq"),
							rs.getInt("totalprice"),
							rs.getString("id"),
							rs.getString("indate")));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}

	public int orderCancell(String pseq, String id, String odseq) {
		PreparedStatement pstmt = null;
		int cancellCount = 0;
		String sql = "";
		try {
			sql = "delete from order_detail where pseq = ? and id = ? and odseq = ? ;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseq);
			pstmt.setString(2, id);
			pstmt.setString(3, odseq);
			cancellCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return cancellCount;
	}
}
