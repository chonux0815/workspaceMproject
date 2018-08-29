package mrp.web.log.svc;

import static mrp.web.db.JdbcUtil.getConnection;
import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;

import mrp.web.log.dao.LogDAO;
import mrp.web.vo.User;

public class JoinProcessService {

	public boolean join(User user) {
		boolean joinSuccess = false;
		Connection con = getConnection();
		LogDAO logDAO = LogDAO.getInstance();
		logDAO.setConnection(con);
		
		int insertMem = logDAO.insertMember(user);
		if(insertMem > 0) {
			joinSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		close(con);
		
		return joinSuccess;
	}

}
