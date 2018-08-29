package mrp.web.main.admin.dao;

import static mrp.web.db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mrp.web.vo.User;

public class ListDAO {
	private static Connection con;
	private static ListDAO listDAO;

	public ListDAO() {

	}

	public static ListDAO getInstance() {
		if (listDAO == null) {
			listDAO = new ListDAO();
		}
		return listDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public ArrayList<User> selectUserList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User adminuserlist = null;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			String sql = "select * from Users";

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				adminuserlist = new User();
				adminuserlist.setU_id(rs.getString("u_id"));
				adminuserlist.setU_name(rs.getString("u_name"));
				adminuserlist.setU_email(rs.getString("u_email"));
				adminuserlist.setU_gender(rs.getInt("u_gender"));
				adminuserlist.setU_day(rs.getString("u_day"));
				adminuserlist.setU_passwd(rs.getString("u_passwd"));
				adminuserlist.setU_division(rs.getInt("u_division"));
				adminuserlist.setU_point(rs.getInt("u_point"));
				userList.add(adminuserlist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return userList;

	}

	public int deleteUserList(String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {// 실행
			pstmt = con.prepareStatement("delete from Users where u_id = ?");
			// ?개수만큼 값 지정
			pstmt.setString(1, id);
			result = pstmt.executeUpdate(); // 쿼리실행으로 삭제된 레코드 수 반환

		} catch (Exception e) {
			
		} finally {
			close(pstmt);
		}

		return result;
	}
	public User selectModifyUser(String u_name) {
		System.out.println(u_name);
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM users WHERE u_name = ?");
			pstmt.setString(1, u_name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setU_id(rs.getString("u_id"));
				user.setU_passwd(rs.getString("u_passwd"));
                user.setU_name(rs.getString("u_name"));
                user.setU_email(rs.getString("u_email"));
                user.setU_point(rs.getInt("u_point"));
			}
		} catch (Exception e) {
          e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return user;
	}
	public int modifyUser(User user, String b_name) {
		int modifyCount = 0;
		PreparedStatement pstmt = null;
		System.out.println(user.getU_name() + user.getU_id() + user.getU_passwd() + user.getU_point() + b_name);
        try {
				String sql = "UPDATE users SET u_id = ?,u_name = ?,u_email = ?,u_passwd= ?,u_point = ? WHERE u_name = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getU_id());
				pstmt.setString(2, user.getU_name());
				pstmt.setString(3, user.getU_email());
				pstmt.setString(4, user.getU_passwd());
				pstmt.setInt(5, user.getU_point());
				pstmt.setString(6, b_name);
				modifyCount = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
        return modifyCount;
	}
}