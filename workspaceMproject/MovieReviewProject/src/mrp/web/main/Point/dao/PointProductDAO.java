package mrp.web.main.Point.dao;

import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mrp.web.vo.PointCart;
import mrp.web.vo.PointProduct;

public class PointProductDAO {
	private Connection con;
	private static PointProductDAO pointProductDAO;

	private PointProductDAO() {

	}

	public static PointProductDAO getInstance() {
		if (pointProductDAO == null) {
			pointProductDAO = new PointProductDAO();
		}
		return pointProductDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;

	}

	public ArrayList<PointProduct> selectPointProductList() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PointProduct> pointProductList = null;

		try {
			String sql = "select * from pointProduct ORDER BY p_point DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pointProductList = new ArrayList<PointProduct>(); // ArrayList??? 객체를 담는다???
			PointProduct pointProduct = null;
			while (rs.next()) {
				pointProduct = new PointProduct();
				pointProduct.setP_id(rs.getString("p_id"));
				pointProduct.setP_division(rs.getString("p_division"));
				pointProduct.setP_name(rs.getString("p_name"));
				pointProduct.setP_image(rs.getString("p_image"));
				pointProduct.setP_point(rs.getInt("p_point"));
				pointProduct.setP_count(rs.getInt("p_count"));
				pointProduct.setP_content(rs.getString("p_content"));
				pointProduct.setP_term(rs.getString("p_term"));
				pointProductList.add(pointProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return pointProductList;
	}

	public PointProduct selectPointProduct(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PointProduct pointProduct = null;

		try {
			String sql = "select * from pointProduct where p_id=?";// 데이터베이스에 추가하기
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			rs = pstmt.executeQuery();

			if (rs.next()) { // 데이터가 여러개가 아니기 때문에 한번만 돌면된다. 그래서 while이 아닌 if
				pointProduct = new PointProduct();
				pointProduct.setP_id(rs.getString("p_id"));
				pointProduct.setP_division(rs.getString("p_division"));
				pointProduct.setP_name(rs.getString("p_name"));
				pointProduct.setP_image(rs.getString("p_image"));
				pointProduct.setP_point(rs.getInt("p_point"));
				pointProduct.setP_count(rs.getInt("p_count"));
				pointProduct.setP_content(rs.getString("p_content"));
				pointProduct.setP_term(rs.getString("p_term"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return pointProduct;
	}

	public int insertPointProduct(PointProduct pointProduct) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		// 내일오면 여기부터하세욤^^
		try {
			String sql = "insert into pointProduct(p_id, p_name, p_image, p_point ,p_content ,p_term) values(pointproduct_seq.nextval,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pointProduct.getP_name()); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			pstmt.setString(2, pointProduct.getP_image()); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			pstmt.setInt(3, pointProduct.getP_point()); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			pstmt.setString(4, pointProduct.getP_content()); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			pstmt.setString(5, pointProduct.getP_term()); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(insertCount);
		return insertCount;

	}

}
