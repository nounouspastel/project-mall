package dao;

import java.sql.*;
import java.util.ArrayList;
import vo.Product;
import static db.JdbcUtil.*;

public class ProductDAO {

	Connection con;
	private static ProductDAO productDAO;
	
	private ProductDAO() {
		
	}
	
	public static ProductDAO getInstance() {
		
		if(productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
		
	}

	public ArrayList<Product> selectAdminProductList(String kind) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Product> productList = null;
		
		try {
			pstmt = con.prepareStatement("select * from product left join remainview on product.pseq = remainview.pseq1 where kind=? and quantity > 0");
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				productList = new ArrayList<Product>();	
				
				do {
					productList.add(new Product(
							rs.getString("pseq"),
							rs.getString("name"),
							rs.getString("kind"),
							rs.getInt("price_in"),
							rs.getInt("price_out"),
							rs.getString("content"),
							rs.getInt("quantity"),
							rs.getString("image"),
							rs.getDate("indate")));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return productList;
	}

	public ArrayList<Product> selectProductList() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Product> productList = null;
		
		try {
			pstmt = con.prepareStatement("select * from product");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				productList = new ArrayList<Product>();	
				
				do {
					productList.add(new Product(
							rs.getString("pseq"),
							rs.getString("name"),
							rs.getString("kind"),
							rs.getInt("price_in"),
							rs.getInt("price_out"),
							rs.getString("content"),
							rs.getInt("quantity"),
							rs.getString("image"),
							rs.getDate("indate")));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return productList;
	}

	public Product selectProduct(String pseq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			pstmt = con.prepareStatement("select * from product left join remainview on product.pseq = remainview.pseq1 where pseq=?");
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				product = new Product(
						rs.getString("pseq"),
						rs.getString("name"),
						rs.getString("kind"),
						rs.getInt("price_in"),
						rs.getInt("price_out"),
						rs.getString("content"),
						rs.getInt("quantity"),
						rs.getString("image"),
						rs.getDate("indate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return product;
	}

}
