package mrp.web.main.Point.dao;
import static mrp.web.db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mrp.web.vo.PayList;
import mrp.web.vo.PointProduct;
public class PointDAO {

	private Connection con;
	private static PointDAO pointDAO;
	
	private PointDAO() {
		
	}
	public static PointDAO getinstance() {
		if(pointDAO == null ) {
			pointDAO = new PointDAO();
		}
		return pointDAO;
	}
	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	
	}
	
	public PointProduct selectPoint(String id) {
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		PointProduct point = null;

		try{
			String sql="select * from pointproduct where p_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id); //�ش���̵� �������ִ� ������ ������ �����ؿͶ�!
			rs =pstmt.executeQuery();
			
			if(rs.next()){ //�����Ͱ� �������� �ƴϱ� ������ �ѹ��� ����ȴ�. �׷��� while�� �ƴ� if
				point = new PointProduct();
				point.setP_id(rs.getString("p_id"));
				point.setP_name(rs.getString("p_name"));
				point.setP_point(rs.getInt("p_point"));
				point.setP_image(rs.getString("p_image"));
				point.setP_division(rs.getString("p_division"));
				point.setP_count(rs.getInt("p_count"));
				
				// points.add(point); ���� �ʿ䰡 ����. �ѹ��� ���Ŵϱ�. �׷��� if����ѰŰ�. ����?
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(rs);
		}
		return point;
	}
	
	public int insertMember(PayList payList) {
		int insertMem = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO payList(l_num, l_name, l_kind, l_point, l_qty)"
				+ "VALUES(PayList_seq.nextval,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, payList.getL_name());
			pstmt.setString(2, payList.getL_kind());
			pstmt.setInt(3, payList.getL_point());
			pstmt.setString(4, payList.getL_qty());
			

			insertMem = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return insertMem;
	}

	public int updatePoint(int updateMoney, String u_name) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
        
        try {
				String sql = "UPDATE users SET u_point=? WHERE u_name = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, updateMoney);
				pstmt.setString(2, u_name);
				updateCount = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
        return updateCount;
	}
}
