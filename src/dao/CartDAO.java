package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import vo.Cart;
import vo.Product;

public class CartDAO {
	public static CartDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	public CartDAO() {
	}
	public static CartDAO getInstance() {
		if (instance == null) {
			instance = new CartDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int cartAdd(Cart cart) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		try {
			sql = "insert into cart(overlap,id, pseq, name, kind, price_out, quantity) values(?,?,?,?,?,?,?)"
					+ " ON DUPLICATE KEY UPDATE "
					+ " quantity = quantity + ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cart.getOverlap());
			pstmt.setString(2, cart.getId());
			pstmt.setString(3, cart.getPseq());
			pstmt.setString(4, cart.getName());
			pstmt.setString(5, cart.getKind());
			pstmt.setInt(6, cart.getPrice_out());
			pstmt.setInt(7, cart.getQuantity());
			pstmt.setInt(8, cart.getQuantity());
			insertCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	public ArrayList<Cart> selectAllCartList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cart> cartList = null;
		try {
			pstmt = con.prepareStatement("select ct.*, img.image from cart ct left outer join productimageview img on ct.pseq = img.pseq;");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cartList = new ArrayList<Cart>();
				
				do {
					cartList.add(new Cart(
							rs.getString("overlap"),
							rs.getString("id"),
							rs.getString("pseq"),
							rs.getString("name"),
							rs.getString("image"),
							rs.getString("kind"),
							rs.getInt("price_out"),
							rs.getInt("quantity")));
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return cartList;
	}
	public ArrayList<Cart> selectCartList(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cart> cartList = null;
		try {
			pstmt = con.prepareStatement("select ct.*, img.image from cart ct left outer join productimageview img on ct.pseq = img.pseq where id = ? ;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cartList = new ArrayList<Cart>();
				do {
				cartList.add(new Cart(
						rs.getString("overlap"),
						rs.getString("id"),
						rs.getString("pseq"),
						rs.getString("image"),
						rs.getString("name"),
						rs.getString("kind"),
						rs.getInt("price_out"),
						rs.getInt("quantity")));
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cartList;
	}

	public int deleteCart(String pseq, String id) {
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement("delete from cart where pseq = ? and id = ?");
			pstmt.setString(1, pseq);
			pstmt.setString(2, id);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}
	public int updateQty(int quantity, String pseq) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update cart set quantity = ? where pseq = ?");
			pstmt.setInt(1, quantity);
			pstmt.setString(2, pseq);
			updateCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	public int deleteCartId(String id) {
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement("delete from cart where id = ?");
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteCount;
	}
	public ArrayList<Cart> selectQuantityList(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cart> cartList = null;
		try {
			pstmt = con.prepareStatement("select buy.*, img.image from "
					+ " buyresult buy left outer join "
					+ " productimageview img on buy.pseq = img.pseq where id = ? ;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cartList = new ArrayList<Cart>();
				do {
				cartList.add(new Cart(
						rs.getString("overlap"),
						rs.getString("id"),
						rs.getString("pseq"),
						rs.getString("image"),
						rs.getString("name"),
						rs.getString("kind"),
						rs.getInt("price_out"),
						rs.getInt("quantity"),
						rs.getInt("totalremain")));
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cartList;
	}
	public ArrayList<Cart> selectCartListByQuantity(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cart> cartList = null;
		try {
			pstmt = con.prepareStatement("select buy.*, img.image from buyresult buy left outer join productimageview img on buy.pseq = img.pseq where id = ? and quantity < totalremain ;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cartList = new ArrayList<Cart>();
				do {
				cartList.add(new Cart(
						rs.getString("overlap"),
						rs.getString("id"),
						rs.getString("pseq"),
						rs.getString("image"),
						rs.getString("name"),
						rs.getString("kind"),
						rs.getInt("price_out"),
						rs.getInt("quantity")));
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cartList;
	}
}
	