package mrp.web.log.svc;
import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;

import mrp.web.log.dao.LogDAO;
import mrp.web.vo.User;

public class PointCkService {

	public User getpointCk(String u_name) {

		Connection con = getConnection();
		LogDAO logDAO = LogDAO.getInstance();
		logDAO.setConnection(con);

		User user = logDAO.pointUse(u_name);
		close(con);
		
		return user;

	}

}
