package mrp.web.main.Point.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.PointCartListService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Cart;

public class PointCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PointCartListService pointCartListService = new PointCartListService();
		ArrayList<Cart> cartList = pointCartListService.getCartList(request);
		ActionForward forward = null;
		int totalMoney = 0;
		for (int i = 0; i < cartList.size(); i++) {
			totalMoney += cartList.get(i).getP_point() * cartList.get(i).getQty();
		}
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		forward = new ActionForward();
		request.setAttribute("form_menu", "pointCartList.jsp");
		forward.setUrl("MainLayout.jsp");
		return forward;
	}

}
