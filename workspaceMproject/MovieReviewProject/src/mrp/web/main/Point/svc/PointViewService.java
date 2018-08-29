package mrp.web.main.Point.svc;

import java.sql.Connection;
import static mrp.web.db.JdbcUtil.*;

import mrp.web.main.Point.dao.PointDAO;
import mrp.web.vo.PointProduct;

public class PointViewService {

	public PointProduct getPoint(String id) {
		Connection con = getConnection();//Ŀ�ؼ� ��ü�� ������ �Ѵ�
		PointDAO pointDAO = PointDAO.getinstance();
		pointDAO.setConnection(con);
		
		PointProduct point = pointDAO.selectPoint(id); //Dogdao.java ������ ���Ŀ� ���� ����
		close(con);
		return point;
	}

}
