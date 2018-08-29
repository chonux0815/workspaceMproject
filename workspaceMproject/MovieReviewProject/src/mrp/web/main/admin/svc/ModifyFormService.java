package mrp.web.main.admin.svc;

import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;

import mrp.web.main.admin.dao.ListDAO;
import mrp.web.vo.User;

public class ModifyFormService {

	public User getmodifyUser(String u_name) {
		Connection con = getConnection();
		ListDAO listDAO = ListDAO.getInstance();
		listDAO.setConnection(con);
		
		User user = listDAO.selectModifyUser(u_name);
		close(con);
		return user;
	}

}
