package mrp.web.main.admin.svc;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import static mrp.web.db.JdbcUtil.*;

import mrp.web.main.admin.dao.ListDAO;
import mrp.web.vo.User;

public class AdminListService {

	public ArrayList<User> selectList() {
		Connection con = getConnection();
		ListDAO listDAO = ListDAO.getInstance();
		listDAO.setConnection(con);
		
		ArrayList<User> userList = listDAO.selectUserList();
		close(con);
		
		return userList;
	}
}
