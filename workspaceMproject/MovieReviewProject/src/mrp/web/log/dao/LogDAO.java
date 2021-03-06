package mrp.web.log.dao;

import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import mrp.web.vo.PayList;
import mrp.web.vo.User;

public class LogDAO {
	// singleton 패턴사용
	private static LogDAO logDAO;
	private Connection con;

	private LogDAO() {

	}

	public static LogDAO getInstance() {
		if (logDAO == null) {
			logDAO = new LogDAO();
		}
		return logDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectIdLog(String name, String day, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user = null;

		try {
			String sql = "select u_id from Users where u_name=? and u_day=? and u_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			pstmt.setString(2, day); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			pstmt.setString(3, email); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			rs = pstmt.executeQuery();

			if (rs.next()) { // 데이터가 여러개가 아니기 때문에 한번만 돌면된다. 그래서 while이 아닌 if
				user = rs.getString("u_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return user;
	}
	public int insertMember(User article) {
		int insertMem = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO USERS(u_id, u_passwd, u_name, u_email, u_gender, u_division,u_point, u_hint, u_day)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, article.getU_id());
			pstmt.setString(2, article.getU_passwd());
			pstmt.setString(3, article.getU_name());
			pstmt.setString(4, article.getU_email());
			pstmt.setInt(5, article.getU_gender());
			pstmt.setInt(6, 1);
			pstmt.setInt(7, 0);
			pstmt.setString(8, article.getU_hint());
			pstmt.setString(9, article.getU_day());

			insertMem = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return insertMem;
	}
	public User selectPwLog(String id, String hint) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();

		try {
			String sql = "select u_passwd, u_email from Users where u_id=? and u_hint=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!
			pstmt.setString(2, hint); // 해당아이디를 가지고있는 도그의 정보를 추적해와라!

			rs = pstmt.executeQuery();

			if (rs.next()) { // 데이터가 여러개가 아니기 때문에 한번만 돌면된다. 그래서 while이 아닌 if
				user.setU_passwd(rs.getString("u_passwd"));
				user.setU_email(rs.getString("u_email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(user.getU_email() + user.getU_passwd());
		return user;
	}
public int selectIdCount(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int idCount = 0;

		try {
			String sql = "select COUNT(*) from Users where u_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				idCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return idCount;
	}

	public int selectNickCount(String nickname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int nickCount = 0;
        System.out.println(nickname);
		try {
			String sql = "select COUNT(*) from Users where u_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickname);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				nickCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return nickCount;
	}
	public User selectUpdateUser(String u_name) {
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
                user.setU_gender(rs.getInt("u_gender"));
                user.setU_division(rs.getInt("u_division"));
                user.setU_jang(rs.getString("u_jang"));
                user.setU_gume(rs.getString("u_gume"));
                user.setU_point(rs.getInt("u_point"));
                user.setU_hint(rs.getString("u_hint"));
                user.setU_day(rs.getString("u_day"));
                
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

	public int updateUser(User user) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
        
        try {
				String sql = "UPDATE users SET u_passwd = ? WHERE u_name = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getU_passwd());
				pstmt.setString(2, user.getU_name());
				updateCount = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
        return updateCount;
	}public User pointUse(String u_name) {

		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM users WHERE u_name = ?");
			pstmt.setString(1, u_name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setU_id(rs.getString("u_id"));
				user.setU_point(rs.getInt("u_point"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return user;
	}
	public ArrayList<PayList> selectPointList(String l_name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PayList paylist = null;
		ArrayList<PayList> plist = new ArrayList<PayList>();
		try {
			String sql = "select * from paylist where l_name = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, l_name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				paylist = new PayList();
				paylist.setL_name(rs.getString("l_name"));
				paylist.setL_kind(rs.getString("l_kind"));
				paylist.setL_point(rs.getInt("l_point"));
				paylist.setL_qty(rs.getString("l_qty"));
				plist.add(paylist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return plist;

	}
	
}
