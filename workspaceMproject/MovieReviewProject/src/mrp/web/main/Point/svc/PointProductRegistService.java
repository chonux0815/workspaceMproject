package mrp.web.main.Point.svc;

import java.sql.Connection;

import static mrp.web.db.JdbcUtil.*;
import mrp.web.main.Point.dao.PointProductDAO;
import mrp.web.vo.PointProduct;

public class PointProductRegistService {

	public boolean registPointProduct(PointProduct pointProduct) {
		boolean registSuccess = false;
		Connection con = getConnection();
		PointProductDAO pointProductDAO = PointProductDAO.getInstance();
		pointProductDAO.setConnection(con);
		
		int insertCount = pointProductDAO.insertPointProduct(pointProduct);
		
		if(insertCount>0) {
			commit(con);
			registSuccess = true;
			
		}
		else {
			rollback(con);
		}
		close(con);
		return registSuccess;
	}

}
