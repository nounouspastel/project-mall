package svc.Product;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Product;

public class ProductDetailService {

	public Product getsProductDetail(String pseq) {

		Product product = new Product();
		Connection con = null;

		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);

			product = productDAO.selectProduct(pseq);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				close(con);
		}

		return product;
	}

	public ArrayList<Product> getProductList() {
		ArrayList<Product> productList =null;
		Connection con = null;
		try {
		con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		productList = productDAO.selectProductList();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)
				close(con);
		}
		return productList;
	}

}
