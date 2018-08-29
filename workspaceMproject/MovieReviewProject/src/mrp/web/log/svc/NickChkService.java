package mrp.web.log.svc;

import static mrp.web.db.JdbcUtil.close;
import static mrp.web.db.JdbcUtil.getConnection;

import java.sql.Connection;

import mrp.web.log.dao.LogDAO;

public class NickChkService {

	public boolean nickChk(String nickname) {
		Connection con = getConnection();
		LogDAO logDAO = LogDAO.getInstance();
		logDAO.setConnection(con);
		boolean nickExists = false;
		int nickCount = logDAO.selectNickCount(nickname);
		if(nickCount == 0) {
			nickExists = true;
			
		}
		close(con);
		
		return nickExists;
	}

}
