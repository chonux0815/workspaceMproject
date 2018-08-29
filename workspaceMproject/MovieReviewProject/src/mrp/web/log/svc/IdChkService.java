package mrp.web.log.svc;

import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;
import mrp.web.log.dao.LogDAO;
import mrp.web.vo.User;

public class IdChkService {

	

	public boolean idChk(String id) {
		Connection con = getConnection();
		LogDAO logDAO = LogDAO.getInstance();
		logDAO.setConnection(con);
		boolean idExists = false;
		int idCount = logDAO.selectIdCount(id);
		if(idCount == 0) {
			idExists = true;
			
		}
		close(con);
		
		return idExists;
	}
}
