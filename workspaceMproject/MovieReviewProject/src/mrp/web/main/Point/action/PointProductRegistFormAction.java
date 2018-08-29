package mrp.web.main.Point.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.vo.ActionForward;

public class PointProductRegistFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "pointProductEdit.jsp");
		forward.setUrl("MainLayout.jsp");
		
		return forward;
	}

}
