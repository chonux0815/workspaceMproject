package mrp.web.main.Point.svc;

import java.sql.Connection;
import java.util.ArrayList;
import mrp.web.main.Point.dao.*;
import static mrp.web.db.JdbcUtil.*;
import mrp.web.vo.*;
public class PointProductListService {
	public ArrayList<PointProduct> getPointProductList() {
		Connection con = getConnection();
		PointProductDAO pointProductDAO = PointProductDAO.getInstance();
		pointProductDAO.setConnection(con);
		
		ArrayList<PointProduct> pointProductList = pointProductDAO.selectPointProductList();
		close(con);
		return pointProductList;
	}

}
