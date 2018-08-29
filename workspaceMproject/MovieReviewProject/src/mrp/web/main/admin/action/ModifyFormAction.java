package mrp.web.main.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.main.admin.svc.ModifyFormService;
import mrp.web.main.admin.svc.ModifyProService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String u_name = request.getParameter("u_name");
		
		ModifyFormService modifyFormService = new ModifyFormService();
		User user = modifyFormService.getmodifyUser(u_name);
		
		HttpSession session = request.getSession(false);
		session.setAttribute("be_name", u_name);
		request.setAttribute("user", user);

		ActionForward forward = new ActionForward();
		forward.setUrl("modifyForm.jsp");

		return forward;
	}
}
