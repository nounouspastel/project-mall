package dao.admin;

import java.sql.*;
import java.util.ArrayList;

import vo.admin.AdminProduct;
import static db.JdbcUtil.*;

public class AdminProductDAO {

	Connection con;
	private static AdminProductDAO productDAO;
	
	private AdminProductDAO() {
		
	}
	
	public static AdminProductDAO getInstance() {
		
		if(productDAO == null) {
			productDAO = new AdminProductDAO();
		}
		return productDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;		
	}

	public ArrayList<AdminProduct> selectAdminProductList(int page, int limit, String pOption, String pValue) {

		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String product_list_sql="select * from product left join remainview on product.pseq = remainview.pseq1 where ";
		if (pOption.equals("pseq")){
			product_list_sql += "pseq like ? ";
		}else if(pOption.equals("name")) {
			product_list_sql += "name like ? ";
		}else if(pOption.equals("kind")) {
			product_list_sql += "kind like ? ";
		}else if(pOption.equals("price_in")) {
			product_list_sql += "price_in like ? ";
		}else if(pOption.equals("price_out")) {
			product_list_sql += "price_out like ? ";
		}else if(pOption.equals("quantity")) {
			product_list_sql += "quantity like ? ";
		}else if(pOption.equals("indate")) {
			product_list_sql += "indate like ? ";
		}
		
		product_list_sql += " order by pseq asc limit ?,?";
		ArrayList<AdminProduct> productList=new ArrayList<AdminProduct>();
		AdminProduct product=null;
		int startrow=(page-1)*limit;//읽기 시작할 row번호

		try {

			pstmt=con.prepareStatement(product_list_sql);
			pstmt.setString(1, "%"+pValue+"%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				product=new AdminProduct();
				product.setPseq(rs.getString("pseq"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setPrice_in(rs.getInt("price_in"));
				product.setPrice_out(rs.getInt("price_out"));
				product.setContent(rs.getString("content"));
				product.setImage(rs.getString("image"));
				product.setQuantity(rs.getInt("quantity"));
				product.setIndate(rs.getDate("indate"));
				productList	.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return productList;
	}

	public int insertProduct(AdminProduct product) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		try {
			sql = "insert into product(pseq, name, kind, price_in, price_out, content, image) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getPseq());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getKind());
			pstmt.setInt(4, product.getPrice_in());
			pstmt.setInt(5, product.getPrice_out());		
			pstmt.setString(6, product.getContent());
			pstmt.setString(7, product.getImage());
			insertCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}

	public AdminProduct selectProduct(String pseq) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminProduct product = null;
		
		try {		
			pstmt = con.prepareStatement("select * from product where pseq=?");
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				product = new AdminProduct(
						rs.getString("pseq"),
						rs.getString("name"),
						rs.getString("kind"),
						rs.getInt("price_in"),
						rs.getInt("price_out"),
						rs.getString("content"),
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

	public int deleteProduct(String pseq) {
		
		PreparedStatement pstmt = null;
		String product_delete_sql="delete from product where pseq=?";
		int deleteCount=0;
		
		try {
			pstmt=con.prepareStatement(product_delete_sql);
			pstmt.setString(1, pseq);
			deleteCount=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

	public int updateProduct(AdminProduct product) {

		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update product set pseq=?,name=?,kind=?,price_in=?,price_out=?,content=?,image=? where pseq=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getPseq());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getKind());
			pstmt.setInt(4, product.getPrice_in());
			pstmt.setInt(5, product.getPrice_out());
			pstmt.setString(6, product.getContent());
			pstmt.setString(7, product.getImage());
			pstmt.setString(8, product.getPseq());
			updateCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateCount;
	}

	public int selectListCount(String pOption, String pValue) {
		int listCount=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql= "select count(*) from product left join remainview on product.pseq = remainview.pseq1 where ";
		if (pOption.equals("pseq")){
			sql += "pseq like ?";
		}else if (pOption.equals("name")) {
			sql += "name like ?";
		}else if (pOption.equals("kind")) {
			sql += "kind like ?";
		}else if (pOption.equals("price_in")) {
			sql += "price_in like ?";
		}else if (pOption.equals("price_out")) {
			sql += "price_out like ?";
		}else if (pOption.equals("quantity")) {
			sql += "quantity like ?";
		}else if (pOption.equals("indate")) {
			sql += "indate like ?";
		}
				
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+pValue+"%");
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
