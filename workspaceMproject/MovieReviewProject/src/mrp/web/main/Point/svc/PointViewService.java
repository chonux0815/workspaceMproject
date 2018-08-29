package mrp.web.main.Point.svc;

import java.sql.Connection;
import static mrp.web.db.JdbcUtil.*;

import mrp.web.main.Point.dao.PointDAO;
import mrp.web.vo.PointProduct;

public class PointViewService {

	public PointProduct getPoint(String id) {
		Connection con = getConnection();//커넥션 개체를 만들어야 한다
		PointDAO pointDAO = PointDAO.getinstance();
		pointDAO.setConnection(con);
		
		PointProduct point = pointDAO.selectPoint(id); //Dogdao.java 생성한 이후에 문장 생성
		close(con);
		return point;
	}

}
