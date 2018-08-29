package mrp.web.main.Point.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.PointCartQtyDownService;
import mrp.web.vo.ActionForward;

public class PointCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String p_name = request.getParameter("p_name");
		
		PointCartQtyDownService pointCartQtyDownService = new PointCartQtyDownService();
		pointCartQtyDownService.downQty(request, p_name);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("PointCartList.po");
		forward.setRedirect(true);
		
		return forward;
	}

}