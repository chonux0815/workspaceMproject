package mrp.web.log.svc;

import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mrp.web.log.dao.LoginDAO;
import mrp.web.vo.User;

public class LoginService {

	public User login(String u_id, String u_passwd) {
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getinstance();
		loginDAO.setConnection(con);

		User loginName = loginDAO.selectLoginID(u_id, u_passwd);
		
		close(con);
		return loginName;
	}
}