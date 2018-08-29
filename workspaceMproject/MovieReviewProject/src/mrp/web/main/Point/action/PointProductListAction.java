package mrp.web.main.Point.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.PointProductListService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.PointProduct;

public class PointProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PointProductListService pointProductListService = new PointProductListService();
		ArrayList<PointProduct> pointProductList = pointProductListService.getPointProductList();
		
		request.setAttribute("pointProductList", pointProductList);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "pointProductList.jsp");
		forward.setUrl("MainLayout.jsp");
		
		return forward;
		
	}

}
