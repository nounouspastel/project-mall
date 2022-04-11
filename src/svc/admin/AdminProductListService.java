package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.admin.AdminProductDAO;
import vo.admin.AdminProduct;

public class AdminProductListService {

	public int getproductListCount(String pOption, String pValue) {
		int listCount=0;
		Connection con = null;
		try {
			con=getConnection();
			AdminProductDAO productDAO=AdminProductDAO.getInstance();
			productDAO.setConnection(con);
			listCount=productDAO.selectListCount(pOption, pValue);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return listCount;
	}

	public ArrayList<AdminProduct> getproductList(int page, int limit, String pOption, String pValue) {
		ArrayList<AdminProduct> productList=null;
		Connection con = null;
		try {
			con= getConnection();
			AdminProductDAO productDAO=AdminProductDAO.getInstance();
			productDAO.setConnection(con);
			productList=productDAO.selectAdminProductList(page,limit,pOption,pValue);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return productList;
	}

}
