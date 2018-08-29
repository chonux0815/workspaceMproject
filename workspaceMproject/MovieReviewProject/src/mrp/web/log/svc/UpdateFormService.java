package mrp.web.log.svc;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import static mrp.web.db.JdbcUtil.*;
import mrp.web.log.dao.LogDAO;
import mrp.web.vo.User;

public class UpdateFormService {

	public User getUpdateUser(String u_name) {
		Connection con = getConnection();
		LogDAO logDAO = LogDAO.getInstance();
		logDAO.setConnection(con);
		
		User user = logDAO.selectUpdateUser(u_name);
		close(con);
		return user;
	}

}
