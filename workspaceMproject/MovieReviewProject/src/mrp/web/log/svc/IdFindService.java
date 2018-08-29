package mrp.web.log.svc;

import java.sql.Connection;
import java.util.ArrayList;

import mrp.web.log.dao.LogDAO;

import static mrp.web.db.JdbcUtil.*;
import mrp.web.vo.User;

public class IdFindService {
	public String idFind(String name,String day,String email) {
	      // TODO Auto-generated method stub
	      Connection con = getConnection();
	      LogDAO logDAO = LogDAO.getInstance();
	      logDAO.setConnection(con);
	      
	      
	      String logList = logDAO.selectIdLog(name,day,email);
	      close(con);
	      return logList;
	   }
	   
}
