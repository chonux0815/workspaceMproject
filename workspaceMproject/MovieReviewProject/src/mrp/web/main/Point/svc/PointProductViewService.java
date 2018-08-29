package mrp.web.main.Point.svc;
import static mrp.web.db.JdbcUtil.*;
import mrp.web.main.Point.dao.PointProductDAO;
import mrp.web.vo.PointProduct;
import java.sql.Connection;
public class PointProductViewService {

	public PointProduct getPointProduct(String id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();//커넥션 개체를 만들어야 한다
		PointProductDAO pointProductDAO = PointProductDAO.getInstance();
		pointProductDAO.setConnection(con);
		
		PointProduct pointProduct = pointProductDAO.selectPointProduct(id); //문장생성 
		
		close(con);
		return pointProduct;
	}

}
