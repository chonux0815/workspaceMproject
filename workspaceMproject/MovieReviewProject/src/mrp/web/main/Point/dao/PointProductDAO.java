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
			pointProductList = new ArrayList<PointProduct>(); // ArrayList??? ��ü�� ��´�???
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
			String sql = "select * from pointProduct where p_id=?";// �����ͺ��̽��� �߰��ϱ�
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // �ش���̵� �������ִ� ������ ������ �����ؿͶ�!
			rs = pstmt.executeQuery();

			if (rs.next()) { // �����Ͱ� �������� �ƴϱ� ������ �ѹ��� ����ȴ�. �׷��� while�� �ƴ� if
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
		// ���Ͽ��� ��������ϼ���^^
		try {
			String sql = "insert into pointProduct(p_id, p_name, p_image, p_point ,p_content ,p_term) values(pointproduct_seq.nextval,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pointProduct.getP_name()); // �ش���̵� �������ִ� ������ ������ �����ؿͶ�!
			pstmt.setString(2, pointProduct.getP_image()); // �ش���̵� �������ִ� ������ ������ �����ؿͶ�!
			pstmt.setInt(3, pointProduct.getP_point()); // �ش���̵� �������ִ� ������ ������ �����ؿͶ�!
			pstmt.setString(4, pointProduct.getP_content()); // �ش���̵� �������ִ� ������ ������ �����ؿͶ�!
			pstmt.setString(5, pointProduct.getP_term()); // �ش���̵� �������ִ� ������ ������ �����ؿͶ�!

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
