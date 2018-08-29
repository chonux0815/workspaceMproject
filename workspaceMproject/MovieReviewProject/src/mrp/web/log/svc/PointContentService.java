package mrp.web.log.svc;

import static mrp.web.db.JdbcUtil.close;
import static mrp.web.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import mrp.web.log.dao.LogDAO;
import mrp.web.vo.PayList;
import mrp.web.vo.User;

public class PointContentService {

	public ArrayList<PayList> getPointList(String l_name) {
		Connection con = getConnection();
		LogDAO logDAO = LogDAO.getInstance();
		logDAO.setConnection(con);
		
		ArrayList<PayList> paylist = logDAO.selectPointList(l_name);
		close(con);
		
		return paylist;
	}
	

}
