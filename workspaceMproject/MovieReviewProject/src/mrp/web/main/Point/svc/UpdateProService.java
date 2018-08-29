package mrp.web.main.Point.svc;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static mrp.web.db.JdbcUtil.*;
import mrp.web.main.Point.dao.PointDAO;
import mrp.web.vo.Cart;
import mrp.web.vo.PayList;

public class UpdateProService {

	public PayList updatePay(HttpServletRequest request) {
		int updatePoint = 0;
		Connection con = getConnection();
		PointDAO pointDAO = PointDAO.getinstance();
		pointDAO.setConnection(con);
		boolean joinSuccess = false;
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		HttpSession session = request.getSession(false);
		String u_name = (String) session.getAttribute("u_name");
		String totalMoney = request.getParameter("totalMoney");
		cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		int u_point = (Integer) session.getAttribute("u_point");
		String totalPay = "";
		String totalQty = "";
		int totalPoint = 0;
		PayList payList = new PayList();
		payList.setL_point(Integer.parseInt(totalMoney));
		payList.setL_name(u_name);
		if (cartList == null) {
			totalPay = (String) request.getAttribute("p_name");
			totalQty = "1";
		} else {
			for (int i = 0; i < cartList.size(); i++) {
				if (i > 0) {
					totalPay += " , ";
					totalQty += " , ";
				}
				totalPay += cartList.get(i).getP_name();
				totalQty += cartList.get(i).getQty();
			}
		}
		payList.setL_kind(totalPay);
		payList.setL_qty(totalQty);
		totalPoint = u_point - Integer.parseInt(totalMoney);
		int insertMem = pointDAO.insertMember(payList);
		if (insertMem > 0) {
			updatePoint = pointDAO.updatePoint(u_point - Integer.parseInt(totalMoney), u_name);
		}
		if (updatePoint > 0) {
			session.setAttribute("u_point", totalPoint);
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return payList;
	}

}
