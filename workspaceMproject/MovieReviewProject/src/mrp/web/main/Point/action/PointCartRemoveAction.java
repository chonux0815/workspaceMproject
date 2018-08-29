package mrp.web.main.Point.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.PointCartRemoveService;
import mrp.web.vo.ActionForward;

public class PointCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String[] names = request.getParameterValues("delete1");
		PointCartRemoveService pointCartRemoveService = new PointCartRemoveService();
		pointCartRemoveService.removeCart(request,names);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setUrl("PointCartList.po");
		return forward;
	}
}