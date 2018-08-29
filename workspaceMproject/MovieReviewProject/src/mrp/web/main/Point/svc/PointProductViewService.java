package mrp.web.main.Point.svc;
import static mrp.web.db.JdbcUtil.*;
import mrp.web.main.Point.dao.PointProductDAO;
import mrp.web.vo.PointProduct;
import java.sql.Connection;
public class PointProductViewService {

	public PointProduct getPointProduct(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();//Ŀ�ؼ� ��ü�� ������ �Ѵ�
		PointProductDAO pointProductDAO = PointProductDAO.getInstance();
		pointProductDAO.setConnection(con);
		
		PointProduct pointProduct = pointProductDAO.selectPointProduct(id); //������� 
		
		close(con);
		return pointProduct;
	}

}
