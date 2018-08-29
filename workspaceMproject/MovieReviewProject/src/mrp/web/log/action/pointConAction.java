package mrp.web.log.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.svc.PointContentService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.PayList;

public class pointConAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		String l_name = (String) session.getAttribute("u_name");

		PointContentService pointContentService = new PointContentService();
		ArrayList<PayList> paylist = pointContentService.getPointList(l_name);

		request.setAttribute("paylist", paylist);

		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "pointContent.jsp");
		forward.setUrl("MyPageLayout.jsp");

		return forward;
	}

}
