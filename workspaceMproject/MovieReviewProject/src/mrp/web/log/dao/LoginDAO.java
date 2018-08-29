package mrp.web.log.dao;

import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import mrp.web.vo.User;

public class LoginDAO {
	// singleton 패턴사용
	private static LoginDAO loginDAO;
	private Connection con;

	private LoginDAO() {

	}

	public static LoginDAO getinstance() {
		if (loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public User selectLoginID(String u_id, String u_passwd) {
		User user = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT u_name, u_division, u_point FROM users WHERE u_id = ? and u_passwd = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_passwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setU_name(rs.getString("u_name"));
				user.setU_division(rs.getInt("u_division"));
				user.setU_point(rs.getInt("u_point"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return user;
	}
}
