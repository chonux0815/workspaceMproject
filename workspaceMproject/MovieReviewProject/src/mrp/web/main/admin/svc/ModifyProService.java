package mrp.web.main.admin.svc;

import java.sql.Connection;
import static mrp.web.db.JdbcUtil.*;

import mrp.web.main.admin.dao.ListDAO;
import mrp.web.vo.User;

public class ModifyProService {

	public boolean modifyuser(User user, String b_name) {
		boolean modifySuccess = false;
		Connection con = getConnection();
		ListDAO listDAO = ListDAO.getInstance();
		listDAO.setConnection(con);

		int updateCount = listDAO.modifyUser(user, b_name);
		if (updateCount > 0) {
			modifySuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return modifySuccess;
	}

}
