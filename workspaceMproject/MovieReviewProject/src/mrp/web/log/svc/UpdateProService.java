package mrp.web.log.svc;

import java.sql.Connection;
import static mrp.web.db.JdbcUtil.*;
import mrp.web.log.dao.LogDAO;
import mrp.web.vo.User;

public class UpdateProService {

	public boolean updateuser(User user) {
		
		boolean updateSuccess = false;
		Connection con = getConnection();
		LogDAO logDAO = LogDAO.getInstance();
		logDAO.setConnection(con);
		
		int updateCount = logDAO.updateUser(user);
		if(updateCount >0) {
			updateSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		
		return updateSuccess;
	}

}
