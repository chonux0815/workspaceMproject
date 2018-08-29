package mrp.web.main.Point.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.CartAddService;
import mrp.web.main.Point.svc.PointCartListService;
import mrp.web.main.Point.svc.PointViewService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.PointProduct;

public class PointCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		String id = request.getParameter("id");
		PointViewService pointViewService = new PointViewService();
		PointProduct point = pointViewService.getPoint(id);
				
	    CartAddService cartAddService = new CartAddService();
		
	    cartAddService.addCart(request,point);
		
	    ActionForward forward = new ActionForward();
		forward.setUrl("PointCartList.po");
		forward.setRedirect(true);
		return forward;
	}

}
