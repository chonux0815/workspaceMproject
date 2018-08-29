package mrp.web.log.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.svc.PointCkService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class pointChkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/* String u_id = request.getParameter("u_id"); */

		HttpSession session = request.getSession(false);
		String u_name = (String) session.getAttribute("u_name");

		PointCkService pointCkService = new PointCkService();
		User user = pointCkService.getpointCk(u_name);

		request.setAttribute("user", user);

		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "pointChk.jsp");
		forward.setUrl("MyPageLayout.jsp");

		return forward;
	}

}
/*
 * System.out.println("action"); HttpSession session =
 * request.getSession(false); String u_name =
 * (String)session.getAttribute("u_name"); UpdateFormService updateFormService =
 * new UpdateFormService(); User user = updateFormService.getUpdateUser(u_name);
 * System.out.println(user.getU_id()); System.out.println(user.getU_passwd());
 * request.setAttribute("user", user);
 * 
 * ActionForward forward = new ActionForward();
 * forward.setUrl("updateForm.jsp");
 * 
 * return forward; }
 */