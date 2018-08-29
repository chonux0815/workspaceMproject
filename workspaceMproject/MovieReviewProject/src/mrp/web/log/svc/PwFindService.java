package mrp.web.log.svc;

import java.sql.Connection;
import java.util.ArrayList;

import mrp.web.log.dao.LogDAO;

import static mrp.web.db.JdbcUtil.*;
import mrp.web.vo.User;

public class PwFindService {
	public User pwFind(String id,String hint) {
	      // TODO Auto-generated method stub
	      Connection con = getConnection();
	      LogDAO logDAO = LogDAO.getInstance();
	      logDAO.setConnection(con);
	      
	      
	      User logList = logDAO.selectPwLog(id,hint);
	      close(con);
	      return logList;
	   }
	   
}
