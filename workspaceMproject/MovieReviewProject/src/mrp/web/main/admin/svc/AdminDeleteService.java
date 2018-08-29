package mrp.web.main.admin.svc;

import static mrp.web.db.JdbcUtil.*;

import java.sql.Connection;

import mrp.web.main.admin.dao.ListDAO;

public class AdminDeleteService {

	public boolean deleteProcess(String u_id) {
		boolean success = false;
		Connection con = getConnection();
		ListDAO listDAO = new ListDAO();
		listDAO.setConnection(con);

		int successint = listDAO.deleteUserList(u_id);
		
		if(successint > 0 ) {
			success = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return success;
	}

}
